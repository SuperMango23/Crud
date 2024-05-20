package controllers;

import Entity.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.VehicleService;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

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
