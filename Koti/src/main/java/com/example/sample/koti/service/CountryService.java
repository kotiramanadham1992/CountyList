package com.example.sample.koti.service;

import java.util.List;
import java.util.Set;

import com.example.sample.koti.model.CountyTable;


public interface CountryService {

	List<CountyTable> getByName(String name);

	List<CountyTable> getAll();

	Set<String> getByNameLike(String name);

	List<CountyTable> getByState(String name);

	List<CountyTable> getByNameOrByState(String s1, String s2);
}
