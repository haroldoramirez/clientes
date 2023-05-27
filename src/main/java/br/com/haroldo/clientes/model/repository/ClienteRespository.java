package br.com.haroldo.clientes.model.repository;

import br.com.haroldo.clientes.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRespository extends JpaRepository<Cliente, Integer> {
}
