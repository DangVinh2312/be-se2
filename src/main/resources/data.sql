LOCK
TABLES `brand` WRITE;
INSERT INTO `brand`
VALUES (1, 'Samsung'),
       (2, 'Apple'),
       (3, 'Nokia'),
       (4, 'Huewei'),
       (5, 'Oppo'),
       (6, 'Blackberry');
UNLOCK
TABLES;


LOCK
TABLES `cart` WRITE;

UNLOCK
TABLES;


LOCK
TABLES `cart_item` WRITE;

UNLOCK
TABLES;

LOCK
TABLES `category` WRITE;
INSERT INTO `category`
VALUES (1, 'Camera Phone'),
       (2, 'Android Os'),
       (3, 'Smart Phone'),
       (4, 'Apple iOS'),
       (5, 'Window Phone'),
       (6, 'Well Battery'),
       (7, 'Folding Screen'),
       (8, '5G');
UNLOCK
TABLES;

LOCK
TABLES `discount` WRITE;
INSERT INTO discount
VALUES (1, '2022-04-30', 10, '2022-04-19'),
       (2, '2022-05-30', 20, '2022-05-01'),
       (3, '2022-04-23', 50, '2022-04-21');
UNLOCK
TABLES;

LOCK
TABLES `product` WRITE;
INSERT INTO product
VALUES (1, '2022-04-21 19:12:34', _binary '\0', NULL, 'iPhone 11 Pro Max', 'iPhone 11 Pro Max', 14090000, 3969,
        '12MP | 3 camera 12 MP', NULL, 'iOS 14', 'Apple A13 Bionic', 4, 'OLED6.5 Super Retina XDR',
        20, NULL, '2022-04-21 19:12:34', 2, 2),
       (2, '2022-04-21 19:17:49', _binary '\0', NULL, 'Smart phone Samsung Galaxy Note 20 Ultra 5G',
        'Samsung Galaxy Note 20 Ultra 5G', 19990000, 4500,
        '10MP | Main 108 MP & Secondary 12 MP, 12 MP, Laser AF sensor', NULL, 'Android 10',
        'Exynos 990', 12, 'Dynamic AMOLED 2X6.9 Quad HD+ (2K+)', 5, NULL, '2022-04-21 19:17:49', 1, 1),
       (3, '2022-04-21 19:21:24', _binary '\0', NULL, 'OPPO Find X2', 'OPPO Find X2', 7990000, 4200,
        '32MP | Main 48 MP & Sub 13 MP, 12 MP', NULL, 'Android 10', 'Snapdragon 865', 12,
        'AMOLED6.78 Quad HD+ (2K+)', 10, NULL, '2022-04-21 19:21:24', 5, 2),
       (4, '2022-04-21 19:24:00', _binary '\0', NULL, 'Smart phone Samsung Galaxy S22 Ultra 5G 128GB',
        'Samsung Galaxy S22 Ultra', 30990000, 5000,
        '40MP | 108.0 MP + 12.0 MP + 10.0 MP + 10.0 MP', NULL, 'Android 12',
        'Snapdragon 8 Gen 1', 8, 'Dynamic AMOLED 2X6.8 Quad HD+ (2K+)', 15, NULL, '2022-04-21 19:24:00', 1, 1),
       (5, '2022-04-21 19:29:22', _binary '\0', NULL, 'Smart phone Samsung Galaxy Z Flip3 5G 256GB',
        'Samsung Galaxy Z Flip3', 21990000, 3300, '40MP | 2 camera 12 MP', NULL, 'Android 11',
        'Snapdragon 888', 8, 'Dynamic AMOLED 2XMain 6.7" & Sub 1.9"Full HD+', 20, NULL, '2022-04-21 19:29:22', 1,
        2),
       (6, '2022-04-21 19:31:07', _binary '\0', NULL, 'Smart phone Samsung Galaxy Z Flip3 5G 128GB',
        'Samsung Galaxy Z Flip3 (128GB)', 19990000, 3300, '40MP | 2 camera 12 MP', NULL,
        'Android 11', 'Snapdragon 888', 8, 'Dynamic AMOLED 2X Main 6.7 & Sub 1.9 Full HD+', 25, NULL,
        '2022-04-21 19:31:07', 1, 1),
       (7, '2022-04-21 19:34:25', _binary '\0', NULL, 'Smart phone OPPO Reno4 Pro', 'OPPO Reno4 Pr', 10490000, 4000,
        '32MP | Main 48 MP & Sub 8 MP, 2 MP, 2 MP', NULL, 'Android 10', 'Snapdragon 720G', 8,
        'AMOLED6.5 Full HD+', 30, NULL, '2022-04-21 19:34:25', 5, 3),
       (8, '2022-04-21 19:36:51', _binary '\0', NULL, 'Smart phone OPPO A16', 'OPPO A16', 3990000, 5000,
        '8MP | Wide-angle camera: 13 MP, f/2.2, Macro camera: 2 MP, f/2.4, Depth-sensing camera: 2 MP, f/2.4', NULL, 'Android 11', 'MediaTek Helio G35', 3,
        'IPS LCD6.52 HD+', 50, NULL, '2022-04-21 19:36:51', 5, NULL),
       (9, '2022-04-21 19:38:47', _binary '\0', NULL, 'Smart phone OPPO A76', 'OPPO A76', 5990000, 5000,
        '8MP | Main 13 MP & Sub 2 MP', NULL, 'Android 11', 'Snapdragon 680 8 nhÃ¢n', 6,
        'IPS LCD6.52 HD+', 40, NULL, '2022-04-21 19:38:47', 5, 3),
       (10, '2022-04-21 19:41:37', _binary '\0', NULL, 'Smart phone Samsung Galaxy A52s 5G 128GB',
        'Samsung Galaxy A52s', 10990000, 4500, '32MP | Main 64 MP & Secondary 12 MP, 5 MP, 5 MP',
        NULL, 'Android 11', 'Snapdragon 778G 5G 8 core', 6, 'Super AMOLED6.5 Full HD+', 30, NULL,
        '2022-04-21 19:41:37', 1, 3),
       (11, '2022-04-21 19:45:04', _binary '\0', NULL, 'Smart phone Samsung Galaxy S21 Ultra 5G',
        'Samsung Galaxy S21 Ultra 5G', 25990000, 5000,
        '40MP | Main 108 MP & Secondary 12 MP, 10 MP, 10 MP', NULL, 'Android 11', 'Exynos 2100', 12,
        'Dynamic AMOLED 2X6.8 Quad HD+ (2K+)', 15, NULL, '2022-04-21 19:45:04', 1, NULL),
       (12, '2022-04-21 19:47:45', _binary '\0', NULL, 'Smart phone Samsung Galaxy A53 5G 128GB',
        'Samsung Galaxy A53 5G 128GB', 9790000, 5000,
        '32MP | Main 64 MP & Secondary 12 MP, 5 MP, 5 MP', NULL, 'Android 12', 'Exynos 2180 8 core',
        8, 'Super AMOLED6.5 Full HD+', 25, NULL, '2022-04-21 19:47:45', 1, NULL),
       (13, '2022-04-21 19:50:38', _binary '\0', NULL, 'Smart phone iPhone 13 Pro Max 128GB', 'iPhone 13 Pro Max',
        33990000, 4352, '12MP | 3 camera 12 MP', NULL, 'IOS 15', 'Apple A15 Bionic', 6,
        'SOLED6.7 Super Retina XDR', 18, NULL, '2022-04-21 19:50:38', 2, NULL),
       (14, '2022-04-21 20:02:50', _binary '\0', NULL, 'Smart phone Nokia G10', ' Nokia G10', 3690000, 5050,
        '8MP | Main 13 MP & Sub 2 MP, 2 MP', NULL, 'Android 11', 'MediaTek Helio G25', 4,
        'TFT LCD6.5 HD+', 40, NULL, '2022-04-21 20:02:50', 3, 3);
UNLOCK
TABLES;

LOCK
TABLES `product_categories` WRITE;
INSERT INTO product_categories
VALUES (1, 1),
       (2, 1),
       (3, 1),
       (4, 1),
       (7, 1),
       (10, 1),
       (11, 1),
       (13, 1),
       (2, 2),
       (3, 2),
       (4, 2),
       (5, 2),
       (6, 2),
       (7, 2),
       (8, 2),
       (9, 2),
       (10, 2),
       (11, 2),
       (12, 2),
       (14, 2),
       (1, 3),
       (2, 3),
       (3, 3),
       (4, 3),
       (5, 3),
       (6, 3),
       (7, 3),
       (8, 3),
       (9, 3),
       (10, 3),
       (11, 3),
       (12, 3),
       (13, 3),
       (14, 3),
       (1, 4),
       (13, 4),
       (4, 6),
       (8, 6),
       (9, 6),
       (11, 6),
       (12, 6),
       (14, 6),
       (5, 7),
       (6, 7),
       (2, 8),
       (4, 8),
       (5, 8),
       (6, 8),
       (10, 8),
       (11, 8),
       (12, 8);
UNLOCK
TABLES;


LOCK
TABLES `feedback` WRITE;

UNLOCK
TABLES;

LOCK
TABLES `role` WRITE;
INSERT INTO `role`
VALUES (1, 'ROLE_ADMIN'),
       (2, 'ROLE_USER');
UNLOCK
TABLES;


LOCK
TABLES `transaction` WRITE;

UNLOCK
TABLES;


LOCK
TABLES `transaction_item` WRITE;

UNLOCK
TABLES;


LOCK
TABLES `user` WRITE;
INSERT INTO user
VALUES (1, NULL, NULL, '2022-04-22 13:14:58', _binary '\0', NULL, NULL, 'admin',
        '$2a$10$WmqVgrbLSD97T63/oJ0s6uefast5MSu0WHwO1WBvea.cRbe4GyS2O', 0, '2022-04-22 13:14:58', 'admin', NULL, 1),
       (2, 'Ha Noi', NULL, '2022-04-22 13:14:59', _binary '\0', NULL, NULL, 'Nguyen Van A',
        '$2a$10$h7L9UFEhNxNy4zUSL4gvjOmoLDWHg6yqpTqmMGxCNlJKp3iwX1pFS', 0, '2022-04-22 13:14:59', 'user', NULL, 2),
       (3, 'Hai Phong', NULL, '2022-04-22 13:17:02', _binary '\0', NULL, 'trietsm@gmail.com', 'Sai Minh Triet',
        '$2a$10$p.J8gRWxPekdzPFciH910OeFo8CTDmbTWuoRybE0J3L3mE4liog7O', 0, '2022-04-22 14:04:24', 'trietsm', NULL, 2),
       (4, 'Nam Dinh', NULL, '2022-04-22 13:18:01', _binary '\0', NULL, 'taidt@gmail.com', 'Do Tuan Tai',
        '$2a$10$Vjk87pZjUNPQ6CdU.ED4buIlnJhkzShrN9Vl.3FiqZflRzhshNjTO', 0, '2022-04-22 14:03:18', 'taidt', NULL, 2),
       (5, 'Hue', NULL, '2022-04-22 13:19:18', _binary '\0', NULL, 'nghiepph@gmail.com', 'Phan Hao Nghiep',
        '$2a$10$EL0peiP2m6SlqdMLsSVlheyLfBP6A9UoWdtitBEaCbEvE.XQGjnbS', 0, '2022-04-22 14:02:33', 'nghiepph', NULL, 2),
       (6, 'Nghe An', NULL, '2022-04-22 13:20:38', _binary '\0', NULL, 'an508@gmail.com', 'Vu Binh An',
        '$2a$10$od4NLGL47A5G2eW37NM2p.3JUpXL9QLhsBul9UQ143SWjo.Y0w3B.', 0, '2022-04-22 14:01:17', 'anvippro', NULL, 2);
UNLOCK
TABLES;

LOCK
TABLES `user_vouchers` WRITE;

UNLOCK
TABLES;

LOCK
TABLES `voucher` WRITE;

UNLOCK
TABLES;

