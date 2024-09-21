package com.htc.project.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.htc.project.model.Pending;



@Repository("pendingRepository")
public interface PendingRepository extends CrudRepository<Pending,Integer> {

}
