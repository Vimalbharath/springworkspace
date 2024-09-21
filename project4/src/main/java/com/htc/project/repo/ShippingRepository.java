package com.htc.project.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.htc.project.model.Shipping;



@Repository("shippingRepository")
public interface ShippingRepository extends CrudRepository<Shipping,Integer> {

}
