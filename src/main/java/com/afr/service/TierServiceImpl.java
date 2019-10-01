package com.afr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.afr.dao.TierDao;
import com.afr.model.Tier;

@Service("tierService")
@Transactional
public class TierServiceImpl implements TierService {
	@Autowired
	private TierDao dao;
	
	@Override
	public void saveTier(Tier tier) {
		dao.saveTier(tier);
	}

	@Override
	public List<Tier> findAllTiers() {
		return dao.findAllTiers();
	}

	@Override
	public void deleteTierByID(int id) {
		dao.deleteTierByID(id);
	}

	@Override
	public Tier findByID(int id) {
		return dao.findByID(id);
	}

	@Override
	public void updateTier(Tier tier) {
		dao.updateTier(tier);
	}
}