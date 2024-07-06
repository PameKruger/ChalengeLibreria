package com.pnegrete.ChallengeLibreria;

import com.pnegrete.ChallengeLibreria.principal.Principal;
import com.pnegrete.ChallengeLibreria.repository.AutorRepository;
import com.pnegrete.ChallengeLibreria.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChallengeLibreriaApplication implements CommandLineRunner {

	@Autowired
	AutorRepository autorRepository;
	@Autowired
	LibroRepository libroRepository;

	public static void main(String[] args) {
		SpringApplication.run(ChallengeLibreriaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(autorRepository,libroRepository);
		principal.principal();
	}

}
