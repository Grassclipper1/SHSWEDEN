package com.example.SHSWEDEN;

import com.example.SHSWEDEN.Entities.User;
import com.example.SHSWEDEN.Repos.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;

import java.util.List;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
	UserRepository userRepository;
	@Test
	public void contextLoads() {
	}

    @Test
    void injectedComponentsAreNotNull(){
        Assert.isTrue(userRepository != null, "");
    }

    @Test
    void WhenNewUserCreated_ThenDbHasCreatedRecord() {
        //Arrange
        User userToCreate = new User("Kalle", "Karlsson", "LillFlugan", "melon", "böle@Karlsson.com", "Drottninggatan", "55555");

        //Act
        userRepository.save(userToCreate);

        //Assert
        Assert.isTrue(userRepository.findByEmailAddress("böle@Karlsson.com").size() == 1 , "");
    }

    @Test
    void WhenValidateUser_ThenReturnFoundUser() {
        //Arrange
        String email = "test@test.com";
        String password = "banan";

        //Act
        List<User> foundUsers = userRepository.findByEmailAddressAndPassword(email, password);

        //Assert
        Assert.isTrue(foundUsers != null,"");
        Assert.isTrue(foundUsers.size() == 1,"");
        Assert.isTrue(foundUsers.get(0).getFirstName().equals("Test"),"");
    }

    @Test
    void WhenGetFirstName_ThenReturnFirstName(){
        //Arrange
        User testuser = new User("Kalle", "Karlsson", "LillFlugan", "melon", "Kalle@Karlsson.com", "Drottninggatan", "55555");

        //Act
        String firstName = testuser.getFirstName();

        //Assert
        Assert.isTrue(firstName.equals("Kalle"),"");
    }

    @Test
    void WhenSetFirstName_ThenUserHasNewFirstName(){
        //Arrange
        User testuser = new User("Kalle", "Karlsson", "LillFlugan", "melon", "Kalle@Karlsson.com", "Drottninggatan", "55555");

        //Act
        testuser.setFirstName("Malin");
        String firstName = testuser.getFirstName();

        //Assert
        Assert.isTrue(firstName.equals("Malin"),"");
    }



}
