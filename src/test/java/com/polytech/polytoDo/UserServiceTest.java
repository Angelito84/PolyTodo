package com.polytech.polytoDo;

import com.polytech.polytoDo.business.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureDataJpa
@Transactional
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void should_create_user_and_find_by_username() throws UsernameAlreadyExistsException {

        //GIVEN
        User user1 = new User("user1", "mdp_user1");
        userService.addUser(user1);

        //WHEN
        User user1_find = userService.findByUsername("user1");

        //THEN
        Assert.assertNotNull(user1_find);
        Assert.assertEquals(user1,user1_find);
    }
}
