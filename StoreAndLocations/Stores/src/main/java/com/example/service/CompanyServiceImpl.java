package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.ResourceNotFoundException;
import com.example.model.Company;
import com.example.model.Store;
import com.example.repository.CompanyRepository;
import com.example.repository.StoreRepository;

@Service
public class CompanyServiceImpl implements CompanyService{
	
	@Autowired
	private StoreRepository storeRepository;
	
	@Autowired
	private CompanyRepository companyRepository;

	@Override
	public List<Store> getAllStoresByCompanyId(Integer companyId) throws ResourceNotFoundException {
		
		// find company by given Id 
		Company comp = companyRepository.findById(companyId).orElseThrow(()-> new ResourceNotFoundException("company not found with companyId: " + companyId));
		if(comp.getStores().isEmpty()) {
			throw new ResourceNotFoundException("No any store registered with this company yet.");
		}
		return comp.getStores();
	}

	@Override
	public Company addCompany(Company company) {
		
		// saving the received company to DB
		return companyRepository.save(company);
	}

	@Override
	public Company addExistingStoreToCompanyByCompanyIdAndStoreId(Integer companyId, Integer storeId) throws ResourceNotFoundException {
		// find company by given Id 
		Company comp = companyRepository.findById(companyId).orElseThrow(()-> new ResourceNotFoundException("company not found with companyId: " + companyId));
		
		// find Store by given Id 
		Store store = storeRepository.findById(storeId).orElseThrow(()-> new ResourceNotFoundException("store not found with StoreId:- " + storeId));;
		if(store.getCompany() != null) {
			throw new ResourceNotFoundException("Can't add this store because this store is of " + store.getCompany().getName()+ " Company");
		}
		
		// first getting the list of stores of the given company then setting Store object to it
		comp.getStores().add(store);
		
		// setting company to the store
		store.setCompany(comp);

		return companyRepository.save(comp);
	}

	@Override
	public List<Company> getListOfCompanies() throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		
		return companyRepository.findAll();
	}

}
