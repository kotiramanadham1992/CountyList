package com.example.sample.koti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.sample.koti.model.CountyTable;

@Repository
public interface CountryRepository extends JpaRepository<CountyTable, Integer>{

	@Query(value="select * from County_Table where name LIKE %:name%  limit 5", nativeQuery=true)
	List<CountyTable> getByName1(@Param ("name") String name);

	@Query(value="select * from County_Table where state LIKE %:state%  limit 5", nativeQuery=true)
	List<CountyTable> getByNameOrStateLike(String state);

	@Query(value="select * from County_Table where state = :state OR name = :name ", nativeQuery=true)
	List<CountyTable> getByNameOrStateLike(String name, String state);

}
