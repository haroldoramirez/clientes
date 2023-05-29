package br.com.haroldo.clientes;

import br.com.haroldo.clientes.model.entity.Cliente;
import br.com.haroldo.clientes.model.repository.ClienteRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClientesApplication {

	@Bean
	public CommandLineRunner run(@Autowired ClienteRespository respository) {
		return args -> {

			Cliente cliente = Cliente.builder()
					.cpf("20183675606").nome("Teste Cliente Aplicação").build();

			respository.save(cliente);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(ClientesApplication.class, args);
	}

}
