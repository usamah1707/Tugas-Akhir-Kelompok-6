package com.apap.TA.repository;
import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apap.TA.model.JadwalJagaModel;

public interface JadwalJagaDb extends JpaRepository <JadwalJagaModel,  Long>{
	Optional <JadwalJagaModel> findById (long id);
	Optional <JadwalJagaModel> findByTanggal (Date tanggal);

}
