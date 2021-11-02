package must.harvest.harvest.JWT_AUTHENTIFICATION.service;

import must.harvest.harvest.model.Member;
import must.harvest.harvest.repo.MemberRepo;
import must.harvest.harvest.services.HashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Service
public class MyUserDetailsService implements UserDetailsService {
    private final HashService hashService;
    private final MemberRepo memberRepo;


    @Autowired
    public MyUserDetailsService(HashService hashService, MemberRepo memberRepo) {
        this.hashService = hashService;
        this.memberRepo = memberRepo;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String cin) throws UsernameNotFoundException {
        Member member = memberRepo.findMemberByCIN_2(Long.valueOf(cin));

        if (member != null) {
            Set<GrantedAuthority> authorities = new HashSet<>();
            if (Objects.equals(cin, "admin")) {
                authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            } else {
                authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
            }
            return new org.springframework.security.core.userdetails.User(member.getCIN().toString(), member.getPassword(), authorities);
        } else {
            throw new UsernameNotFoundException("User " + cin + " not found!");
        }
    }
}
