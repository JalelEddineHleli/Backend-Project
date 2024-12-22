package com.example.exemple;

import com.example.exemple.Entities.authEntities.approle;
import com.example.exemple.Entities.authEntities.appuser;
import com.example.exemple.repository.authrepo.approlerepo;
import com.example.exemple.repository.authrepo.appuserrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.UUID;

@SpringBootApplication
public class ExempleApplication {
     /*  @Autowired

    private PasswordEncoder passwordEncoder;
    @Bean
    CommandLineRunner commandLineRunner(appuserrepo appuserrepo, approlerepo approlerepo) {
        return args -> {
            approle r1 = approle.builder().nome("ADMIN").build();
            approle r2 = approle.builder().nome("USER").build();


            approlerepo.save(r1);
            approlerepo.save(r2);

            appuser user1 = appuser.builder()
                    .username("jaleleddine.hleli@polytechnicien.tn")
                    .id(UUID.randomUUID().toString())
                    .password(passwordEncoder.encode("password123"))
                    .roles(Arrays.asList(r1))
                    .build();

            appuser user2 = appuser.builder()

                    .username("houssem.brari@polytechnicien.tn")
                    .id(UUID.randomUUID().toString())
                    .password(passwordEncoder.encode("password456"))
                    .roles(Arrays.asList(r2))
                    .build();

            appuser user3 = appuser.builder()

                    .username("foulen1@polytechnicie.tn")
                    .id(UUID.randomUUID().toString())
                    .password(passwordEncoder.encode("password789"))
                    .roles(Arrays.asList( r1,r2))
                    .build();

            appuser user4 = appuser.builder()

                    .username("foulen2@polytechnicie.tn")
                    .id(UUID.randomUUID().toString())
                    .password(passwordEncoder.encode("password10"))
                    .roles(Arrays.asList(r2))
                    .build();

            appuser user5 = appuser.builder()

                    .username("foulen3@polytechnicie.tn")
                    .id(UUID.randomUUID().toString())
                    .password(passwordEncoder.encode("password11"))
                    .roles(Arrays.asList(r2))
                    .build();

            appuserrepo.save(user1);
            appuserrepo.save(user2);
            appuserrepo.save(user3);
            appuserrepo.save(user4);
            appuserrepo.save(user5);


        };
    }*/


    public static void main(String[] args) {
        SpringApplication.run(ExempleApplication.class, args);

    }

    }




