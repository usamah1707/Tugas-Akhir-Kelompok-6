package com.apap.TA.service;

import java.util.List;
import java.util.Optional;

import com.apap.TA.model.StokLabModel;

public interface StokLabService {

	StokLabModel addStok(StokLabModel stok);

	List<StokLabModel> getAllStokLab();

	Optional<StokLabModel> getDetail(Long id);

}
