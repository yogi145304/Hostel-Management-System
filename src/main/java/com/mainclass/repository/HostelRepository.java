package com.mainclass.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mainclass.bean.HostelRoom;
@Repository
public interface HostelRepository extends CrudRepository<HostelRoom,Integer>{

}
