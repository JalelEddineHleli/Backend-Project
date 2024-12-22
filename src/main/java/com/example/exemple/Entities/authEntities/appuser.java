package com.example.exemple.Entities.authEntities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;
import java.util.stream.Collectors;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class appuser  implements UserDetails {
    @Id
   // @GeneratedValue(strategy = GenerationType.AUTO)

    private String id = UUID.randomUUID().toString();
    @Column(unique = true)
    private String username;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<approle> roles;

   /* public <T> appuser(String mail, String password123, List<T> list) {
        this.username = mail;
        this.password = password123;
        this.roles = new ArrayList<>();

    }*/

    @Override

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getNome()))
                .collect(Collectors.toList());
    }


    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }

   /* @PrePersist
    public void prePersist() {
        if (id == null) {
            id = UUID.randomUUID().toString();  // Generate UUID if ID is not provided
        }
    }*/
}
