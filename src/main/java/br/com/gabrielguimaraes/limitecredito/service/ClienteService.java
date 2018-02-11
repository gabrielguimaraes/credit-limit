package br.com.gabrielguimaraes.limitecredito.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.gabrielguimaraes.limitecredito.model.Cliente;
import br.com.gabrielguimaraes.limitecredito.repository.ClienteRepository;

@Component
public class ClienteService {
	private ClienteRepository clienteRepository;

	@Autowired
	public ClienteService(final ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	public Collection<Cliente> findAll() {
		return this.clienteRepository.findAll();
	}
	
	public Cliente save(Cliente cliente) {
		cliente.calculaTaxaDeJuros();
		return clienteRepository.save(cliente);
	}
	
	public void delete(Cliente cliente) {
		clienteRepository.delete(cliente);
	}
	
	
}
