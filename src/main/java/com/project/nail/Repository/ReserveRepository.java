package com.project.nail.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.nail.entity.Reserve;

@Repository
public interface ReserveRepository extends JpaRepository<Reserve, String> {

}
