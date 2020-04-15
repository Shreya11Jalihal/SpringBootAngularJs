package com.springangular.application.SpringAngular.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springangular.application.SpringAngular.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	/*
	 * Query to retrieve a user from the database based on Email Id
	 */
	@Query("SELECT t FROM User t Where t.email=:email ")
	Optional<User> findByEmail(@Param("email") String email);

}
