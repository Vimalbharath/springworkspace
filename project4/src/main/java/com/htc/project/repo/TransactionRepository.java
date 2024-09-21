package com.htc.project.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.htc.project.model.Transaction;



@Repository("transactionRepository")
public interface TransactionRepository extends CrudRepository<Transaction,Integer> {

}
