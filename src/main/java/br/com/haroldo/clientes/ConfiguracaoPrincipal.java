package br.com.haroldo.clientes;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@Desenvolvimento
public class ConfiguracaoPrincipal {

    @Bean
    public CommandLineRunner executar() {
        return args -> {
            System.out.println("RODANDO NA CONFIGURAÇÃO DE DESENVOLVIMENTO");
        };
    }
}
