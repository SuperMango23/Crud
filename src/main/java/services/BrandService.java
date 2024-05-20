package services;

import Entity.Brand;
import repositories.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandService {
    @Autowired
    private BrandRepository brandRepository;

    // Lấy danh sách tất cả các hãng xe
    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    // Thêm một hãng xe mới
    public Brand addBrand(Brand brand) {
        return brandRepository.save(brand);
    }

    // Cập nhật thông tin của một hãng xe
    public Brand updateBrand(int id, Brand brandDetails) {
        Optional<Brand> optionalBrand = brandRepository.findById(id);
        if (optionalBrand.isPresent()) {
            Brand existingBrand = optionalBrand.get();
            existingBrand.setBrandName(brandDetails.getBrandName());
            existingBrand.setType(brandDetails.getType());
            return brandRepository.save(existingBrand);
        } else {
            return null;
        }
    }

    // Xóa một hãng xe
    public void deleteBrand(int id) {
        brandRepository.deleteById(id);
    }
}
