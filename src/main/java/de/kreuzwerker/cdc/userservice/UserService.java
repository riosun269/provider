package de.kreuzwerker.cdc.userservice;

import java.util.Date;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public User findUser(String userId) {
        if (userId.equals("1")){
            return User.builder()
                    .id(userId)
                    .legacyId(UUID.randomUUID().toString())
                    .name("Rio")
                    .role(UserRole.ADMIN)
                    .lastLogin(new Date())
                    .friend(Friend.builder().id("2").name("Ronald Smith").build())
                    .friend(Friend.builder().id("3").name("Matt Spencer").build())
                    .friend(Friend.builder().id("4").name("Rio").build())
                    .build();
        } else {
            return User.builder()
                    .id(userId)
                    .legacyId(UUID.randomUUID().toString())
                    .name("Yuni")
                    .role(UserRole.USER)
                    .lastLogin(new Date())
                    .friend(Friend.builder().id("5").name("David").build())
                    .friend(Friend.builder().id("6").name("Hellen").build())
                    .friend(Friend.builder().id("7").name("Hana").build())
                    .build();
        }
    }
}
