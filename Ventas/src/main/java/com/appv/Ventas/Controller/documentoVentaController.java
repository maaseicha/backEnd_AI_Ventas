package com.appv.Ventas.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appv.Ventas.Entidad.documentoVentaEntity;
import com.appv.Ventas.Respository.*;

import com.appv.Ventas.Exception.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class documentoVentaController {
	@Autowired
	private documentoVentaRepository documentoVenta;
	
	
	@GetMapping("/facturas")
	public List<documentoVentaEntity>getFacturas(){
		return this.documentoVenta.findAll();
	}
	
	@GetMapping("/buscarFactura/{id}")
	public ResponseEntity<documentoVentaEntity> getFacturaId(@PathVariable(value = "id")ObjectId idfactura )throws ResourceNotFoundException{
		documentoVentaEntity factura= documentoVenta.findById(idfactura);
		return ResponseEntity.ok().body(factura);
	}
	
	@PostMapping("/factura")
	public documentoVentaEntity save(@Valid @RequestBody documentoVentaEntity factura) throws ResourceNotFoundException{
		
		List<documentoVentaEntity> facturas= documentoVenta.findAll();
		String establ="001"; //valor del establecimiento (lugar)
		String caja="002";	//valor numero de caja
		String bus=establ+"-"+caja;
		String nfac,numfac="";
		int cont=0,aux,i;
		System.out.println(bus);
		System.out.println("--------");
		for(i=0;i<facturas.size();i++) {
			documentoVentaEntity documentoVentaEntity = new documentoVentaEntity();
			documentoVentaEntity=(documentoVentaEntity)facturas.get(i);
			
			nfac=documentoVentaEntity.getIdFactura();
			
			nfac=nfac.substring(0,7);
			 System.out.println(nfac);
			if(bus.equals(nfac)) {
				cont++;
				System.out.println(cont);
			}
		}
		cont++;
		aux=cont;
		i=0;
		while(aux!=0) {
			aux/=10;
			i++;
		}
		switch(i) {
			case 1: numfac="000000"+cont; break;
			case 2: numfac="00000"+cont; break;
			case 3: numfac="0000"+cont; break;
			case 4: numfac="000"+cont; break;
			case 5: numfac="00"+cont; break;
			case 6: numfac="0"+cont; break;
			case 7: numfac=""+cont; break;
		}
		nfac=bus+"-"+numfac;
		factura.setIdFactura(nfac);
			
		return this.documentoVenta.save(factura);
	}
	
	@PutMapping("factura/{idfactura}")
	public ResponseEntity<?> updateFactura(@PathVariable(value = "idfactura")ObjectId idfactura,@Valid @RequestBody documentoVentaEntity facturaDetails){
		documentoVentaEntity factura = documentoVenta.findById(idfactura);
		factura.setIdFactura(factura.getIdFactura());
		factura.setFechaVencimiento(facturaDetails.getFechaVencimiento());
		factura.setIVA(facturaDetails.getIVA());
		factura.setTotalVenta(facturaDetails.getTotalVenta());
		factura.setFecha(facturaDetails.getFecha());
		factura.setnPedido(facturaDetails.getnPedido());
		factura.setNombreCliente(facturaDetails.getNombreCliente());
		return ResponseEntity.ok(this.documentoVenta.save(factura));
	}
	
	@DeleteMapping("factura/{idfactura}")
	public Map<String, Boolean> deleteFactura(@PathVariable(value = "idfactura")ObjectId idfactura){
		documentoVentaEntity facturaDelete= documentoVenta.findById(idfactura);
		this.documentoVenta.delete(facturaDelete);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Se elimino la Factura", Boolean.TRUE);
		
		return response;
	}
}

