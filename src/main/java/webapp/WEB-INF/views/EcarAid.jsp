<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CRUD Form</title>
    <!-- Link CSS của Bootstrap -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/5.3.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-5">
    <h2>CRUD Form</h2>
    <!-- Thanh tìm kiếm -->
    <div class="mb-3">
        <input type="text" class="form-control" placeholder="Search...">
    </div>

    <!-- Bảng dữ liệu -->
    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>ID Hãng Xe</th>
            <th>Tên</th>
            <th>Loại</th>
            <th>Giá</th>
            <th>Năm Sản Xuất</th>
            <th>Người Sở Hữu</th>
            <th>Chức Năng</th>
        </tr>
        </thead>
        <tbody>
        <!-- Dữ liệu sẽ được thêm vào đây sau -->
        <tr th:each="vehicle : ${vehicles}">
            <td th:text="${vehicle.id}"></td>
            <td th:text="${vehicle.brandId}"></td>
            <td th:text="${vehicle.name}"></td>
            <td th:text="${vehicle.type}"></td>
            <td th:text="${vehicle.price}"></td>
            <td th:text="${vehicle.manufactureYear}"></td>
            <td th:text="${vehicle.owner}"></td>
            <td>
                <!-- Thêm các nút Edit và Delete -->
                <button onclick="editVehicle(${vehicle.id})">Edit</button>
                <button onclick="deleteVehicle(${vehicle.id})">Delete</button>
            </td>
        </tr>
        </tbody>
    </table>

    <!-- Ô nhập thông tin mới -->
    <div class="mb-3">
        <input type="text" class="form-control" placeholder="ID">
        <input type="text" class="form-control" placeholder="ID Hãng Xe">
        <input type="text" class="form-control" placeholder="Tên">
        <input type="text" class="form-control" placeholder="Loại">
        <input type="text" class="form-control" placeholder="Giá">
        <input type="text" class="form-control" placeholder="Năm Sản Xuất">
        <input type="text" class="form-control" placeholder="Người Sở Hữu">
        <button class="btn btn-primary mt-2">Thêm</button>
    </div>
</div>

<!-- Link JS của Bootstrap -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/5.3.2/js/bootstrap.bundle.min.js"></script>

<script>
    // Hàm xử lý sự kiện khi nhấn nút Edit
    function editVehicle(vehicleId) {
        // Viết mã JavaScript để xử lý chức năng Edit ở đây
        console.log('Edit vehicle with ID ' + vehicleId);
    }

    // Hàm xử lý sự kiện khi nhấn nút Delete
    function deleteVehicle(vehicleId) {
        // Viết mã JavaScript để xử lý chức năng Delete ở đây
        console.log('Delete vehicle with ID ' + vehicleId);
    }
</script>
</body>
</html>
