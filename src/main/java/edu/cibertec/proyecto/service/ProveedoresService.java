package edu.cibertec.proyecto.service;

import java.util.List;

import edu.cibertec.proyecto.entity.ProveedorEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProveedoresService {

	public Page<ProveedorEntity> listar(Pageable pageable);
	public ProveedorEntity buscarProveedor(int codigo);
	public void eliminarProveedor(ProveedorEntity obj);
	public void modificarProveedor(ProveedorEntity obj);
	public void crearProveedor(ProveedorEntity obj);
	
}
