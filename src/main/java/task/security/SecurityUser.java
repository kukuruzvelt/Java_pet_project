package task.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import task.models.dao.RoleDAO;
import task.models.entity.User;

import java.util.Collection;
import java.util.List;

@Component
public class SecurityUser implements UserDetails {

    @Autowired
    private RoleDAO roleDAO;

    public String username;
    private String password;
    private List<SimpleGrantedAuthority> authorityList;
    private boolean isActive;

//    public SecurityUser(String username, String password, List<SimpleGrantedAuthority> authorityList, boolean isActive) {
//        this.username = username;
//        this.password = password;
//        this.authorityList = authorityList;
//        this.isActive = isActive;
//    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorityList;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isActive;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isActive;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isActive;
    }

    @Override
    public boolean isEnabled() {
        return isActive;
    }

    public UserDetails fromUser(User user){
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                true, true, true, true,
                roleDAO.roleToAuthorityList(new RoleDAO().getRole(user.getRole_id()).get()));
    }
}
