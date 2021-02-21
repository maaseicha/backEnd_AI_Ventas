package com.appv.Ventas.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.bson.BsonDocument;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.data.mongodb.gridfs.ReactiveGridFsTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.appv.Ventas.Entidad.documentoElectronico;
import com.appv.Ventas.Respository.DocumentoElectronicoRepository;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.gridfs.model.GridFSFile;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import com.mongodb.client.gridfs.GridFSFindIterable;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsCriteria;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/Factura")
public class DocumentoElectronicoController {
	@Autowired 
	private GridFsOperations gridFsOperations;
	
	@Autowired
	private GridFsTemplate gridFsTemplate;
	
	@Autowired
	private GridFSBucket gridFsBucket;
	@Autowired
	private DocumentoElectronicoRepository documentoElectronico;

	
	@GetMapping("/Listar")
	public ResponseEntity<List<documentoElectronico>> getAllFacturas(@RequestParam(required = false) String filename){
		try {
			List<documentoElectronico> facturas = new ArrayList<documentoElectronico>();
			
			if(filename == null)
				documentoElectronico.findAll().forEach(facturas::add);
			else
				
			if (facturas.isEmpty()) {
			      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(facturas, HttpStatus.OK);
		
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/Guardar/{id}")
	public String guardarFacturaFile(@PathVariable String id) throws FileNotFoundException{
		DBObject metaData = new BasicDBObject();
		metaData.put("organization", "Prueba");
		metaData.put("idCliente", id);
		
		metaData.put("type", "pdf");
		
		//gridFsOperations.store(inputStream, "prueba.pdf","application/pdf", metaData);		
		return "File stored succesfull.....";
	}
	
	@GetMapping("/Mostrar/{id}")
	public String mostrarFactura(@PathVariable String id) throws IOException {
		 GridFSFile pdfFile = gridFsTemplate.findOne(new Query(Criteria.where("metadata.type").is("image")));
	     documentoElectronico pdf = new documentoElectronico();   
	     pdf.setTitle(pdfFile.getMetadata().get("title").toString());
	     pdf.setPdf(gridFsOperations.getResource(pdfFile).getInputStream()); 
		 return "hola";
	}
	
	@GetMapping("/Visualizar/{id}")
	public void streamPDF(@PathVariable String id, HttpServletResponse response) throws Exception {
		 GridFSFile pdfFile = gridFsTemplate.findOne(new Query(Criteria.where("_id").is(id))); 
	     documentoElectronico pdf = new documentoElectronico();   
	     pdf.setTitle(pdfFile.getMetadata().get("title").toString());
	     pdf.setPdf(gridFsOperations.getResource(pdfFile).getInputStream()); 
	     FileCopyUtils.copy(pdf.getPdf(),response.getOutputStream());
	     
	}

}
