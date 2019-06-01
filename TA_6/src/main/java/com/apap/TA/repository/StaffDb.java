package com.apap.TA.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apap.TA.model.StaffModel;

public interface StaffDb extends JpaRepository<StaffModel, Long>{
	List <StaffModel> findById (int id);
	

}
