package com.mainclass.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mainclass.bean.HostelStudent;

@Repository
public interface StudentRepository extends CrudRepository<HostelStudent,Integer>{

}
