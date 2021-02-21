package com.appv.Ventas.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appv.Ventas.Entidad.articulo;
import com.appv.Ventas.Entidad.pedidoVenta;
import com.appv.Ventas.Respository.PedidoVentaRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/Pedido")
public class PedidoVentaController {
	
	@Autowired
	private PedidoVentaRepository pedido;
	
	@GetMapping("/Listar/")
	public ResponseEntity<?> getPedidos(@RequestParam(required = false) String fechaVenta){		
		try {
			List<pedidoVenta> pedidos = new ArrayList<pedidoVenta>();

		    if (fechaVenta == null)
		      pedido.findAll().forEach(pedidos::add);
		    else
		      pedido.findByFechaVenta(fechaVenta).forEach(pedidos::add);

		    if (pedidos.isEmpty()) {
		      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		    }

		    return new ResponseEntity<>(pedidos, HttpStatus.OK);
		  } catch (Exception e) {
		    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		  }
	}
	
	@PutMapping("/Actualizar/{id}")
	public ResponseEntity<?> actualizarPedido(@PathVariable("id") String id,@Validated @RequestBody pedidoVenta pedidoVenta) {
		Optional<pedidoVenta> pedidoV = pedido.findById(id);
		
		  if (pedidoV.isPresent()) {
		    pedidoVenta pedid = pedidoV.get();
		    pedid.setDescripcion(pedidoVenta.getDescripcion());
		    pedid.setFechaEntrega(pedidoVenta.getFechaEntrega());
		    pedid.setFechaVenta(pedidoVenta.getFechaVenta());
		    pedid.setTotalProductos(pedidoVenta.getTotalProductos());
		    pedid.setArticulos(pedidoVenta.getArticulos());
		    return new ResponseEntity<>(pedido.save(pedid), HttpStatus.OK);
		  } else {
		    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		  }
	}
	
	@PostMapping("/Insertar")
	public ResponseEntity<?> insertarPedido(@RequestBody pedidoVenta pedidoVenta) {
		try {
			List<articulo> art = pedidoVenta.getArticulos();
			float tot = 0;
			for(articulo p:art) {
				tot += p.getPrecioUnitarioArticulo()*p.getCantidadArticulo();
			}
			pedidoVenta pedidoV = pedido.save(new pedidoVenta(pedidoVenta.getNumeroPedido(),pedidoVenta.getFechaEntrega(),tot,
		    		pedidoVenta.getArticulos(),pedidoVenta.getFechaEntrega(),pedidoVenta.getDescripcion()));
		    return new ResponseEntity<>(pedidoV, HttpStatus.CREATED);
		  } catch (Exception e) {
		    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		  }
	}
	
	@DeleteMapping("/Eliminar/{id}")
	public ResponseEntity<?> borrarPedido(@PathVariable("id") String id) {
		try {
		    pedido.deleteById(id);
		    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		  } catch (Exception e) {
		    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		  }
	}
	
	@GetMapping("/Listar/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") String id) {
		Optional<pedidoVenta> pedidoV = pedido.findById(id);
		try {
			return new ResponseEntity<>(pedidoV,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/ListarNombre/{nombre}")
	public ResponseEntity<?> getByNombreProducto(@PathVariable("nombre") String nombre){
		Optional<pedidoVenta> pedidoV = pedido.findByNombreProducto(nombre);
		try {
			return new ResponseEntity<>(pedidoV,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/ListarNumeroPedido/{numeroPedido}")
	public ResponseEntity<?> getByNumeroPedido(@PathVariable("numeroPedido") String numeroPedido){
		try {
			List<pedidoVenta> pedidoV = pedido.findByNumeroPedido(numeroPedido);
			if(pedidoV.isEmpty())
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			else {
				return new ResponseEntity<>(pedidoV,HttpStatus.OK);
			}
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
}
