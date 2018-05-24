package OnlineAuction.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private String email;
    @JsonIgnore
    @OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "user")
    private DescribeOfUser describeOfUser;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "user")
    private List<Plumb> plumbs;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "user")
    private List<Bet> bets;


    @Enumerated(EnumType.STRING)
    private Role role = Role.ROLE_USER;
    private boolean accountNonExpired = true;           //не закінчився срок використання
    private boolean accountNonLocked= true;             //не заблоковано
    private boolean credentialsNonExpired = true;       //повноваження не закінчилися
    private boolean enabled = false;                    //включений
    private boolean allowSendEmail = false;             //дозвіл відправки email повідомлень


    public Collection<? extends GrantedAuthority> getAuthorities() {
        ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(role.name().toString()));
        return authorities;
    }

    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public User() {
    }

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDescribeOfUser(DescribeOfUser describeOfUser) {
        this.describeOfUser = describeOfUser;
    }

    public void setPlumbs(List<Plumb> plumbs) {
        this.plumbs = plumbs;
    }

    public void setBets(List<Bet> bets) {
        this.bets = bets;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setAllowSendEmail(boolean allowSendEmail) {
        this.allowSendEmail = allowSendEmail;
    }

    public int getId() {

        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public DescribeOfUser getDescribeOfUser() {
        return describeOfUser;
    }

    public boolean isAllowSendEmail() {
        return allowSendEmail;
    }

    public List<Plumb> getPlumbs() {
        return plumbs;
    }

    public List<Bet> getBets() {
        return bets;
    }

}
