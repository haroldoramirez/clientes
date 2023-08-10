package br.com.haroldo.clientes.rest;

import br.com.haroldo.clientes.model.entity.Cliente;
import br.com.haroldo.clientes.model.repository.ClienteRespository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
    public Cliente salvar(@RequestBody @Valid Cliente cliente) {
        return respository.save(cliente);
    }

    @GetMapping("{id}")
    public Cliente acharPorId(@PathVariable Integer id) {
        return respository
                .findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id) {
        respository
            .findById(id)
            .map( cliente -> {
                respository.delete(cliente);
                return Void.TYPE;
            }).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }


    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable Integer id, @RequestBody Cliente clienteAtualizado) {
        respository
                .findById(id)
                .map( cliente -> {
                    clienteAtualizado.setId(cliente.getId());
                    return respository.save(clienteAtualizado);
                }).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

}
