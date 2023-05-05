package com.mainclass.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mainclass.bean.StudentLeave;
@Repository
public interface LeaveRepository extends CrudRepository<StudentLeave,Integer> {

}
