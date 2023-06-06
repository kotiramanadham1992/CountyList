package com.example.sample.koti.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sample.koti.model.CountyTable;
import com.example.sample.koti.repository.CountryRepository;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	CountryRepository countryRepository;
	
	
	@Override
	public List<CountyTable> getByName(String name) {
		List<CountyTable> result = countryRepository.getByName1(name);
		Set<String> resultSet = result.stream().map(map->map.getState()).collect(Collectors.toSet());
		
		return result;
	}


	@Override
	public List<CountyTable> getAll() {
		List<CountyTable> result = countryRepository.findAll();
		return result;
	}
	
	@Override
	public Set<String> getByNameLike(String name) {
		List<CountyTable> result = countryRepository.getByName1(name);
		Set<String> resultSet = result.stream().map(map->map.getState()).collect(Collectors.toSet());
		return resultSet;
	}


	@Override
	public List<CountyTable> getByState(String name) {
		List<CountyTable> result = countryRepository.getByNameOrStateLike(name);
		return result;
	}


	@Override
	public List<CountyTable> getByNameOrByState(String name, String state) {
		List<CountyTable> result = countryRepository.getByNameOrStateLike(name,state);
		return result;
	}
}
