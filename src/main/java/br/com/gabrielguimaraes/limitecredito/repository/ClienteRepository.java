package br.com.gabrielguimaraes.limitecredito.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import br.com.gabrielguimaraes.limitecredito.model.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
	Collection<Cliente> findAll();
}
