package com.db.PayAmigo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.lang.annotation.Native;
import java.util.Objects;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @JsonIgnore
    @OneToOne(mappedBy = "user_id")
    private Wallet wallet;
    @Column(name = "name", nullable = false)
    String name;
    @Column(name = "email",unique = true, nullable = false)
    String email;
    @Column(name = "password", nullable = false)
    String password;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return getId() == user.getId() && Objects.equals(getWallet(), user.getWallet()) && Objects.equals(getName(), user.getName()) && Objects.equals(getEmail(), user.getEmail()) && Objects.equals(getPassword(), user.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getWallet(), getName(), getEmail(), getPassword());
    }
}
