package com.example.service;
import java.util.List;

import com.example.exception.ResourceNotFoundException;
import com.example.model.Location;
import com.example.model.Store;

public interface StoreService {
	
	/**
     * Get a store by its unique identifier.
     *
     * @param storeId The unique identifier of the store.
     * @return The store entity.
     * @throws ResourceNotFoundException If the store is not found.
     */
	public Store getStoreById (Integer storeId) throws ResourceNotFoundException;
	
	/**
     * Get the location associated with a store by its unique identifier.
     *
     * @param storeId The unique identifier of the store.
     * @return The location entity associated with the store.
     * @throws ResourceNotFoundException If the store or location is not found.
     */
	public Location getLocationByStoreId(Integer storeId) throws ResourceNotFoundException;
	
	/**
     * Add a new store.
     *
     * @param store The store entity to be added.
     * @return The added store entity.
     * @throws ResourceNotFoundException If the operation fails.
     */
	public Store addStore(Store store) throws ResourceNotFoundException;

	/**
     * Get a list of stores in a specific city.
     *
     * @param city The name of the city.
     * @return List of stores in the specified city.
     * @throws ResourceNotFoundException If no stores are found in the city.
     */
	List<Store> getStoresByCity(String city) throws ResourceNotFoundException;
}
