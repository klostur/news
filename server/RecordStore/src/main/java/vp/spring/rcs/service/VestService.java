package vp.spring.rcs.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import vp.spring.rcs.data.VestRepository;
import vp.spring.rcs.model.Vest;

@Service
public class VestService {
	@Autowired
	VestRepository vestRepository;

	public Page<Vest> findAll(Pageable page) {
		return vestRepository.findAll(page);
	}

	public Page<Vest> findFiltered(Pageable page, String naziv, Long kategorijaId) {
		return vestRepository.findVestByNaslovContainsAndKategorijaId(page,naziv,kategorijaId);
	}

	public Vest findOne(Long id) {
		return vestRepository.findOne(id);
	}

	public Vest save(Vest vest) {
		return vestRepository.save(vest);
	}

	public void remove(Long id) {
		vestRepository.delete(id);
		
	}

	

	
}
