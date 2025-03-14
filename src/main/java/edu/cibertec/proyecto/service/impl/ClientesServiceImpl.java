package edu.cibertec.proyecto.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import edu.cibertec.proyecto.entity.ClienteEntity;
import edu.cibertec.proyecto.repository.ClientesRepository;
import edu.cibertec.proyecto.service.ClientesService;
@Service
public class ClientesServiceImpl implements ClientesService {
	@Autowired
	ClientesRepository rc;
	
	@Override
	public Page<ClienteEntity> listar(Pageable pageable) {
		return rc.findByEstado(1, pageable);
	}

	@Override
	public ClienteEntity buscarCliente(int codigo) {
		return rc.findById(codigo).orElse(null);
	}

	@Override
	public void eliminarCliente(ClienteEntity obj) {
		ClienteEntity cli = rc.findById(obj.getIdcliente()).orElse(null);
		cli.setEstado(0);
		rc.save(cli);
	}

	@Override
	public void modificarCliente(ClienteEntity obj) {
		ClienteEntity cli = rc.findById(obj.getIdcliente()).orElse(null);
		cli.setIdcliente(obj.getIdcliente());
		cli.setCelular(obj.getCelular());
		cli.setDireccion(obj.getDireccion());
		cli.setRazonsocial(obj.getRazonsocial());
		cli.setRucdni(obj.getRucdni());
		cli.setEstado(1);
		rc.save(cli);
	}

	@Override
	public void crearCliente(ClienteEntity obj) {
		rc.save(obj);
	}

}
