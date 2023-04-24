package com.sip.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sip.entities.Article;
import com.sip.entities.Provider;
import com.sip.repositories.ProviderRepository;

@Service
public class ProviderService {
	private final ProviderRepository providerRepository;
	@Autowired
	public ProviderService( ProviderRepository providerRepository){
		
		this.providerRepository=providerRepository;
		
	}
	
	public List<Provider> getAllProvider(){
		
		List<Provider> lp =(List<Provider>)providerRepository.findAll();
    	if(lp.size()==0)
    		lp = null;
        return lp;
	}
	

}
