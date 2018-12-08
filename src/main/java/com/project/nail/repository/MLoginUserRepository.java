package com.project.nail.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.nail.domain.entity.loginuser.custom.MLoginUser;

@Repository
public interface MLoginUserRepository extends JpaRepository<MLoginUser, Long> {

}
