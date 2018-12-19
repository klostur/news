package vp.spring.rcs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vp.spring.rcs.model.Kategorija;
import vp.spring.rcs.service.KategorijaService;

@RestController
@RequestMapping(value="api/kategorije")
public class KategorijaController {
	@Autowired
	KategorijaService kategorijaService;
	@GetMapping
	public ResponseEntity<List<Kategorija>> findAll() {
		List<Kategorija> retVal = kategorijaService.findAll();
		return new ResponseEntity<List<Kategorija>>(retVal, HttpStatus.OK);
	}
}
