package com.in28minutes.restwebService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in28minutes.restwebService.Entity.UsersJPA;
import com.in28minutes.restwebService.users.Users;

@Repository
public interface UsersRepository extends JpaRepository<UsersJPA, Integer> {

}
