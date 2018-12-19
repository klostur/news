package vp.spring.rcs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vp.spring.rcs.data.KategorijaRepository;
import vp.spring.rcs.model.Kategorija;

@Service
public class KategorijaService {
	@Autowired
	KategorijaRepository kategorijaRepository;

	public List<Kategorija> findAll() {
		return kategorijaRepository.findAll();
	}

	public Kategorija findOne(Long id) {
		return kategorijaRepository.findOne(id);
	}

	public Kategorija findByNaziv(String naziv) {
		return kategorijaRepository.findByNaziv(naziv);
	}
	
}
