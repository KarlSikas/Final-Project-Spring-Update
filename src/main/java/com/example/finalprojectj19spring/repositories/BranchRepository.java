package com.example.finalprojectspring.repositories;

import com.example.finalprojectspring.models.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author Karl-Erik Sirkas
 * @Date 4/3/2023
 */
@Repository
public interface BranchRepository extends JpaRepository<Branch, Long> {


    List<Branch> findByAddress(String address);

}