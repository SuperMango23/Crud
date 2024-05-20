package com.example.repositories;

import com.example.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

    @Query("SELECT v FROM Vehicle v WHERE " +
           "(:brandName IS NULL OR v.brand.brandName LIKE %:brandName%) AND " +
           "(:manufactureYear IS NULL OR v.manufactureYear = :manufactureYear) AND " +
           "(:owner IS NULL OR v.owner LIKE %:owner%)")
    List<Vehicle> searchVehicles(String brandName, Integer manufactureYear, String owner);
}
