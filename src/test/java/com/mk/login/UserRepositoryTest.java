package com.mk.login;

import com.mk.login.model.User;
import com.mk.login.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;


//@RunWith(SpringRunner.class)
//@SpringBootTest
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {

    private UserRepository repo;
    private TestEntityManager entityManager;

    @Autowired
    public UserRepositoryTest(UserRepository repo, TestEntityManager entityManager) {
        this.repo = repo;
        this.entityManager = entityManager;
    }

    @Test
    public void testFindUserByEmail()
    {

        String email= "mxxxxmm@gmail.com";
        User user = repo.findByEmail(email);
        Assertions.assertThat(user).isNotNull();

    }

    @Test
    public void testCreateNewUser(){
        User user = new User();
        user.setEmail("mxxxxmm@gmail.com");
        user.setFirstName("m");
        user.setLastName("K");
        user.setPassword("123");
        repo.save(user);
        User savedUser =repo.save(user);
        User findedUser = entityManager.find(User.class , savedUser.getId());
        Assertions.assertThat(findedUser.getEmail()).isEqualTo(user.getEmail());
    }



}
