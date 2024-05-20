create database API
go
use database API
go
-- Tạo bảng hãng xe
CREATE TABLE Brands (
    BrandID INT PRIMARY KEY,
    BrandName NVARCHAR(100),
    Type NVARCHAR(50)
);

-- Tạo bảng xe
CREATE TABLE Vehicles (
    VehicleID INT PRIMARY KEY,
    VehicleName NVARCHAR(100),
    ManufactureYear INT,
    Price DECIMAL(18, 2),
    Owner NVARCHAR(100),
    BrandID INT,
    CreatedDate DATETIME,
    FOREIGN KEY (BrandID) REFERENCES Brands(BrandID)
);

-- Thêm dữ liệu vào bảng hãng xe
INSERT INTO Brands (BrandID, BrandName, Type) VALUES
(1, 'Toyota', 'Car'),
(2, 'Suzuki', 'Bus'),
(3, 'Ford', 'Truck'),
(4, 'Scania', 'Bus');

-- Thêm dữ liệu vào bảng xe
INSERT INTO Vehicles (VehicleID, VehicleName, ManufactureYear, Price, Owner, BrandID, CreatedDate) VALUES
(1, 'Corolla', 2019, 15000000, 'John', 1, GETDATE()),
(2, 'Swift', 2018, 9000000, 'Alice', 2, GETDATE()),
(3, 'Transit', 2020, 12000000, 'Bob', 4, GETDATE()),
(4, 'F-150', 2017, 20000000, 'Carol', 3, GETDATE());

-- Truy vấn lấy thông tin từ cả bảng xe và bảng loại xe từ bảng hãng
SELECT v.VehicleID, v.VehicleName, v.ManufactureYear, v.Price, v.Owner, b.BrandName, b.Type AS BrandType
FROM Vehicles v
JOIN Brands b ON v.BrandID = b.BrandID;
