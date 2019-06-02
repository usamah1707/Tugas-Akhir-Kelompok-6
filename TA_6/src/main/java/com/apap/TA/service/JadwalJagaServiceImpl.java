package com.apap.TA.service;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apap.TA.model.JadwalJagaModel;
import com.apap.TA.repository.JadwalJagaDb;
import com.apap.TA.service.JadwalJagaService;

@Service
@Transactional
public class JadwalJagaServiceImpl implements JadwalJagaService{
	
	@Autowired
	private JadwalJagaDb jadwalJagaDb;

	@Override
	public JadwalJagaModel addJadwal(JadwalJagaModel jadwal) {
		// TODO Auto-generated method stub
		return jadwalJagaDb.save(jadwal);
	}

	@Override
	public List<JadwalJagaModel> getAllJadwal() {
		// TODO Auto-generated method stub
		return jadwalJagaDb.findAll();
	}

	@Override
	public Optional<JadwalJagaModel> findByTanggal(Date Tanggal) {
		// TODO Auto-generated method stub
		return jadwalJagaDb.findByTanggal(Tanggal);
	}

	@Override
	public Optional<JadwalJagaModel> getJadwalDetail(int id) {
		// TODO Auto-generated method stub
		return jadwalJagaDb.findById(id);
	}

}
