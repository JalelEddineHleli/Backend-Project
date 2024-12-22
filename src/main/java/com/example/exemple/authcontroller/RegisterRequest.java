package com.example.exemple.authcontroller;
import com.example.exemple.Entities.authEntities.approle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class RegisterRequest {
    private String email;
    private String password;

}
