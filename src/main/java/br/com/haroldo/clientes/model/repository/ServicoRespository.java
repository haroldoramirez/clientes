package br.com.haroldo.clientes.model.repository;

import br.com.haroldo.clientes.model.entity.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRespository extends JpaRepository<Servico, Integer> {
}
