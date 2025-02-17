package com.shanuka_spring.shanuka_spring_3.repository;

import com.shanuka_spring.shanuka_spring_3.dto.UserDto;
import com.shanuka_spring.shanuka_spring_3.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    @Query("SELECT u FROM User u WHERE LOWER(u.userName) = LOWER(:userName)")
    Optional<User> findByUserName(@Param("userName") String userName);


}
