package com.shanuka_spring.shanuka_spring_3.repository;

import com.shanuka_spring.shanuka_spring_3.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,String> {
    @Query("SELECT u FROM UserEntity u WHERE LOWER(u.username) = LOWER(:username)")
    Optional<UserEntity> findByUserName(@Param("username") String username);


}
