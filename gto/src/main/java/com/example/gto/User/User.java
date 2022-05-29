package com.example.gto.User;

//import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Set;


//@Getter
//@Setter
//@ToString
@Document
public class User implements UserDetails {

//    @Field("email")
//    @Indexed(unique = true)
//    @NotNull
//    private @Id String email;
//
//    @Field("userName")
//    @Indexed(unique = true)
//    @NotNull
//    private String userName;
//
//    @Field("phoneNum")
//    private String phoneNum;
//
//    @Field("password")
//    @NotNull
//    private String password;
//
//    private Set<UserRole> userRoles;
//
//    protected User() {}
//
//    public User(String userName, String email, String phoneNum, String password) {
//        this.userName = userName;
//        this.email = email;
//        this.phoneNum = phoneNum;
//        this.password = password;
//
//    }
//
//    public User(String username, String password, Set<GrantedAuthority> grantedAuthorities) {
//
//    }
//
//    @Override
//    public String toString() {
//        return String.format(
//                "User[userName=%s, email='%s']",
//                userName, email);
//    }

    private @MongoId ObjectId id;
    private String username;
    private String password;
    private Set<UserRole> userRoles;

    public User() {

    }

    public User(String username, String password, Set<GrantedAuthority> grantedAuthorities) {
    }

    public ObjectId getId() {
        return id;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    @Override
    public Set<UserRole> getAuthorities() {
        return this.userRoles;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
