package com.project.nail.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.nail.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer>{

	/**
	* {@link Users#get
	* @param loginId
	* @return
	*/
	public Users findByLoginId(String loginId);
}