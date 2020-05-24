package com.kunezIsme.shopbackend.config;

import com.kunezIsme.shopbackend.entity.RolesEntity;
import com.kunezIsme.shopbackend.entity.UsersEntity;
import com.kunezIsme.shopbackend.repository.RolesRepository;
import com.kunezIsme.shopbackend.repository.UsersRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@Configuration
public class DataSeedingListener implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private RolesRepository rolesRepository;

    @Value("${jwt-key}")
    private String signingKey;

    private void addRoleIfMissing(String name) {
        if (rolesRepository.findByName(name) == null) {
            RolesEntity rolesEntity = new RolesEntity();
            rolesEntity.setName(name);
            rolesRepository.save(rolesEntity);
        }
    }

    private void addUserIfMissing(String username, String password, String... roles) {
        if (usersRepository.findByUserName(username) == null) {

            Set<RolesEntity> roleIsExists = new HashSet<>();
            for (String role : roles) {
                roleIsExists.add(rolesRepository.findByName(role));
            }

            usersRepository.save(UsersEntity.builder().userName(username).password(new BCryptPasswordEncoder().encode(password))
                    .roles(roleIsExists).build());
        }
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        addRoleIfMissing("ROLE_ADMIN");
        addRoleIfMissing("ROLE_MEMBER");

        addUserIfMissing("user", "456", "ROLE_MEMBER");
        addUserIfMissing("admin", "1234", "ROLE_MEMBER", "ROLE_ADMIN");

        if (signingKey == null || signingKey.length() == 0) {
            String jws = Jwts.builder()
                    .setSubject("kunlezIsme")
                    .signWith(SignatureAlgorithm.HS256, "kunlezIsmeApi").compact();

            System.out.println("Use this jwt key:");
            System.out.println("jwt-key=" + jws);
        }
    }
}
