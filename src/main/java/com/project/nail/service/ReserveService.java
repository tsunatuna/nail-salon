package com.project.nail.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.nail.Repository.ReserveRepository;
import com.project.nail.entity.Reserve;

@Service
public class ReserveService {

	@Autowired
	private ReserveRepository reserveRepository;

	public List<Reserve> findAll() {
		return reserveRepository.findAll();
	}

	public Optional<Reserve> findById(String id) {
		return reserveRepository.findById(id);
	}

	public Reserve save(Reserve reserve) {
		return reserveRepository.save(reserve);
	}

	public void delete(String id) {
		reserveRepository.deleteById(id);
	}
}