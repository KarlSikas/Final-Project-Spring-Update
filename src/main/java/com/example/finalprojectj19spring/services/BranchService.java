package com.example.finalprojectj19spring.services;

import com.example.finalprojectj19spring.exceptions.BranchNotFoundException;
import com.example.finalprojectj19spring.models.Branch;

import java.util.List;

/**
 * @author Karl-Erik Sirkas
 * @Date 3/28/2023
 */
public interface BranchService {
    /**
     * To create a new branch
     *
     * @param branch Branch
     */
    void createBranch(Branch branch);

    /**
     * To find a branch by ID
     *
     * @param id Branch ID
     * @return Branch
     */
    Branch findBranchById(Long id) throws BranchNotFoundException;

    /**
     * To find a branch by address
     *
     * @param address Branch address
     * @return Branch
     */
    Branch findBranchByAddress(String address) throws BranchNotFoundException;

    /**
     * To find all branches
     *
     * @return a list of Branch
     */
    List<Branch> findAllBranches();


    /**
     * To update an existing Branch
     *
     * @param branch Branch
     */
    void updateBranch(Branch branch) throws BranchNotFoundException;

    /**
     * To delete a Branch by ID
     *
     * @param id Branch ID
     */
    void deleteBranchById(Long id) throws BranchNotFoundException;

    /**
     * To restore a Branch by ID
     *
     * @param id Branch ID
     */
    void restoreBranchById(Long id) throws BranchNotFoundException;
}