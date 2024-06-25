package com.tidz.cmdJpaCrud.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tidz.cmdJpaCrud.entity.Neighbor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
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

	@Override
	public Neighbor findById(int id) {
		Neighbor neighbor = this.entityManager.find(Neighbor.class, id);
		return neighbor;
	}

	@Override
	public List<Neighbor> findAll() {
		TypedQuery<Neighbor> query = this.entityManager.createQuery("FROM Neighbor ORDER BY lastName DESC",
				Neighbor.class);
		return query.getResultList();
	}

	@Override
	public List<Neighbor> findBy(String firstName) {
		TypedQuery<Neighbor> query = this.entityManager.createQuery("FROM Neighbor WHERE firstName=:laranja", Neighbor.class);
		query.setParameter("laranja", firstName);
		return query.getResultList();
	}
}
