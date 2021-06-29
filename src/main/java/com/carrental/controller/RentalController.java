package com.carrental.controller;

import com.carrental.model.Branch;
import com.carrental.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class RentalController {

    @Autowired
    RentalService rentalService;

    @PostMapping(path="/add_branch")
    List<Branch> addBranchToService(String name)
    {
        return rentalService.addBranch(name);
    }

}
