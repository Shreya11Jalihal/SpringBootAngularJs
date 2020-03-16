package com.springangular.application.SpringAngular.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springangular.application.SpringAngular.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
