package comunity.carcomunity.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.LinkedList;

public class SimpleUserDetails implements UserDetails {

    private Member member;

    public SimpleUserDetails(Member member) {
        this.member = member;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<SimpleGrantedAuthority> result = new LinkedList<>();

        if(member.getGrade() >= 1) {
            result.add(new SimpleGrantedAuthority("ROLE_USER"));
        }

        if(member.getGrade() >= 3) {
            result.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }

        return null;
    }

    @Override
    public String getPassword() {
        return member.getPassword();
    }

    @Override
    public String getUsername() {
        return member.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
