package vp.spring.rcs.data;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vp.spring.rcs.model.Vest;

@Repository
public interface VestRepository extends JpaRepository<Vest, Long>{

	Page<Vest> findVestByNaslovContainsAndKategorijaId(Pageable page, String naziv,Long kategorijaId);

}
