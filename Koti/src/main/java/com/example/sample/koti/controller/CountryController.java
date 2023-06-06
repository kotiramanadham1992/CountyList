package com.example.sample.koti.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.sample.koti.model.CountyTable;
import com.example.sample.koti.service.CountryService;

@RestController
public class CountryController {
	
	@Autowired
	CountryService countryService;
	
	@GetMapping("getByNameOrStateLike/{name}")
	public List<CountyTable> getByNameOrStateLike(@PathVariable ("name") String name){
		
		List<CountyTable> list = new ArrayList<>();
		if(name.length()>2) {
			 list = countryService.getByName(name);
		}else {
			list = countryService.getByState(name.toUpperCase());
		}
		
		
		return list;
	}
	
	@GetMapping("getByStateOrCounti/{name}")
	public List<CountyTable> getByStateOrCounti(@PathVariable ("name") String strnig){
		List<CountyTable> list = new ArrayList<>();
		
		if(strnig.contains(",")) {
			String[]  ss = strnig.split(",");
			String name = ss[0];
			String state = ss[1];
			list = countryService.getByNameOrByState(name,state.toUpperCase());
		}
		return list.stream().limit(5).collect(Collectors.toList());
	}
	
//	@GetMapping("getByNmae/{name}")
//	public List<CountyTable> getByname(@PathVariable ("name") String name){
//		List<CountyTable> list = countryService.getByName(name);
//		return list;
//	}
//	
//	
//	@GetMapping("getByNmaeLike/{name}")
//	public Set<String>  getBynameLike(@PathVariable ("name") String name){
//		
//		Set<String> list = countryService.getByNameLike(name);
//		return list;
//	}
	
	
	

//	@GetMapping("get/{name}")
//	public String getByname1(@PathVariable ("name") String name){
//		return "koti";
//	}
//	
//	@GetMapping("getAll")
//	public List<CountyTable> getByname(){
//		List<CountyTable> list = countryService.getAll();
//		return list;
//	}
	

}
