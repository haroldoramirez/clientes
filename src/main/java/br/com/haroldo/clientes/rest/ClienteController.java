package br.com.haroldo.clientes.rest;

import br.com.haroldo.clientes.model.entity.Cliente;
import br.com.haroldo.clientes.model.repository.ClienteRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteRespository respository;

    @Autowired
    public ClienteController(ClienteRespository respository) {
        this.respository = respository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente salvar(Cliente cliente) {
        return respository.save(cliente);
    }

}
