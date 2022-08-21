package com.vehiclerental.service;

import com.vehiclerental.model.Branch;
import com.vehiclerental.model.City;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BranchServiceTest {
    @Test
    public void whenBranchDoesnotExist_checkBranchExistsTest() {
        City c = new City();
        assertFalse(BranchService.checkBranchExists(c, "B1"));
    }

    @Test
    public void whenBranchExist_checkBranchExistsTest() {
        City c = new City();
        BranchService.addBranch(c, "B1", List.of("CAR"));
        assertTrue(BranchService.checkBranchExists(c, "B1"));
    }

    @Test
    public void whenBranchAlreadyExist_addBranchTest() {
        City c = new City();
        BranchService.addBranch(c, "B1", List.of("CAR"));
        assertFalse(BranchService.addBranch(c, "B1", List.of("CAR")));
    }

    @Test
    public void whenBranchDoesnotExist_addBranchTest() {
        City c = new City();
        assertTrue(BranchService.addBranch(c, "B1", List.of("CAR")));
    }

    @Test
    public void whenBranchDoesnotExist_getBranchTest() {
        City c = new City();
        assertNull(BranchService.getBranch(c, "B1"));
    }

    @Test
    public void whenBranchExist_getBranchTest() {
        City c = new City();
        BranchService.addBranch(c, "B1", List.of("CAR"));
        assertEquals(BranchService.getBranch(c, "B1").getBranchName(), "B1");
    }

    @Test
    public void whenVehicleTypeExist_checkVehicleTypeExistsTest() {
        City c = new City();
        BranchService.addBranch(c, "B1", List.of("CAR"));
        Branch branch = BranchService.getBranch(c, "B1");
        assertTrue(BranchService.checkVehicleTypeExists(branch, "CAR"));
    }

    @Test
    public void whenBranchDoesntExist_addBranchTest() {
        City c = new City();
        BranchService.addBranch(c, "B1", List.of("CAR"));
        Branch branch = BranchService.getBranch(c, "B1");
        assertFalse(BranchService.checkVehicleTypeExists(branch, "BIKE"));
    }
}
