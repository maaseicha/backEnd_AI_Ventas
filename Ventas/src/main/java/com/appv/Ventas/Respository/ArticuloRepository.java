package com.appv.Ventas.Respository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.appv.Ventas.Entidad.articulo;

@Repository
public interface ArticuloRepository extends MongoRepository<articulo,String> {
	articulo findByNombreArticulo(String nombreArticulo);
	boolean existsByNombreArticulo(String nombreArticulo);
}
