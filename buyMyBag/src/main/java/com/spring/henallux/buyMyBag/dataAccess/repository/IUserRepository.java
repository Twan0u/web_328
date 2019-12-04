package com.spring.henallux.buyMyBag.dataAccess.repository;

import com.spring.henallux.buyMyBag.dataAccess.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, String> {
    UserEntity findByUsername(String username);
}
