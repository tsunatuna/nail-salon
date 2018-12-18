package com.project.nail.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.nail.Repository.ReserveRepository;
import com.project.nail.entity.TrnReserves;

@Service
public class ReserveService {

	@Autowired
	private ReserveRepository reserveRepository;

	public List<TrnReserves> findAll() {
		return reserveRepository.findAll();
	}

	public Optional<TrnReserves> findById(String reservedId) {
		return reserveRepository.findById(reservedId);
	}

	public TrnReserves save(TrnReserves trnReserves) {
		return reserveRepository.save(trnReserves);
	}

	public void delete(String reservedId) {
		reserveRepository.deleteById(reservedId);
	}
}