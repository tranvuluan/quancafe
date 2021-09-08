-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 08, 2021 at 09:47 AM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `quancafe`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_account`
--

CREATE TABLE `tbl_account` (
  `username` varchar(255) NOT NULL,
  `pass` varchar(255) NOT NULL,
  `permission` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_account`
--

INSERT INTO `tbl_account` (`username`, `pass`, `permission`) VALUES
('admin', 'admin', 0),
('luan1', '12345', 1),
('luan123', 'luan123', 1),
('luan2', '12345', 1),
('luantran', '12345', 1),
('nv1', 'nv1', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_ban`
--

CREATE TABLE `tbl_ban` (
  `ma_ban` int(11) NOT NULL,
  `ma_khuvuc` int(11) NOT NULL,
  `ten_ban` varchar(255) NOT NULL,
  `status` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_ban`
--

INSERT INTO `tbl_ban` (`ma_ban`, `ma_khuvuc`, `ten_ban`, `status`) VALUES
(7, 5, 'Bàn 0.1', 0),
(8, 5, 'Bàn 0.2', 0),
(9, 6, 'Bàn 1.1', 0),
(10, 6, 'Bàn 1.2', 0),
(11, 6, 'Bàn 1.3', 0),
(12, 6, 'Bàn 1.4', 0),
(13, 7, 'Bàn 2.1', 0),
(14, 7, 'Bàn 2.2', 0),
(29, 20, 'Bàn 3.0', 0);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_chitiethoadon`
--

CREATE TABLE `tbl_chitiethoadon` (
  `ma_hoadon` int(11) NOT NULL,
  `ma_mon` int(11) NOT NULL,
  `soluong` int(11) NOT NULL,
  `gia_mon` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_chitiethoadon`
--

INSERT INTO `tbl_chitiethoadon` (`ma_hoadon`, `ma_mon`, `soluong`, `gia_mon`) VALUES
(732389, 1, 2, 25000),
(732389, 15, 2, 50000),
(2038042, 8, 2, 50000),
(8615066, 1, 1, 25000),
(9248294, 2, 2, 20000),
(9248294, 8, 2, 50000);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_hoadon`
--

CREATE TABLE `tbl_hoadon` (
  `ma_hoadon` int(11) NOT NULL,
  `ma_ban` int(11) NOT NULL,
  `ma_nvthungan` int(11) NOT NULL,
  `ngaylap` datetime NOT NULL DEFAULT current_timestamp(),
  `ngaythanhtoan` datetime DEFAULT NULL,
  `trangthai` int(11) DEFAULT NULL,
  `tongtien` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_hoadon`
--

INSERT INTO `tbl_hoadon` (`ma_hoadon`, `ma_ban`, `ma_nvthungan`, `ngaylap`, `ngaythanhtoan`, `trangthai`, `tongtien`) VALUES
(732389, 11, 5, '2021-09-08 08:50:22', '2021-09-08 08:50:22', 1, 150000),
(2038042, 8, 5, '2021-09-08 08:49:53', '2021-09-08 08:49:53', 1, 100000),
(8615066, 7, 5, '2021-09-05 13:19:27', '2021-09-05 13:19:27', 1, 25000),
(9248294, 10, 5, '2021-09-08 08:50:02', '2021-09-08 08:50:02', 1, 140000);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_khuvuc`
--

CREATE TABLE `tbl_khuvuc` (
  `ma_khuvuc` int(11) NOT NULL,
  `ten_khuvuc` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_khuvuc`
--

INSERT INTO `tbl_khuvuc` (`ma_khuvuc`, `ten_khuvuc`) VALUES
(5, 'Tầng trệt'),
(6, 'Tầng 1'),
(7, 'Tầng 2'),
(20, 'Tầng 3');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_loaimon`
--

CREATE TABLE `tbl_loaimon` (
  `ma_loaimon` int(11) NOT NULL,
  `ten_loaimon` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_loaimon`
--

INSERT INTO `tbl_loaimon` (`ma_loaimon`, `ten_loaimon`) VALUES
(1, 'Thức uống'),
(2, 'Món ăn');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_mon`
--

CREATE TABLE `tbl_mon` (
  `ma_mon` int(11) NOT NULL,
  `ma_loaimon` int(11) NOT NULL,
  `ten_mon` varchar(255) NOT NULL,
  `gia_mon` int(11) NOT NULL,
  `status` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_mon`
--

INSERT INTO `tbl_mon` (`ma_mon`, `ma_loaimon`, `ten_mon`, `gia_mon`, `status`) VALUES
(1, 1, 'Cafe sữa', 25000, 1),
(2, 1, 'Cafe đen', 20000, 1),
(7, 2, 'Hủ tiếu bò', 50000, 1),
(8, 2, 'Bún bò', 50000, 1),
(9, 1, 'Trà sữa trân châu', 30000, 1),
(10, 1, 'Trà chanh', 28000, 1),
(11, 1, 'Trà đào', 28000, 1),
(14, 1, 'Trà tắc', 30000, 0),
(15, 2, 'Hủ tiếu sườn', 50000, 1),
(21, 1, 'Hồng trà', 5000, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_nhanvien`
--

CREATE TABLE `tbl_nhanvien` (
  `ma_nhanvien` int(11) NOT NULL,
  `ten_nhanvien` varchar(255) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `cmnd` varchar(255) NOT NULL,
  `sdt` varchar(255) NOT NULL,
  `ngaysinh` date NOT NULL,
  `diachi` varchar(255) NOT NULL,
  `ngayvaolam` datetime NOT NULL DEFAULT current_timestamp(),
  `chucvu` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_nhanvien`
--

INSERT INTO `tbl_nhanvien` (`ma_nhanvien`, `ten_nhanvien`, `username`, `cmnd`, `sdt`, `ngaysinh`, `diachi`, `ngayvaolam`, `chucvu`) VALUES
(1, 'Trần Vũ Luân', 'admin', '2381361841', '0868486575', '2021-05-04', 'Ninh Thuan', '2021-05-29 00:00:00', 'Nhân viên thu ngân'),
(5, 'Nguyễn Thị Đậu', 'nv1', '23012324514', '087868268', '2001-01-01', 'Bến Tre', '2021-01-01 00:00:00', 'Nhân viên thu ngân'),
(19, 'Nguyễn Thị Nụ', NULL, '12312931312', '0868348743', '2001-08-23', 'Ninh Thuận', '2020-01-01 00:00:00', 'Nhân viên phục vụ'),
(20, 'Trần Kỳ Vọng', NULL, '2328913622', '08238233298', '2001-07-01', 'Bình Thuận', '2020-01-01 00:00:00', 'Nhân viên phục vụ'),
(21, 'Đỗ Trạng Nguyên', NULL, '239283723', '0923323973', '2001-08-23', 'Khánh Hoà', '2020-01-01 00:00:00', 'Nhân viên phục vụ'),
(22, 'Huy Hoàng', 'luantran', '102313123', '08123821379', '2001-01-01', 'Bình Định', '2020-01-01 00:00:00', 'Nhân viên thu ngân');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_account`
--
ALTER TABLE `tbl_account`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `tbl_ban`
--
ALTER TABLE `tbl_ban`
  ADD PRIMARY KEY (`ma_ban`),
  ADD KEY `fr_bankhuvuc` (`ma_khuvuc`);

--
-- Indexes for table `tbl_chitiethoadon`
--
ALTER TABLE `tbl_chitiethoadon`
  ADD PRIMARY KEY (`ma_hoadon`,`ma_mon`),
  ADD KEY `ma_mon` (`ma_mon`);

--
-- Indexes for table `tbl_hoadon`
--
ALTER TABLE `tbl_hoadon`
  ADD PRIMARY KEY (`ma_hoadon`),
  ADD KEY `fr_hoadonban` (`ma_ban`),
  ADD KEY `fr_hoadonnhanvien` (`ma_nvthungan`);

--
-- Indexes for table `tbl_khuvuc`
--
ALTER TABLE `tbl_khuvuc`
  ADD PRIMARY KEY (`ma_khuvuc`);

--
-- Indexes for table `tbl_loaimon`
--
ALTER TABLE `tbl_loaimon`
  ADD PRIMARY KEY (`ma_loaimon`);

--
-- Indexes for table `tbl_mon`
--
ALTER TABLE `tbl_mon`
  ADD PRIMARY KEY (`ma_mon`),
  ADD KEY `fr_monloaimon` (`ma_loaimon`);

--
-- Indexes for table `tbl_nhanvien`
--
ALTER TABLE `tbl_nhanvien`
  ADD PRIMARY KEY (`ma_nhanvien`),
  ADD KEY `fr_nhanvienaccount` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_ban`
--
ALTER TABLE `tbl_ban`
  MODIFY `ma_ban` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT for table `tbl_khuvuc`
--
ALTER TABLE `tbl_khuvuc`
  MODIFY `ma_khuvuc` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `tbl_loaimon`
--
ALTER TABLE `tbl_loaimon`
  MODIFY `ma_loaimon` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tbl_mon`
--
ALTER TABLE `tbl_mon`
  MODIFY `ma_mon` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `tbl_nhanvien`
--
ALTER TABLE `tbl_nhanvien`
  MODIFY `ma_nhanvien` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tbl_ban`
--
ALTER TABLE `tbl_ban`
  ADD CONSTRAINT `fr_bankhuvuc` FOREIGN KEY (`ma_khuvuc`) REFERENCES `tbl_khuvuc` (`ma_khuvuc`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tbl_chitiethoadon`
--
ALTER TABLE `tbl_chitiethoadon`
  ADD CONSTRAINT `tbl_chitiethoadon_ibfk_1` FOREIGN KEY (`ma_hoadon`) REFERENCES `tbl_hoadon` (`ma_hoadon`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tbl_chitiethoadon_ibfk_2` FOREIGN KEY (`ma_mon`) REFERENCES `tbl_mon` (`ma_mon`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tbl_hoadon`
--
ALTER TABLE `tbl_hoadon`
  ADD CONSTRAINT `fr_hoadonban` FOREIGN KEY (`ma_ban`) REFERENCES `tbl_ban` (`ma_ban`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fr_hoadonnhanvien` FOREIGN KEY (`ma_nvthungan`) REFERENCES `tbl_nhanvien` (`ma_nhanvien`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tbl_mon`
--
ALTER TABLE `tbl_mon`
  ADD CONSTRAINT `fr_monloaimon` FOREIGN KEY (`ma_loaimon`) REFERENCES `tbl_loaimon` (`ma_loaimon`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tbl_nhanvien`
--
ALTER TABLE `tbl_nhanvien`
  ADD CONSTRAINT `fr_nhanvienaccount` FOREIGN KEY (`username`) REFERENCES `tbl_account` (`username`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
