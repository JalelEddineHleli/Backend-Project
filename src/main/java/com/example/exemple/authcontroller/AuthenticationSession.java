package com.example.exemple.authcontroller;
import com.example.exemple.Entities.authEntities.appuser;
import com.example.exemple.repository.authrepo.appuserrepo;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/this")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthenticationSession {
    private  final  authservice authservice;





@PostMapping( "/register")
    public ResponseEntity<AuthnticationResponse> registeruser
        (@RequestBody RegisterRequest registerRequest) {
         return ResponseEntity.ok(authservice.register(registerRequest));

    }
    @PostMapping("/login")
    public  ResponseEntity<AuthnticationResponse>  loginruser
            (@RequestBody AuthenticationRequest authenticationRequest) {
        return ResponseEntity.ok(authservice.authenticate(authenticationRequest));

    }
}

