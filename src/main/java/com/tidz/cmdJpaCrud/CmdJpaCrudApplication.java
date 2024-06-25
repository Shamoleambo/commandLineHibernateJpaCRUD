package com.tidz.cmdJpaCrud;

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
			saveNewNeighbor(neighborDAO);
		};
	}

	private void saveNewNeighbor(NeighborDAO dao) {
		Neighbor neighbor = new Neighbor("Mano", "Silva", "mano@mail.com", "123, Mano do Bem Ave.");

		dao.save(neighbor);
		System.out.println("Saved in the db the following entity: " + neighbor);
	}

}
