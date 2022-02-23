package com.mk.login.repository;

import com.mk.login.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//@Repository
public interface UserRepository extends JpaRepository<User, Long > {

    @Query(value = "Select * from users u where u.email= ?1 ",nativeQuery = true)
    User findByEmail(String email);

//    @Query(
//            value = "SELECT * FROM USER u WHERE u.email = 1",
//            nativeQuery = true)
//    User findByEmail(String email);
}
