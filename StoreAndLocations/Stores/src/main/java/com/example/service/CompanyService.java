package com.example.service;

import java.util.List;

import com.example.exception.ResourceNotFoundException;
import com.example.model.Company;
import com.example.model.Store;

public interface CompanyService {
	
	/**
     * Get a list of all stores associated with a specific company.
     *
     * @param companyId The unique identifier of the company.
     * @return List of stores associated with the company.
     * @throws ResourceNotFoundException If the company or stores are not found.
     */
	public List<Store> getAllStoresByCompanyId(Integer companyId) throws ResourceNotFoundException;
	
	/**
     * Add a new company.
     *
     * @param company The company entity to be added.
     * @return The added company entity.
     */
	public Company addCompany(Company company);
	
	/**
     * Add an existing store to a company by specifying the company and store identifiers.
     *
     * @param companyId The unique identifier of the company.
     * @param storeId   The unique identifier of the store to be added to the company.
     * @return The updated company entity with the added store.
     * @throws ResourceNotFoundException If the company or store is not found.
     */
	public Company addExistingStoreToCompanyByCompanyIdAndStoreId(Integer companyId, Integer storeId) throws ResourceNotFoundException;
	
	/**
     * Get a list of all companies.
     *
     * @return List of all companies.
     * @throws ResourceNotFoundException If no companies are found.
     */
	public List<Company> getListOfCompanies() throws ResourceNotFoundException;
	
}
