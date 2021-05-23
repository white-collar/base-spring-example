package com.example.demo3.repository;

import com.example.demo3.persistense.entities.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Integer> {
    boolean existsByUsername(String username);

    User findByUsername(String username);

}
