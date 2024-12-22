/*package com.example.exemple.authcontroller;

import com.example.exemple.Entities.authEntities.appuser;
import com.example.exemple.repository.authrepo.appuserrepo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class contruser {
    private  final  authservice authservice;

    appuserrepo appuserrepo ;
    @GetMapping()
    public List<appuser> getusers() {

        return appuserrepo.findAll();
    }
}*/
