package com.example.controllers;

import com.example.entity.Vehicle;
import com.example.services.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
@RequiredArgsConstructor
public class VehicleController {
	
	//constructor
	private final VehicleService vehicleService;
	
	// Lấy danh sách tất cả các xe
    @GetMapping
    public List<Vehicle> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    // Thêm một xe mới
    @PostMapping
    public Vehicle addVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.addVehicle(vehicle);
    }

    // Xóa một xe
    @DeleteMapping("/{id}")
    public void deleteVehicle(@PathVariable int id) {
        vehicleService.deleteVehicle(id);
    }

    // Cập nhật thông tin của một xe
    @PutMapping("/{id}")
    public Vehicle updateVehicle(@PathVariable int id, @RequestBody Vehicle vehicleDetails) {
        return vehicleService.updateVehicle(id, vehicleDetails);
    }

    // Tìm kiếm các xe theo hãng, năm sản xuất và người sở hữu
    @GetMapping("/search")
    public List<Vehicle> searchVehicles(@RequestParam(required = false) String brand,
                                        @RequestParam(required = false) Integer manufactureYear,
                                        @RequestParam(required = false) String owner) {
        return vehicleService.searchVehicles(brand, manufactureYear, owner);
    }
}
