package com.apap.TA.service;

import java.sql.Date;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.apap.TA.model.JadwalJagaModel;
import com.apap.TA.model.StaffModel;
import com.apap.TA.repository.JadwalJagaDb;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class JadwalJagaServiceImpl implements JadwalJagaService{
	@Autowired 
	private JadwalJagaDb jadwalJagaDb;
	
	@Override
	public void addJadwal(JadwalJagaModel jadwal) {
		// TODO Auto-generated method stub
		jadwalJagaDb.save(jadwal);
		
	}

	@Override
	public JadwalJagaModel findById(int id) {
		// TODO Auto-generated method stub
		return jadwalJagaDb.findById(id);
	}

	@Override
	public List<JadwalJagaModel> getJadwalListByStaff (StaffModel staff) {
		// TODO Auto-generated method stub
		List<JadwalJagaModel> listJaga = jadwalJagaDb.findByStaff(staff);
		return listJaga;
	}
	

}
