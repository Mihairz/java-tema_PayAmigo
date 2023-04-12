package com.db.PayAmigo.repository;

import com.db.PayAmigo.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findById(int id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE users SET name = :name, email = :email, password = :password WHERE (id = :id);", nativeQuery = true)
    int updateUser(@Param("id") int id,
                   @Param("name") String name,
                   @Param("email") String email,
                   @Param("password") String password);
}
