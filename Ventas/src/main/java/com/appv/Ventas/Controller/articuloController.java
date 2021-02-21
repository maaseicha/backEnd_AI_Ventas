package com.appv.Ventas.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appv.Ventas.Entidad.articulo;
import com.appv.Ventas.Respository.ArticuloRepository;

@RestController
@RequestMapping("/Producto")
public class articuloController {
	@Autowired
	private ArticuloRepository art;
	
	@GetMapping("/{nombreArticulo}")
	public int getStockNombre(@PathVariable("nombreArticulo") String nombre) {
		if(art.existsByNombreArticulo(nombre)) {
			articulo articulo = art.findByNombreArticulo(nombre);
			return articulo.getCantidadArticulo();
		}
		else
			return 0;
	}
}
