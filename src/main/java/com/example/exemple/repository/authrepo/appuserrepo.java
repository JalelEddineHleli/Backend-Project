package com.example.exemple.repository.authrepo;

import com.example.exemple.Entities.authEntities.appuser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface appuserrepo extends JpaRepository<appuser, String> {
    appuser findByUsername(String username);
}
