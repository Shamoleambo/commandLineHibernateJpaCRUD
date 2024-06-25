package com.tidz.cmdJpaCrud.dao;

import java.util.List;

import com.tidz.cmdJpaCrud.entity.Neighbor;

public interface NeighborDAO {

	public void save(Neighbor neighbor);

	public Neighbor findById(int id);

	public List<Neighbor> findAll();
}
