package de.kreuzwerker.cdc.userservice;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactBroker;
import au.com.dius.pact.provider.junit.loader.PactBrokerAuth;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;
import au.com.dius.pact.provider.spring.SpringRestPactRunner;
import au.com.dius.pact.provider.spring.target.SpringBootHttpTarget;
import java.util.Date;
import java.util.UUID;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@RunWith(SpringRestPactRunner.class)
@Provider("user-service")
//@PactFolder("/Users/rio/Documents/RioApps/CDC/cdc-with-pact-master/messaging-app/target/pacts")
//@PactBroker(host = "localhost", port = "80")
@PactBroker(host = "riosun269.pactflow.io", scheme = "https", authentication = @PactBrokerAuth(scheme = "Bearer", username = "FMGUYGlb1IMOAnLCBUNmOQ", password = ""), tags = "${pact.tags}")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MockedUserServiceContractTest {

    @TestTarget
    public final Target target = new SpringBootHttpTarget();

    @MockBean
    private UserService userService;

    @State("User 1 exists")
    public void user1Exists() {
        when(userService.findUser(any())).thenReturn(User.builder()
            .id("1")
            .legacyId(UUID.randomUUID().toString())
            .name("Beth")
            .role(UserRole.ADMIN)
            .lastLogin(new Date())
            .friend(Friend.builder().id("2").name("Ronald Smith").build())
            .friend(Friend.builder().id("3").name("Matt Spencer").build())
            .build());
    }

    @State("User 2 does not exist")
    public void user2DoesNotExist() {
        when(userService.findUser(any())).thenThrow(NotFoundException.class);
    }

}

