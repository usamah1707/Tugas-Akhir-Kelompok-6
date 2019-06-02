package com.apap.TA.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apap.TA.model.JadwalJagaModel;
import com.apap.TA.model.StaffModel;

@Repository
public interface JadwalJagaDb extends JpaRepository<JadwalJagaModel, Long>{
	List <JadwalJagaModel> findByStaff (StaffModel staff);
	JadwalJagaModel findById (int id);	
	
	

}
