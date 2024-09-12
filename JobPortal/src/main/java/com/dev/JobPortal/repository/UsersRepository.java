package com.dev.JobPortal.repository;

import com.dev.JobPortal.entity.Users;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Integer> {

    /*
    Query Method Parsing: Spring Data JPA has a powerful mechanism to automatically create queries based on the method names defined in your repository interface. When you define a method like findByEmail, Spring Data JPA interprets this method name and automatically generates the appropriate query for you.
    Method Naming Convention: The method findByEmail follows a specific naming convention. The findBy prefix tells Spring Data JPA that you want to create a query based on a property. In this case, Email is the property name, and findBy indicates that you're looking for a record with a matching email.

Property Resolution: Spring Data JPA looks at the Users entity and checks if it has a property named email. If it finds it, it generates a query like SELECT u FROM Users u WHERE u.email = ?1.

Query Generation: At runtime, Spring Data JPA generates the SQL query based on the method name and executes it against the database.
     */
    // Internal sql : SELECT * FROM users WHERE email = ?;
    Optional<Users> findByEmail(String email);

}
