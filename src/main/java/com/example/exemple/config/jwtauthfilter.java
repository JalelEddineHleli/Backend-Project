package com.example.exemple.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Component
@RequiredArgsConstructor
public class jwtauthfilter extends OncePerRequestFilter {
    private final jwtservice jwtservice;
    private final UserDetailsService userDetailsService;


    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull  FilterChain filterChain)
            throws ServletException, IOException {
        final String authHeader = request.getHeader("Authorization");
        final String useremail;
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;

        }
        final String jwt = authHeader.substring(7);
        useremail =jwtservice.extractusername(jwt);
        if(useremail != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            UserDetails userDetails = this.userDetailsService.loadUserByUsername(useremail);
            if(userDetails != null && jwtservice.tokenisvalid(jwt, userDetails)) {
                UsernamePasswordAuthenticationToken authtoken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities()
                );
                authtoken
                        .setDetails(new WebAuthenticationDetailsSource()
                        .buildDetails(request)
                        );
                SecurityContextHolder.getContext().setAuthentication(authtoken);
            }
        }
        filterChain.doFilter(request, response);

    }
}
