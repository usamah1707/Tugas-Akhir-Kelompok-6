package com.apap.TA.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.apap.TA.model.JadwalJagaModel;
@Repository
public interface JadwalJagaDb extends JpaRepository<JadwalJagaModel, Long>{
	List<JadwalJagaModel> findByDate (Date tanggal) ;
	JadwalJagaModel findById (int id);
	
	
	

}
