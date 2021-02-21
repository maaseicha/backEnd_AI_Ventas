package com.appv.Ventas.Respository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.appv.Ventas.Entidad.documentoVentaEntity;

@Repository
public interface documentoVentaRepository extends MongoRepository<documentoVentaEntity,String>{
	Boolean existsByIdFactura(String idfac);
	documentoVentaEntity findById(ObjectId idfactura);
	//documentoVentaEntity findByIdFacturaANDIdVendedor(String idesta,String idvend); 
	//documentoVentaEntity findByIdfactura(String idFactura);
	/*@Query(value = "{'documentoVenta.idFactura': ?0}", fields = "{'idFactura' : 0}")
	documentoVentaEntity findByIdFactura(String idfactura);
	List findByIdFacturas(String idFactura);*/
}
