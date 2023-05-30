package comunity.carcomunity.service;

import comunity.carcomunity.domain.Member;
import comunity.carcomunity.domain.SimpleUserDetails;
import comunity.carcomunity.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service(value = "userDetailsService")
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        Optional<Member> optional = memberRepository.findByEmail(username);
        if(optional.isPresent()) {
            Member member = optional.get();

            UserDetails userDetails = new SimpleUserDetails(member);
            return userDetails;
        } else {
            throw new UsernameNotFoundException(username);
        }
    }
}
