package services;

import Entity.Vehicle;
import repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public Vehicle addVehicle(Vehicle vehicle) {
        // Kiểm tra validation
        if (vehicle == null || vehicle.getVehicleName() == null || vehicle.getVehicleName().isEmpty() || vehicle.getPrice() == null || vehicle.getOwner() == null) {
            throw new IllegalArgumentException("Vehicle information is incomplete");
        }
        return vehicleRepository.save(vehicle);
    }

    public void deleteVehicle(int id) {
        // Xử lý ngoại lệ khi không tìm thấy id
        if (!vehicleRepository.existsById(id)) {
            throw new IllegalArgumentException("Vehicle not found with ID: " + id);
        }
        vehicleRepository.deleteById(id);
    }

    public Vehicle updateVehicle(int id, Vehicle vehicleDetails) {
        // Kiểm tra validation
        if (vehicleDetails == null || vehicleDetails.getVehicleName() == null || vehicleDetails.getVehicleName().isEmpty() || vehicleDetails.getPrice() == null || vehicleDetails.getOwner() == null) {
            throw new IllegalArgumentException("Updated vehicle information is incomplete");
        }
        // Xử lý ngoại lệ khi không tìm thấy id
        Optional<Vehicle> optionalVehicle = vehicleRepository.findById(id);
        if (!optionalVehicle.isPresent()) {
            throw new IllegalArgumentException("Vehicle not found with ID: " + id);
        }
        Vehicle existingVehicle = optionalVehicle.get();
        // Cập nhật thông tin
        existingVehicle.setVehicleName(vehicleDetails.getVehicleName());
        existingVehicle.setManufactureYear(vehicleDetails.getManufactureYear());
        existingVehicle.setPrice(vehicleDetails.getPrice());
        existingVehicle.setOwner(vehicleDetails.getOwner());
        existingVehicle.setBrand(vehicleDetails.getBrand());
        existingVehicle.setCreatedDate(vehicleDetails.getCreatedDate());
        return vehicleRepository.save(existingVehicle);
    }

    // Phương thức tìm kiếm các xe theo hãng, năm sản xuất và người sở hữu
    public List<Vehicle> searchVehicles(String brandName, Integer manufactureYear, String owner) {
        return vehicleRepository.searchVehicles(brandName, manufactureYear, owner);
    }
}
