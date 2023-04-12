package com.db.repository;

import com.db.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findById(int id);
    Optional<User> findByName(String name);

    @Modifying
    @Transactional
    @Query(value = "UPDATE users SET name = :name, email = :email, password = :password WHERE (id = :id);", nativeQuery = true)
    int updateUser(@Param("id") int id,
                   @Param("name") String name,
                   @Param("email") String email,
                   @Param("password") String password);
}
