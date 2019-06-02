package com.apap.TA.service;

import java.sql.Date;

import java.util.List;

import com.apap.TA.model.JadwalJagaModel;
import com.apap.TA.model.StaffModel;

public interface JadwalJagaService {
	void addJadwal (JadwalJagaModel jadwal);
	JadwalJagaModel findById (int id);
	List <JadwalJagaModel> getJadwalListByStaff (StaffModel staff);
}
