package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Location;
import com.example.model.Store;
import com.example.service.StoreService;

@RestController
@RequestMapping("/stores")
public class StoreController {
	
	@Autowired
	private StoreService storeService;
	
	@GetMapping("/{storeId}")
	public ResponseEntity<Store> getStoreByIdhandler(@PathVariable Integer storeId){
		Store store = storeService.getStoreById(storeId);
		
		return new ResponseEntity<Store>(store, HttpStatus.OK);
	}
	
	@GetMapping("/location/{storeId}")
	public ResponseEntity<Location> getLocationByStoreIdHandler(@PathVariable Integer storeId){
		Location loc = storeService.getLocationByStoreId(storeId);
		
		return new ResponseEntity<Location>(loc, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Store> addStoreHandler(@RequestBody Store store){
		Store registeredStore = storeService.addStore(store);
		
		return new ResponseEntity<Store>(registeredStore, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/stores/{city}")
	public ResponseEntity<List<Store>> getStoreByCityHandler(@PathVariable String city){
		List<Store> stores = storeService.getStoresByCity(city);
		
		return new ResponseEntity<List<Store>>(stores, HttpStatus.OK);
	}
}









