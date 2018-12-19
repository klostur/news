package vp.spring.rcs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vp.spring.rcs.model.Kategorija;
import vp.spring.rcs.model.Vest;
import vp.spring.rcs.service.KategorijaService;
import vp.spring.rcs.service.VestService;

@RestController
@RequestMapping(value="api/vesti")
public class VestiController {
	@Autowired
	VestService vestService;
	
	@GetMapping
	public ResponseEntity<Page<Vest>> findAllPage(Pageable page) {
		Page<Vest> vesti = vestService.findAll(page);
		return new ResponseEntity<Page<Vest>>(vesti, HttpStatus.OK);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<Vest> findOne(@PathVariable Long id){
		Vest retVal = vestService.findOne(id);
		return new ResponseEntity<Vest>(retVal, HttpStatus.OK);
	}
	@GetMapping(value="/filter")
	public ResponseEntity<Page<Vest>> findFiltered(Pageable page, @RequestParam String name, @RequestParam Long kategorijaId){
		Page<Vest>	vesti = vestService.findFiltered(page,name, kategorijaId);
		return new ResponseEntity<Page<Vest>>(vesti, HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Vest> save(@RequestBody Vest vest){
		Vest retVal = vestService.save(vest);
		return new ResponseEntity<Vest>(retVal, HttpStatus.CREATED);
	}
	@PutMapping(value="/{id}")
	public ResponseEntity<Vest> update(@PathVariable Long id, @RequestBody Vest vest){
		Vest v = vestService.findOne(id);
		v.setNaslov(vest.getNaslov());
		v.setOpis(vest.getOpis());
		v.setSadrzaj(vest.getSadrzaj());
		v.setKategorija(vest.getKategorija());
		v = vestService.save(v);
		return new ResponseEntity<Vest>(v, HttpStatus.ACCEPTED);
	}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		vestService.remove(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
