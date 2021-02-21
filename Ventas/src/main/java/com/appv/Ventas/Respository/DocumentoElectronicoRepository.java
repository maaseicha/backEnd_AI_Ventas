package com.appv.Ventas.Respository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.appv.Ventas.Entidad.documentoElectronico;

@Repository
public interface DocumentoElectronicoRepository extends MongoRepository<documentoElectronico, String>{
	
}
