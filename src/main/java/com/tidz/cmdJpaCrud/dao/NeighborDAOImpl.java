package com.tidz.cmdJpaCrud.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tidz.cmdJpaCrud.entity.Neighbor;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Component
public class NeighborDAOImpl implements NeighborDAO {

	private EntityManager entityManager;

	@Autowired
	public NeighborDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public void save(Neighbor neighbor) {
		this.entityManager.merge(neighbor);
	}
}
