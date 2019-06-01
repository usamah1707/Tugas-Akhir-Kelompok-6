package com.apap.TA.service;

import java.util.Date;
import java.util.List;

import com.apap.TA.model.JadwalJagaModel;

public interface JadwalJagaService {
	void addJadwal (JadwalJagaModel jadwal);
	JadwalJagaModel findById (int id);
	List<JadwalJagaModel> findByDate (Date tanggal);
	List <JadwalJagaModel> findAll();
}
