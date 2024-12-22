package com.example.exemple.authcontroller;
import com.example.exemple.Entities.authEntities.*;
import com.example.exemple.config.*;
import com.example.exemple.repository.authrepo.appuserrepo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.DoubleStream;

@Builder
@Service
@AllArgsConstructor
public class authservice {
    private final appuserrepo appuserrepo;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    private final jwtservice jwtservice;

    public AuthnticationResponse register
            (RegisterRequest registerRequest) {
        approle role = new approle(2,"USER");
        List<approle> roles = new ArrayList<>();
        roles.add(role);
        var user = appuser.builder()
                .id(UUID.randomUUID().toString())
                .username(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .roles(roles)

                .build();
        appuserrepo.save(user);
        var jwttoken = jwtservice.generatetoken
                ( user);


        return AuthnticationResponse.builder()
                .token(jwttoken)
                .build();
    }

    public AuthnticationResponse authenticate
            (AuthenticationRequest authenticationRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken
                        (authenticationRequest.getEmail(),
                                authenticationRequest.getPassword())
        );
        var user = appuserrepo.findByUsername(authenticationRequest.getEmail());
        var jwttoken = jwtservice.generatetoken
                ( user);


        return AuthnticationResponse.builder()
                .token(jwttoken)
                .build();
    }
}
