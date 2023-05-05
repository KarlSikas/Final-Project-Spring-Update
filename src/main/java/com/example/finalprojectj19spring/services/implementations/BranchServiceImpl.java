package com.example.finalprojectj19spring.services.implementations;

import com.example.finalprojectspring.exceptions.BranchNotFoundException;
import com.example.finalprojectspring.models.Branch;
import com.example.finalprojectspring.repositories.BranchRepository;
import com.example.finalprojectspring.services.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Karl-Erik Sirkas
 * @Date 3/28/2023
 */
@Service
public class BranchServiceImpl implements BranchService {
    @Autowired
    private BranchRepository branchRepository;

    @Override
    public void createBranch(Branch branch) {
        branch.setActive(true);
        branchRepository.save(branch);
    }

    @Override
    public Branch findBranchById(Long id) throws BranchNotFoundException {
        Optional<Branch> branchOptional = branchRepository.findById(id);

        if(branchOptional.isEmpty()) {
            throw new BranchNotFoundException(id);
        }

        return branchOptional.get();
    }

    @Override
    public Branch findBranchByAddress(String address) throws BranchNotFoundException {
        Optional<Branch> branchOptional = branchRepository.findByAddress(address).stream().findFirst();

        if(branchOptional.isEmpty()) {
            throw new BranchNotFoundException(address);
        }

        return branchOptional.get();
    }

    @Override
    public List<Branch> findAllBranches() {
        return branchRepository.findAll();
    }

    @Override
    public void updateBranch(Branch branch) throws BranchNotFoundException {
        if(findBranchById(branch.getId()) != null) {
            branchRepository.saveAndFlush(branch);
        }
    }

    @Override
    public void deleteBranchById(Long id) throws BranchNotFoundException {
        Branch branch = findBranchById(id);
        branch.setActive(false);
        branchRepository.saveAndFlush(branch);
    }

    @Override
    public void restoreBranchById(Long id) throws BranchNotFoundException {
        Branch branch = findBranchById(id);
        branch.setActive(true);
        branchRepository.saveAndFlush(branch);
    }
}
