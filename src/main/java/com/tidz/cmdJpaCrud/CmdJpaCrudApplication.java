package com.tidz.cmdJpaCrud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.tidz.cmdJpaCrud.dao.NeighborDAO;
import com.tidz.cmdJpaCrud.entity.Neighbor;

@SpringBootApplication
public class CmdJpaCrudApplication {

	private NeighborDAO neighborDAO;

	@Autowired
	public CmdJpaCrudApplication(NeighborDAO neighborDAO) {
		this.neighborDAO = neighborDAO;
	}

	public static void main(String[] args) {
		SpringApplication.run(CmdJpaCrudApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(String[] args) {
		return runner -> {
//			saveNewNeighbor(neighborDAO);
//			findSingleNeighborById(neighborDAO);
//			findAllNeighbors(neighborDAO);
//			findAndOrderByFirstName(neighborDAO);
			updateNeighbor(neighborDAO);
		};
	}

	private void saveNewNeighbor(NeighborDAO dao) {
		Neighbor neighbor = new Neighbor("Guri", "Fimeza", "guriFMZ@mail.com", "29, Near St.");

		dao.save(neighbor);
		System.out.println("Saved in the db the following entity: " + neighbor);
	}

	private void findSingleNeighborById(NeighborDAO dao) {
		Neighbor neighbor = dao.findById(1);
		System.out.println("Neighbor with id 1: " + neighbor);
	}

	private void findAllNeighbors(NeighborDAO dao) {
		List<Neighbor> neighbors = dao.findAll();
		System.out.println("Here they are: ");
		for (Neighbor n : neighbors) {
			System.out.println("Neighbor: " + n);
		}
	}

	private void findAndOrderByFirstName(NeighborDAO dao) {
		System.out.println("Find and order by first name: ");

		List<Neighbor> neighbors = dao.findBy("Silva");
		for (Neighbor neighbor : neighbors) {
			System.out.println(neighbor);
		}
	}

	private void updateNeighbor(NeighborDAO dao) {
		System.out.println("Update");

		Neighbor neighbor = dao.update(1);
		System.out.println(neighbor);
	}

}
