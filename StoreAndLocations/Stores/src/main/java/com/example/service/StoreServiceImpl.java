package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.ResourceNotFoundException;
import com.example.model.Location;
import com.example.model.Store;
import com.example.repository.LocationRepository;
import com.example.repository.StoreRepository;

@Service
public class StoreServiceImpl implements StoreService{

	@Autowired
	private StoreRepository storeRepository;
	
	@Autowired
	private LocationRepository locationRepository;
	
	@Override
	public Store getStoreById(Integer storeId) throws ResourceNotFoundException {
		
		// fetching store Object by using given Id
		Store st = storeRepository.findById(storeId).orElseThrow(()-> new ResourceNotFoundException("Store not found with Id: "+ storeId));
		// returning store Object
		return st;
	}

	@Override
	public Location getLocationByStoreId(Integer storeId) throws ResourceNotFoundException {
		// fetching store Object by using given Id
		Store st = storeRepository.findById(storeId).orElseThrow(()-> new ResourceNotFoundException("Store not found"));
		// returning Location of that store
		return st.getLocation();
	}

	@Override
	public Store addStore(Store store) throws ResourceNotFoundException {
		
		// Extracting Location from the store
		Location location = store.getLocation();
		
		// if location is not added in the store object then User is not allowed to register Store, Because to create a Store Location is Must
		if(location == null) throw  new ResourceNotFoundException("Location is must to register store");
		Store savedStore = storeRepository.save(store);
		
		return savedStore;
	}
	
	// Logic to get all stores located in a particular city
	@Override
	public List<Store> getStoresByCity(String city) throws ResourceNotFoundException {
		// getting Location from the city
		List<Location> locations = locationRepository.findByCity(city);
		
		// creating Empty list of Store to add Stores from different areas in a particular city
		List<Store> storesResult = new ArrayList<>();
		
		for(Location location : locations) {
			// extracting List of store from all location(Area) of a particular city
			List<Store> storeList = location.getStores();
			for(Store store: storeList) {
				// adding all stores to my Empty List
				storesResult.add(store);
			}
		}
		// If no any store is found in a particular city
		if(storesResult.isEmpty()) throw new ResourceNotFoundException("No any store found in "+ city);
		
		// returning the final List of Stores which is containing all the stores in a city
		return storesResult;
	}
}
