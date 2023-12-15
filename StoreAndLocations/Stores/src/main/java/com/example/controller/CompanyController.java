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

import com.example.model.Company;
import com.example.model.Store;
import com.example.service.CompanyService;

@RestController
@RequestMapping("/companies")
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	@PostMapping("/")
	public ResponseEntity<Company> addCompanyHandler(@RequestBody Company company){
		Company comp = companyService.addCompany(company);
		
		return new ResponseEntity<>(comp, HttpStatus.CREATED);
	}
	
	@GetMapping("/AllStores/{companyId}")
	public ResponseEntity<List<Store>> getAllStoreHandler(@PathVariable Integer companyId){
		
		List<Store> stores = companyService.getAllStoresByCompanyId(companyId);
		
		return new ResponseEntity<List<Store>>(stores, HttpStatus.OK);
	}
	
	@PostMapping("/{companyId}/{storeId}")
	public ResponseEntity<Company> addExistingStoreToCompanyByCompanyIdAndStoreIdHandler(@PathVariable Integer companyId, @PathVariable Integer storeId){
		
		Company company = companyService.addExistingStoreToCompanyByCompanyIdAndStoreId(companyId, storeId);
		
		return new ResponseEntity<Company>(company, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Company>> getListOfCompaniesHandler(){
		List<Company> companies = companyService.getListOfCompanies();
		
		return new ResponseEntity<List<Company>>(companies, HttpStatus.OK);
	}
}