-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: e_com
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `brand`
--

INSERT INTO brand VALUES (1,'Samsung');
INSERT INTO brand VALUES (2,'Apple');
INSERT INTO brand VALUES (3,'Nokia');
INSERT INTO brand VALUES (4,'Huewei');
INSERT INTO brand VALUES (5,'Oppo');
INSERT INTO brand VALUES (6,'Blackberry');
INSERT INTO brand VALUES (7,'realme');
INSERT INTO brand VALUES (8,'xiaomi');
INSERT INTO brand VALUES (9,'vivo');
INSERT INTO brand VALUES (10,'itel');
INSERT INTO brand VALUES (11,'mastel');

--
-- Dumping data for table `cart`
--

INSERT INTO cart VALUES (1);
INSERT INTO cart VALUES (2);
INSERT INTO cart VALUES (3);
INSERT INTO cart VALUES (4);
INSERT INTO cart VALUES (5);
INSERT INTO cart VALUES (6);
INSERT INTO cart VALUES (7);

--
-- Dumping data for table `category`
--

INSERT INTO category VALUES (1,'Camera Phone');
INSERT INTO category VALUES (2,'Android Os');
INSERT INTO category VALUES (3,'Smart Phone');
INSERT INTO category VALUES (4,'Apple iOS');
INSERT INTO category VALUES (5,'Window Phone');
INSERT INTO category VALUES (6,'Well Battery');
INSERT INTO category VALUES (7,'Folding Screen');
INSERT INTO category VALUES (8,'5G');
INSERT INTO category VALUES (9,'Gaming');
INSERT INTO category VALUES (10,'fingerprint security');
INSERT INTO category VALUES (11,'thin and light');

--
-- Dumping data for table `discount`
--

INSERT INTO discount VALUES (1,'2022-04-30',10,'2022-04-19');
INSERT INTO discount VALUES (2,'2022-05-30',20,'2022-05-01');
INSERT INTO discount VALUES (3,'2022-04-23',50,'2022-04-21');
INSERT INTO discount VALUES (4,'2022-05-14',19,'2022-05-13');
INSERT INTO discount VALUES (5,'2022-05-10',36,'2022-05-01');
INSERT INTO discount VALUES (6,'2022-05-16',45,'2022-05-09');
INSERT INTO discount VALUES (7,'2022-05-26',55,'2022-05-13');
INSERT INTO discount VALUES (8,'2022-05-26',65,'2022-04-13');
INSERT INTO discount VALUES (9,'2022-06-01',76,'2022-04-03');
INSERT INTO discount VALUES (10,'2022-06-01',5,'2022-04-28');

--
-- Dumping data for table `feedback`
--


--
-- Dumping data for table `product`
--

INSERT INTO product VALUES (1,'2022-04-21 19:12:34',_binary '\0',NULL,'iPhone 11 Pro Max 256GB is the most advanced iPhone in the trio of iPhones Apple introduced in 2019 and indeed this smartphone has many equipment worthy of the \"Pro\" name.','iPhone 11 Pro Max',613.58,3969,'12MP | 3 camera 12 MP',256,'iOS 14','Apple A13 Bionic',4,'OLED6.5 Super Retina XDR',20,'https://cdn.tgdd.vn/Products/Images/42/210653/iphone-11-pro-max-256gb-black-600x600.jpg','2022-04-30 18:03:07',2,NULL);
INSERT INTO product VALUES (2,'2022-04-21 19:17:49',_binary '\0',NULL,'Samsung Galaxy Note 20 Ultra 5G  Samsung\'s flagship flagship model is perfect in every way, from its luxurious design to the incredible performance hidden inside. In particular, the \"powerful\" S Pen of the Note series has also been raised to a new level.','Samsung Galaxy Note 20 Ultra',870.51,4500,'10MP | Main 108 MP & Secondary 12 MP, 12 MP, Laser AF sensor',256,'Android 10','Exynos 990',12,'Dynamic AMOLED 2X6.9 Quad HD+ (2K+)',5,'https://cdn.tgdd.vn/Products/Images/42/225063/sam-sung-note-20-ultra-vang-dong-600x600.jpg','2022-04-21 19:17:49',1,1);
INSERT INTO product VALUES (3,'2022-04-21 19:21:24',_binary '\0',NULL,'Following the resounding success of the Find X generation, OPPO officially launched Find X2 with elegant lines from hardware design to software experience, promising a perfect beauty, a worthy power. .','OPPO Find X2',347.94,4200,'32MP | Main 48 MP & Sub 13 MP, 12 MP',256,'Android 10','Snapdragon 865',12,'AMOLED6.78 Quad HD+ (2K+)',10,'https://cdn.tgdd.vn/Products/Images/42/198150/oppo-find-x2-blue-600x600-1-600x600.jpg','2022-04-30 18:09:46',5,NULL);
INSERT INTO product VALUES (4,'2022-04-21 19:24:00',_binary '\0',NULL,'Integrating the perfect S Pen in the body, equipped with a powerful processor for extremely smooth usage tasks and more prominent with a unique bezel-less camera cluster with its own signature.','Samsung Galaxy S22 Ultra',1347.39,5000,'40MP | 108.0 MP + 12.0 MP + 10.0 MP + 10.0 MP',128,'Android 12','Snapdragon 8 Gen 1',8,'Dynamic AMOLED 2X6.8 Quad HD+ (2K+)',15,'https://cdn.tgdd.vn/Products/Images/42/235838/Galaxy-S22-Ultra-Burgundy-600x600.jpg','2022-04-30 18:13:03',1,NULL);
INSERT INTO product VALUES (5,'2022-04-21 19:29:22',_binary '\0',NULL,' The product has many improvements from durability to performance and it even exceeds everyone\'s expectations.','Samsung Galaxy Z Flip3',1173.47,3300,'40MP | 2 camera 12 MP',256,'Android 11','Snapdragon 888',8,'Dynamic AMOLED 2XMain 6.7\" & Sub 1.9\"Full HD+',20,'https://cdn.tgdd.vn/Products/Images/42/248283/samsung-galaxy-z-flip-3-violet-1-600x600.jpg','2022-04-30 18:13:03',1,NULL);
INSERT INTO product VALUES (6,'2022-04-21 19:31:07',_binary '\0',NULL,' This is a super product with a clamshell folding screen, the product will definitely attract a lot of attention from users, especially women.','Samsung Galaxy Z Flip3 (128GB)',1086.52,3300,'40MP | 2 camera 12 MP',128,'Android 11','Snapdragon 888',8,'Dynamic AMOLED 2X Main 6.7 & Sub 1.9 Full HD+',25,'https://cdn.tgdd.vn/Products/Images/42/229949/samsung-galaxy-z-flip-3-cream-1-600x600.jpg','2022-04-21 19:31:07',1,1);
INSERT INTO product VALUES (7,'2022-04-21 19:34:25',_binary '\0',NULL,'The device is equipped with an extremely high-end configuration with a Snapdragon 720G chip processor, an impressive set of 4 cameras up to 48 MP, and 65 W super fast charging technology, but is sold at an extremely affordable and accessible price.','OPPO Reno4 Pro',456.08,4000,'32MP | Main 48 MP & Sub 8 MP, 2 MP, 2 MP',256,'Android 10','Snapdragon 720G',8,'AMOLED6.5 Full HD+',30,'https://cdn.tgdd.vn/Products/Images/42/223497/oppo-reno4-pro-trang-600x600.jpg','2022-04-21 19:34:25',5,3);
INSERT INTO product VALUES (8,'2022-04-21 19:36:51',_binary '\0',NULL,'OPPO A16 - a cheap product from OPPO, this is a balanced phone in all aspects of the price range, it has a beautiful design, uses a gaming CPU from MediaTek and a super-buffalo battery.','OPPO A16',173.14,5000,'8MP | Wide-angle camera: 13 MP, f/2.2, Macro camera: 2 MP, f/2.4, Depth-sensing camera: 2 MP, f/2.4',32,'Android 11','MediaTek Helio G35',3,'IPS LCD6.52 HD+',50,'https://cdn.tgdd.vn/Products/Images/42/240631/oppo-a16-silver-8-600x600.jpg','2022-04-21 19:36:51',5,NULL);
INSERT INTO product VALUES (9,'2022-04-21 19:38:47',_binary '\0',NULL,'OPPO A76 4G launched with youthful design, stable performance, smooth 90 Hz screen and buffalo battery for long time use suitable for all users.','OPPO A76',260.43,5000,'8MP | Main 13 MP & Sub 2 MP',128,'Android 11','Snapdragon 680 8-core',6,'IPS LCD6.52 HD+',40,'https://cdn.tgdd.vn/Products/Images/42/270360/OPPO-A76-%C4%91en-600x600.jpg','2022-04-21 19:38:47',5,3);
INSERT INTO product VALUES (10,'2022-04-21 19:41:37',_binary '\0',NULL,'Here is an upgraded version of the Galaxy A52 5G launched not long ago, with the same appearance but significantly upgraded internal configuration parameters.','Samsung Galaxy A52s',477.82,4500,'32MP | Main 64 MP & Secondary 12 MP, 5 MP, 5 MP',128,'Android 11','Snapdragon 778G 5G 8 core',6,'Super AMOLED6.5 Full HD+',30,'https://cdn.tgdd.vn/Products/Images/42/247507/samsung-galaxy-a52s-5g-mint-600x600.jpg','2022-04-30 17:49:54',1,NULL);
INSERT INTO product VALUES (11,'2022-04-21 19:45:04',_binary '\0',NULL,'Galaxy S21 Ultra 5G with a series of upgrades and improvements not only in external appearance but also in internal strength, promises to fully meet the increasing needs of users.','Samsung Galaxy S21 Ultra ',1300.56,5000,'40MP | Main 108 MP & Secondary 12 MP, 10 MP, 10 MP',128,'Android 11','Exynos 2100',12,'Dynamic AMOLED 2X6.8 Quad HD+ (2K+)',15,'https://cdn.tgdd.vn/Products/Images/42/226316/samsung-galaxy-s21-ultra-bac-600x600-1-600x600.jpg','2022-04-21 19:45:04',1,NULL);
INSERT INTO product VALUES (12,'2022-04-21 19:47:45',_binary '\0',NULL,'Samsung Galaxy A53 5G 128GB launched with a modern design, stable performance and a sharp display screen, supporting high refresh rate to help you get moments of entertainment that are extremely eye-catching, or satisfying.','Samsung Galaxy A53 ',425.65,5000,'32MP | Main 64 MP & Secondary 12 MP, 5 MP, 5 MP',128,'Android 12','Exynos 2180 8 core',8,'Super AMOLED6.5 Full HD+',25,'https://cdn.tgdd.vn/Products/Images/42/246196/Samsung-Galaxy-A53-xanh-thumb-600x600.jpg','2022-04-21 19:47:45',1,NULL);
INSERT INTO product VALUES (13,'2022-04-21 19:50:38',_binary '\0',NULL,'this is still a product with a super beautiful screen, a smooth 120Hz refresh rate, a larger camera sensor, and strong performance with the power of Apple A15 Bionic, ready to go with You conquer every challenge.','iPhone 13 Pro Max',1477.8,4352,'12MP | 3 camera 12 MP',128,'IOS 15','Apple A15 Bionic',6,'SOLED6.7 Super Retina XDR',18,'https://cdn.tgdd.vn/Products/Images/42/274153/iphone-13-pro-max-xanh-la-thumb-600x600.jpg','2022-04-21 19:50:38',2,NULL);
INSERT INTO product VALUES (14,'2022-04-21 20:02:50',_binary '\0',NULL,'users will have a long-lasting experience with large battery capacity, stylish design and operate on the original and dark Android 11 operating system. Smoothness and up to 3 years update support.',' Nokia G10',160.43,5050,'8MP | Main 13 MP & Sub 2 MP, 2 MP',64,'Android 11','MediaTek Helio G25',4,'TFT LCD6.5 HD+',40,'https://cdn.tgdd.vn/Products/Images/42/235995/Nokia%20g10%20xanh%20duong-600x600.jpg','2022-04-21 20:02:50',3,3);
INSERT INTO product VALUES (15,'2022-04-25 20:30:26',_binary '\0',NULL,'Considered as the perfect lowcost iPhone version, the 128GB iPhone XR gives users more choices of diverse colors but still possesses a powerful configuration and luxurious design.',' Iphone 12 Pro Max ',587.35,2942,'7MP | 12MP',256,'OS 15','SApple A12 Bionic',3,'IPS LCD6.1 Liquid Retina)',55,'https://cdn.tgdd.vn/Products/Images/42/228743/iphone-12-pro-max-vang-new-600x600-1-600x600.jpg','2022-04-25 20:30:26',2,NULL);
INSERT INTO product VALUES (16,'2022-04-25 21:06:09',_binary '\0',NULL,'Apple has officially launched a trio of iPhone 11 super products, of which the 64GB iPhone 11 version has the cheapest price but is still upgraded as strongly as the iPhone XR launched before.',' Iphone 11  ',599.97,3110,'12MP | 12MP',64,'OS 15','SApple A13 Bionic',4,'IPS LCD6.1 Liquid Retina)',65,'https://cdn.tgdd.vn/Products/Images/42/153856/TimerThumb/iphone-11-(46).jpg','2022-04-25 21:06:09',2,NULL);
INSERT INTO product VALUES (17,'2022-04-25 21:14:58',_binary '\0',NULL,'Youthful design, large battery capacity and camera that supports many features. This will be a contact device, the solution and working Stable,… for your usage requirements.',' Realme C35   ',137.97,5000,'8MP | Main 50 MP & Sub 2 MP, 0.3 MP ',64,'Android 11','Unisoc T616 8-core',4,'IPS LCD6. Full HD+',75,'https://cdn.tgdd.vn/Products/Images/42/261888/realme-c35-thumb-new-600x600.jpg','2022-04-25 21:14:58',7,NULL);
INSERT INTO product VALUES (18,'2022-04-25 21:18:11',_binary '\0',NULL,'Youthful design, large battery capacity and camera that supports many features. This will be a contact device, the solution and working Stable,… for your usage requirements.',' Xiaomi Redmi Note 11S',291.07,5000,'16MP | Main 108 MP & Sub 8 MP ',128,'Android 11','MediaTek Helio G96 8-core',8,'AMOLED6.43 Full HD+',55,'https://cdn.tgdd.vn/Products/Images/42/272668/TimerThumb/xiaomi-redmi-note-11s-5g.jpg','2022-04-25 21:18:11',8,NULL);
INSERT INTO product VALUES (19,'2022-04-25 21:22:26',_binary '\0',NULL,'Xiaomi 12 Pro - the phone from the Xiaomi house possesses a calendar and extremely classy design, bringing in a dinosaur performance and a cluster of 3 50 MP cameras that bring the ability to take quality photos and videos. leading segment.','Xiaomi 12 Pro ',1217.77,4600,'32MP | 3 50MP ',256,'Android 12','Snapdragon 8 Gen 1 8-core',12,'AMOLED6.73 Quad HD+ (2K+)',35,'https://cdn.tgdd.vn/Products/Images/42/255635/Xiaomi-12-Pro-tim-thumb-mau-600x600.jpg','2022-04-25 21:22:26',8,NULL);
INSERT INTO product VALUES (20,'2022-04-25 21:26:26',_binary '\0',NULL,'Xiaomi Mi 11 is a super product from Xiaomi, experiencing top performance with Qualcomm Snapdragon 888 processor, and a series of top-notch technologies, anyone will be overwhelmed by this smartphone.','Xiaomi Mi 11',956.73,4600,'20MP | main 108MP, sub 16MP ',128,'Android 11','Snapdragon 888',8,'AMOLED6.73 Quad HD+ (2K+)',100,'https://cdn.tgdd.vn/Products/Images/42/233241/xiaomi-mi-11-lite-4g-blue-600x600.jpg','2022-04-30 17:59:40',8,NULL);
INSERT INTO product VALUES (21,'2022-04-25 21:31:17',_binary '\0',NULL,'A product of OPPO\'s Reno6 series, satisfying what users expect with its great configuration, impressive camera system and eye-catching appearance, excitedly waiting to experience it.','OPPO Reno6 Pro',826.21,4500,'32MP | main 50MP, sub 16MP ',256,'Android 11','Snapdragon 888',12,'AMOLED6.55 Full HD+',10,'https://cdn.tgdd.vn/Products/Images/42/236188/oppo-reno6-pro-plus-600x600.jpg','2022-04-25 21:31:17',5,NULL);
INSERT INTO product VALUES (22,'2022-04-25 21:34:15',_binary '\0',NULL,'A product of OPPO\'s Reno6 series, satisfying what users expect with its great configuration, impressive camera system and eye-catching appearance, excitedly waiting to experience it.','Xiaomi 11T Pro ',826.21,5000,'16MP | main 108MP, sub 8MP, 5MP ',256,'Android 11','Snapdragon 888',12,'AMOLED6.67 Full HD+',10,'https://cdn.tgdd.vn/Products/Images/42/248218/TimerThumb/xiaomi-11t-pro-(6).jpg','2022-04-25 21:34:15',8,8);
INSERT INTO product VALUES (23,'2022-04-25 21:37:29',_binary '\0',NULL,'This is a high-end flagship model that brings together many of the features Samfan loves, promising to bring the premium experience of the Galaxy S series at a more accessible price point.','Samsung Galaxy S20 FE ',826.21,4500,'32MP | main 12MP, sub 8MP, 12MP ',256,'Android 11','Snapdragon 865',8,'Super AMOLED6.5 Full HD+',10,'https://cdn.tgdd.vn/Products/Images/42/224859/samsung-galaxy-s20-fan-edition-090320-040338-600x600.jpg','2022-04-25 21:37:29',1,5);
INSERT INTO product VALUES (24,'2022-04-25 21:44:03',_binary '\0',NULL,'Xiaomi 11T full stands out with an extremely youthful design, AMOLED screen, a set of 3 sharp cameras and a large battery. This will be Xiaomi\'s model smartphone to satisfy all entertainment, work and passion needs. your creativity.','Xiaomi 11T',478.151,5000,'16MP | main 108MP, sub 8MP, 6MP ',256,'Android 11','MediaTek Dimensity 1200',8,'AMOLED6.67Full HD++',16,'https://cdn.tgdd.vn/Products/Images/42/259990/xiaomi-redmi-note-11t--5g-600x600.jpg','2022-04-25 21:44:03',8,NULL);
INSERT INTO product VALUES (25,'2022-04-25 22:42:34',_binary '\0',NULL,'A product that owns a lot of priority points such as beautiful design, large screen, dual cameras, extremely strong pins and many other positions are waiting for you..','Vivo Y15s',478.151,5000,'5MP | main 3MP, sub 2MP ',32,'Android 11 (Go Edition)','MediaTek Helio P35',3,'IPS LCD6.51 HD+',66,'https://cdn.tgdd.vn/Products/Images/42/249720/Vivo-y15s-2021-xanh-den-660x600.jpg','2022-04-25 22:42:34',9,9);
INSERT INTO product VALUES (26,'2022-04-25 22:45:39',_binary '\0',NULL,'Taking selfies with explosive rays in the night, modern new design to catch the trend, along with leading 5G network connection speeds, all impressive features are available in Vivo V21 5G, a near-premium phone to from Vivo.','Vivo V21',434.34,4000,'44MP | main 64MP, sub 8MP, 2MP ',128,'Android 11 ','MediaTek Dimensity 800U 5G',11,'AMOLED6.44 Full HD+',66,'https://cdn.tgdd.vn/Products/Images/42/238047/vivo-v21-5g-xanh-den-600x600.jpg','2022-04-25 22:45:39',9,5);
INSERT INTO product VALUES (27,'2022-04-25 22:53:35',_binary '\0',NULL,'This phone has a design quite similar to the mid-range products that Vivo recently launched, still a product with a youthful design with mirror black color and blue dream.','Vivo Y33s',303.91,5000,' MP | main 50MP, sub 2 2MP ',64,'Android 11','MediaTek Helio G80',8,'IPS LCD6.58 Full HD+',20,'https://cdn.tgdd.vn/Products/Images/42/249102/Vivo-y33s-yellow-thumb-600x600.jpg','2022-04-25 22:53:35',9,NULL);
INSERT INTO product VALUES (28,'2022-04-25 22:57:52',_binary '\0',NULL,'This phone has a design quite similar to the mid-range products that Vivo recently launched, still a product with a youthful design with mirror black color and blue dream.','Vivo Y01',303.91,5000,' 5MP | 8MP ',32,'Android 11(Go Edition)','MediaTek Helio P35',2,'IPS LCD 6.51 HD+',20,'https://cdn.tgdd.vn/Products/Images/42/268880/vivi-y01-%C4%91en-thumb-600x600.jpg','2022-04-25 22:57:52',9,NULL);
INSERT INTO product VALUES (29,'2022-04-25 23:03:00',_binary '\0',NULL,'Owning a good-looking smartphone with good configuration, cheap price is beyond imagination with Itel L6502, a beautiful, well-priced version from Itel is ready for you to experience.','Itel L6502',100.5,4000,' 5MP | 8MP ',32,'Android 10(Go Edition)','Spreadtrum SC9832E',3,'IPS LCD 6.51 HD+',20,'https://cdn.tgdd.vn/Products/Images/42/251897/itel-l6502-xanh-ngoc-thumb-new-600x600.jpg','2022-04-25 23:03:00',10,10);
INSERT INTO product VALUES (30,'2022-04-25 23:08:15',_binary '\0',NULL,'Xiaomi Redmi 9C (3GB / 64GB), an outstanding smartphone in the low-cost phone segment with a sophisticated and luxurious design, powerful performance, the new Helio G35, a huge battery, and a set of 3 AI cameras that capture all engraving set.','Xiaomi Redmi 9C',100.5,5000,' 5MP | main 13MP, sub 2 2MP ',64,'Android 10','MediaTek Helio G35',3,'IPS LCD 6.53 HD+',26,'https://cdn.tgdd.vn/Products/Images/42/226321/xiaomi-redmi-9c-3gb-xam-600x600.jpg','2022-04-25 23:08:15',8,9);
INSERT INTO product VALUES (31,'2022-04-25 23:11:34',_binary '\0',NULL,'Xiaomi Redmi 9C (3GB / 64GB), an outstanding smartphone in the low-cost phone segment with a sophisticated and luxurious design, powerful performance, the new Helio G35, a huge battery, and a set of 3 AI cameras that capture all engraving set.','Xiaomi Redmi 10C',151.75,5000,' 5MP | main 50MP, sub 2 2MP ',64,'Android 11','Snapdragon 680 8-cỏe',4,'IPS LCD 6.71 HD+',30,'https://cdn.tgdd.vn/Products/Images/42/271843/xiaomi-redmi-10c-xanh-luc-thumb-600x600.jpg','2022-04-25 23:11:34',8,5);
INSERT INTO product VALUES (32,'2022-04-26 14:29:18',_binary '\0',NULL,'This Xiaomi smartphone has a stable performance, luxurious design and large screen that meets your daily tasks with ease.','Xiaomi 11 Lite 5G NE',413.08,4250,' 20MP | main 64MP, sub 8MP, 5MP ',128,'Android 11','Snapdragon 778G 5G 8-core',8,'AMOLED6.55 Full HD+',30,'https://cdn.tgdd.vn/Products/Images/42/256053/xiaomi-11-lite-5g-ne-trang-swarovski-1-660x600.jpg','2022-04-26 14:29:18',8,9);
INSERT INTO product VALUES (33,'2022-04-26 14:33:10',_binary '\0',NULL,'owns a high-end, luxurious design in addition to extremely powerful configuration, promising to bring great competition in the mid-range smartphone segment.','Xiaomi Redmi Note 10 Pro',326.03,5020,' 16MP | main 108MP, sub 8MP, 5MP ',128,'Android 11','Snapdragon 732G',8,'AMOLED 6.67 Full HD+',30,'https://cdn.tgdd.vn/Products/Images/42/229228/xiaomi-redmi-note-10-pro-thumb-xam-600x600-200x200.jpg','2022-04-26 14:33:10',8,5);
INSERT INTO product VALUES (34,'2022-04-26 15:22:30',_binary '\0',NULL,'The affordable price focus on dynamic design, fast charging and impressive multitasking performance will make your life more attractive, full of fun.','OPPO A95 ',304.26,5000,' 16MP | main 48MP, sub 2MP, 2MP ',128,'Android 11','Snapdragon 662',8,'AMOLED 6.43 Full HD+',40,'https://cdn.tgdd.vn/Products/Images/42/251703/oppo-a95-4g-bac-2-600x600.jpg','2022-04-26 15:22:30',5,NULL);
INSERT INTO product VALUES (35,'2022-04-26 15:27:27',_binary '\0',NULL,'Samsung\'s first Galaxy One phone in 2022 in Vietnam market. This is a product with an accessible price, has a main camera of up to 48 MP, a 5000 mAh battery that is comfortable for all day use.','Samsung Galaxy A03 ',130.15,5000,' 5MP | main 48MP, sub 2MP ',32,'Android 11','Unisoc T606 8-core',3,'PLS LCD 6.5 HD+',44,'https://cdn.tgdd.vn/Products/Images/42/260153/samsung-galaxy-a03-core-161121-091642-600x600.jpg','2022-04-26 15:27:27',5,7);
INSERT INTO product VALUES (36,'2022-04-26 18:08:58',_binary '\0',NULL,'no description','Samsung Galaxy M33 5G',334.73,5000,' 8MP | main 50MP, sub 5MP, 2 2MP ',128,'Android 12','Exynos 1280 8-core',6,'TFT LCD 6.6 Full HD+',54,'https://cdn.tgdd.vn/Products/Images/42/256197/Samsung-galaxy-m53-green-600x600.jpg','2022-04-30 17:59:40',1,NULL);
INSERT INTO product VALUES (37,'2022-04-26 18:13:03',_binary '\0',NULL,'The phone belongs to the mid-range segment but possesses many outstanding points in terms of a large sharp screen, a set of 64 MP cameras and a high-performance processor and is sold at an extremely good price.','Samsung Galaxy A32',282.5,5000,' 20MP | main 64MP, sub 8MP, 2 5MP ',128,'Android 11','MediaTek Helio G80',6,'Super AMOLED6.4 Full HD+',4,'https://cdn.tgdd.vn/Products/Images/42/234315/samsung-galaxy-a32-4g-thumb-tim-600x600-200x200.jpg','2022-04-26 18:13:03',1,7);
INSERT INTO product VALUES (38,'2022-04-26 18:17:01',_binary '\0',NULL,'Cheap smartphone from the Samsung brand, it possesses a stable configuration along with a large 5000 mAh battery to meet as diverse as user requirements.','Samsung Galaxy A12',160.62,5000,' 8MP | main 48MP, sub 5MP, 2 2MP ',128,'Android 11','Exynos 850',4,'PLS TFT LCD6.5 HD+',14,'https://cdn.tgdd.vn/Products/Images/42/251886/samsung-galaxy-a12-2021-blue-600x600.jpg','2022-04-26 18:17:01',1,6);
INSERT INTO product VALUES (39,'2022-04-26 18:21:40',_binary '\0',NULL,'Redmi 9A is a smartphone from Xiaomi aimed at customers who are looking for a product with a good price, as well as fully equipped with impressive features.','Xiaomi Redmi 9A',108.39,5000,' 5MP | main 13MP ',32,'Android 10','MediaTek Helio G25',2,'IPS LCD6.53 HD+',29,'https://cdn.tgdd.vn/Products/Images/42/246195/samsung-galaxy-a73-5g-xanh-thumb-600x600.jpg','2022-04-26 18:21:40',8,8);
INSERT INTO product VALUES (40,'2022-04-26 18:27:46',_binary '\0',NULL,'The lowest version in the iPhone 12 series 4, but still possesses outstanding points in terms of compact size, benefits, peak efficiency, fast features and high quality camera set.','iPhone 12 mini',826.6,2227,' 12MP | 2 12MP ',64,'iOS 15','Apple A14 Bionic',4,'OLED5.4 Super Retina XDR',19,'https://cdn.tgdd.vn/Products/Images/42/228742/iphone-23-mini-xanh-la-new-600x600-600x600.jpg','2022-04-26 18:27:46',2,NULL);
INSERT INTO product VALUES (41,'2022-04-26 18:30:15',_binary '\0',NULL,'A series of upgrades in configuration and feature owners, all in one device. This phone promises to be a device purely aimed at customers who prefer compactness but still retain the powerful inside.','iPhone 13 mini',804.84,2438,' 12MP | 2 12MP ',128,'iOS 15','Apple A15 Bionic',4,'OLED5.4 Super Retina XDR',39,'https://cdn.tgdd.vn/Products/Images/42/236780/iphone-13-mini-pink-1-600x600.jpg','2022-04-26 18:30:15',2,7);
INSERT INTO product VALUES (42,'2022-04-26 18:35:38',_binary '\0',NULL,'The smartphone still retains the high-end design, the 3-camera cluster has been upgraded, the configuration is strong and the impressive quantitative pins.','iPhone 13 Pro',804.84,3095,' 12MP | 2 12MP ',128,'iOS 15','Apple A15 Bionic',6,'OLED5.1 Super Retina XDR',59,'https://cdn.tgdd.vn/Products/Images/42/250259/iphone-13-pro-thumb-600x600.jpg','2022-04-30 18:09:46',2,NULL);
INSERT INTO product VALUES (43,'2022-04-26 18:40:26',_binary '\0',NULL,'Large screen, stable performance provides a smooth experience on daily tasks and long usage time thanks to the huge battery built into the phone.','Nokia G21',804.84,5050,' 8MP | main 50MP, sub 2 2MP ',128,'Android 11','Unisoc T606 8-core',4,'TFT LCD6.5 HD+',59,'https://cdn.tgdd.vn/Products/Images/42/270207/nokia-g21-xanh-thumb-600x600.jpg','2022-04-26 18:40:26',3,7);
INSERT INTO product VALUES (44,'2022-04-26 18:45:23',_binary '\0',NULL,'mid-range but conquer users with beautiful design, impressive configuration and excellent camera cluster, will be device communication, entertainment and stable work game, ... for the usage requirements of the ban .','Xiaomi Redmi Note 10S',260.74,5000,' 16MP | main 64MP, sub 8MP, 2 2MP ',128,'Android 11','MediaTek Helio G95',6,'AMOLED6.43 Full HD+',49,'https://cdn.tgdd.vn/Products/Images/42/262534/xiaomi-redmi-note-10s-6gb-thumb-1-600x600.jpg','2022-04-26 18:45:23',8,6);
INSERT INTO product VALUES (45,'2022-04-26 18:48:14',_binary '\0',NULL,'Mi 11 Lite can fully meet the usual services easily and more especially, the device has an extremely light and fashionable design.',' Xiaomi Mi 11 Lit',347.794,4250,' 16MP | main 64MP, sub 8MP, 5MP ',128,'Android 11','Snapdragon 732G',8,'AMOLED6.65 Full HD+',39,'https://cdn.tgdd.vn/Products/Images/42/233241/xiaomi-mi-11-lite-4g-blue-600x600.jpg','2022-04-26 18:48:14',8,9);
INSERT INTO product VALUES (46,'2022-04-26 18:52:35',_binary '\0',NULL,'mid-range, stable configuration from Snapdragon chip and youthful, beautiful appearance and a quality camera cluster, will be a good and affordable customer.',' Xiaomi Redmi Note 11',217.21,5000,' 13MP | main 8MP, sub 2 2MP ',128,'Android 11','Snapdragon 680 8-core',4,'AMOLED6.43 Full HD+',69,'https://cdn.tgdd.vn/Products/Images/42/269832/Xiaomi-redmi-note-11-blue-600x600.jpeg','2022-04-26 18:52:35',8,4);
INSERT INTO product VALUES (47,'2022-04-26 18:57:13',_binary '\0',NULL,'Nokia C30 is a low-cost smartphone line that has been carefully established and invested by Nokia with valuable upgrades in terms of camera performance and a huge battery compared to the re-experienced Nokia C20 and better than its predecessor.',' Nokia C30',130.15,6000,' 5MP | main 13MP, sub 2MP ',32,'Android 11(Go Edition)','Spreadtrum SC9863A',3,'IPS LCD6.82 HD+',39,'https://cdn.tgdd.vn/Products/Images/42/239748/nokia-c30-xanh-la-600x600.jpg','2022-04-26 18:57:13',3,NULL);
INSERT INTO product VALUES (49,'2022-04-26 19:09:57',_binary '\0',NULL,'the low-cost segment with a highlight of luxurious geometric design, a set of 3 quality cameras, effects that meet the requirements quite well and the battery life corresponds to the estimated time for users to experience impressively.',' Realme C21-Y ',132.33,5000,' 5MP | main 13MP, sub 2 2MP ',32,'Android 11','Spreadtrum T610 8-core',3,'IPS LCD6.5 HD+',29,'https://cdn.tgdd.vn/Products/Images/42/246195/samsung-galaxy-a73-5g-xanh-thumb-600x600.jpg','2022-04-26 19:09:57',7,NULL);
INSERT INTO product VALUES (50,'2022-04-26 19:13:21',_binary '\0',NULL,'A pretty good price, possessing a modern design with 3 AI cameras up to 50 MP, stable performance and long usage time thanks to a huge 5000 mAh battery, considered one of the fantasy products. you should own',' Realme C25-Y ',164.54,5000,' 8MP | main 50MP, sub 2 2MP ',64,'Android 11','Unisoc T618 8-core',4,'IPS LCD6.5 HD+',59,'https://cdn.tgdd.vn/Products/Images/42/246195/samsung-galaxy-a73-5g-xanh-thumb-600x600.jpg','2022-04-26 19:13:21',7,6);
INSERT INTO product VALUES (51,'2022-04-26 19:16:16',_binary '\0',NULL,'mid-range segment, featuring Realme\'s signature design, a smartphone equipped with effects in full power and with a corresponding battery capacity.',' Realme 8  ',261.17,5000,' 16MP | main 64MP, sub 8MP, 2 2MP ',128,'Android 11','Unisoc T618 8-core',8,'Super AMOLED6.4 Full HD+',50,'https://cdn.tgdd.vn/Products/Images/42/233135/realme-8-silver-600x600.jpg','2022-04-26 19:16:16',7,8);

--
-- Dumping data for table `product_categories`
--

INSERT INTO product_categories VALUES (1,1);
INSERT INTO product_categories VALUES (2,1);
INSERT INTO product_categories VALUES (3,1);
INSERT INTO product_categories VALUES (4,1);
INSERT INTO product_categories VALUES (7,1);
INSERT INTO product_categories VALUES (10,1);
INSERT INTO product_categories VALUES (11,1);
INSERT INTO product_categories VALUES (13,1);
INSERT INTO product_categories VALUES (17,1);
INSERT INTO product_categories VALUES (18,1);
INSERT INTO product_categories VALUES (19,1);
INSERT INTO product_categories VALUES (20,1);
INSERT INTO product_categories VALUES (21,1);
INSERT INTO product_categories VALUES (22,1);
INSERT INTO product_categories VALUES (26,1);
INSERT INTO product_categories VALUES (31,1);
INSERT INTO product_categories VALUES (32,1);
INSERT INTO product_categories VALUES (33,1);
INSERT INTO product_categories VALUES (36,1);
INSERT INTO product_categories VALUES (37,1);
INSERT INTO product_categories VALUES (39,1);
INSERT INTO product_categories VALUES (44,1);
INSERT INTO product_categories VALUES (45,1);
INSERT INTO product_categories VALUES (46,1);
INSERT INTO product_categories VALUES (47,1);
INSERT INTO product_categories VALUES (50,1);
INSERT INTO product_categories VALUES (51,1);
INSERT INTO product_categories VALUES (2,2);
INSERT INTO product_categories VALUES (3,2);
INSERT INTO product_categories VALUES (4,2);
INSERT INTO product_categories VALUES (5,2);
INSERT INTO product_categories VALUES (6,2);
INSERT INTO product_categories VALUES (7,2);
INSERT INTO product_categories VALUES (8,2);
INSERT INTO product_categories VALUES (9,2);
INSERT INTO product_categories VALUES (10,2);
INSERT INTO product_categories VALUES (11,2);
INSERT INTO product_categories VALUES (12,2);
INSERT INTO product_categories VALUES (14,2);
INSERT INTO product_categories VALUES (17,2);
INSERT INTO product_categories VALUES (18,2);
INSERT INTO product_categories VALUES (19,2);
INSERT INTO product_categories VALUES (20,2);
INSERT INTO product_categories VALUES (21,2);
INSERT INTO product_categories VALUES (22,2);
INSERT INTO product_categories VALUES (23,2);
INSERT INTO product_categories VALUES (24,2);
INSERT INTO product_categories VALUES (25,2);
INSERT INTO product_categories VALUES (26,2);
INSERT INTO product_categories VALUES (28,2);
INSERT INTO product_categories VALUES (29,2);
INSERT INTO product_categories VALUES (30,2);
INSERT INTO product_categories VALUES (31,2);
INSERT INTO product_categories VALUES (32,2);
INSERT INTO product_categories VALUES (33,2);
INSERT INTO product_categories VALUES (34,2);
INSERT INTO product_categories VALUES (35,2);
INSERT INTO product_categories VALUES (36,2);
INSERT INTO product_categories VALUES (37,2);
INSERT INTO product_categories VALUES (38,2);
INSERT INTO product_categories VALUES (39,2);
INSERT INTO product_categories VALUES (43,2);
INSERT INTO product_categories VALUES (44,2);
INSERT INTO product_categories VALUES (45,2);
INSERT INTO product_categories VALUES (46,2);
INSERT INTO product_categories VALUES (47,2);
INSERT INTO product_categories VALUES (49,2);
INSERT INTO product_categories VALUES (50,2);
INSERT INTO product_categories VALUES (51,2);
INSERT INTO product_categories VALUES (1,3);
INSERT INTO product_categories VALUES (2,3);
INSERT INTO product_categories VALUES (3,3);
INSERT INTO product_categories VALUES (4,3);
INSERT INTO product_categories VALUES (5,3);
INSERT INTO product_categories VALUES (6,3);
INSERT INTO product_categories VALUES (7,3);
INSERT INTO product_categories VALUES (8,3);
INSERT INTO product_categories VALUES (9,3);
INSERT INTO product_categories VALUES (10,3);
INSERT INTO product_categories VALUES (11,3);
INSERT INTO product_categories VALUES (12,3);
INSERT INTO product_categories VALUES (13,3);
INSERT INTO product_categories VALUES (14,3);
INSERT INTO product_categories VALUES (15,3);
INSERT INTO product_categories VALUES (16,3);
INSERT INTO product_categories VALUES (17,3);
INSERT INTO product_categories VALUES (18,3);
INSERT INTO product_categories VALUES (19,3);
INSERT INTO product_categories VALUES (20,3);
INSERT INTO product_categories VALUES (21,3);
INSERT INTO product_categories VALUES (22,3);
INSERT INTO product_categories VALUES (23,3);
INSERT INTO product_categories VALUES (24,3);
INSERT INTO product_categories VALUES (25,3);
INSERT INTO product_categories VALUES (26,3);
INSERT INTO product_categories VALUES (28,3);
INSERT INTO product_categories VALUES (29,3);
INSERT INTO product_categories VALUES (30,3);
INSERT INTO product_categories VALUES (31,3);
INSERT INTO product_categories VALUES (32,3);
INSERT INTO product_categories VALUES (33,3);
INSERT INTO product_categories VALUES (34,3);
INSERT INTO product_categories VALUES (35,3);
INSERT INTO product_categories VALUES (36,3);
INSERT INTO product_categories VALUES (37,3);
INSERT INTO product_categories VALUES (38,3);
INSERT INTO product_categories VALUES (39,3);
INSERT INTO product_categories VALUES (40,3);
INSERT INTO product_categories VALUES (41,3);
INSERT INTO product_categories VALUES (42,3);
INSERT INTO product_categories VALUES (43,3);
INSERT INTO product_categories VALUES (44,3);
INSERT INTO product_categories VALUES (45,3);
INSERT INTO product_categories VALUES (46,3);
INSERT INTO product_categories VALUES (47,3);
INSERT INTO product_categories VALUES (49,3);
INSERT INTO product_categories VALUES (50,3);
INSERT INTO product_categories VALUES (51,3);
INSERT INTO product_categories VALUES (1,4);
INSERT INTO product_categories VALUES (13,4);
INSERT INTO product_categories VALUES (15,4);
INSERT INTO product_categories VALUES (16,4);
INSERT INTO product_categories VALUES (27,4);
INSERT INTO product_categories VALUES (40,4);
INSERT INTO product_categories VALUES (41,4);
INSERT INTO product_categories VALUES (42,4);
INSERT INTO product_categories VALUES (27,5);
INSERT INTO product_categories VALUES (4,6);
INSERT INTO product_categories VALUES (8,6);
INSERT INTO product_categories VALUES (9,6);
INSERT INTO product_categories VALUES (11,6);
INSERT INTO product_categories VALUES (12,6);
INSERT INTO product_categories VALUES (14,6);
INSERT INTO product_categories VALUES (17,6);
INSERT INTO product_categories VALUES (18,6);
INSERT INTO product_categories VALUES (22,6);
INSERT INTO product_categories VALUES (25,6);
INSERT INTO product_categories VALUES (28,6);
INSERT INTO product_categories VALUES (30,6);
INSERT INTO product_categories VALUES (31,6);
INSERT INTO product_categories VALUES (33,6);
INSERT INTO product_categories VALUES (34,6);
INSERT INTO product_categories VALUES (35,6);
INSERT INTO product_categories VALUES (36,6);
INSERT INTO product_categories VALUES (37,6);
INSERT INTO product_categories VALUES (38,6);
INSERT INTO product_categories VALUES (39,6);
INSERT INTO product_categories VALUES (43,6);
INSERT INTO product_categories VALUES (44,6);
INSERT INTO product_categories VALUES (45,6);
INSERT INTO product_categories VALUES (46,6);
INSERT INTO product_categories VALUES (47,6);
INSERT INTO product_categories VALUES (49,6);
INSERT INTO product_categories VALUES (50,6);
INSERT INTO product_categories VALUES (51,6);
INSERT INTO product_categories VALUES (5,7);
INSERT INTO product_categories VALUES (6,7);
INSERT INTO product_categories VALUES (2,8);
INSERT INTO product_categories VALUES (4,8);
INSERT INTO product_categories VALUES (5,8);
INSERT INTO product_categories VALUES (6,8);
INSERT INTO product_categories VALUES (10,8);
INSERT INTO product_categories VALUES (11,8);
INSERT INTO product_categories VALUES (12,8);
INSERT INTO product_categories VALUES (26,8);
INSERT INTO product_categories VALUES (27,8);
INSERT INTO product_categories VALUES (32,8);
INSERT INTO product_categories VALUES (34,8);
INSERT INTO product_categories VALUES (17,9);
INSERT INTO product_categories VALUES (18,9);
INSERT INTO product_categories VALUES (19,9);
INSERT INTO product_categories VALUES (20,9);
INSERT INTO product_categories VALUES (21,9);
INSERT INTO product_categories VALUES (22,9);
INSERT INTO product_categories VALUES (23,9);
INSERT INTO product_categories VALUES (24,9);
INSERT INTO product_categories VALUES (40,9);
INSERT INTO product_categories VALUES (41,9);
INSERT INTO product_categories VALUES (42,9);
INSERT INTO product_categories VALUES (44,9);
INSERT INTO product_categories VALUES (45,9);
INSERT INTO product_categories VALUES (46,9);
INSERT INTO product_categories VALUES (16,10);
INSERT INTO product_categories VALUES (28,10);
INSERT INTO product_categories VALUES (32,10);
INSERT INTO product_categories VALUES (51,10);
INSERT INTO product_categories VALUES (16,11);
INSERT INTO product_categories VALUES (19,11);
INSERT INTO product_categories VALUES (20,11);

--
-- Dumping data for table `product_image`
--


--
-- Dumping data for table `role`
--

INSERT INTO role VALUES (1,'ROLE_ADMIN');
INSERT INTO role VALUES (2,'ROLE_USER');

--
-- Dumping data for table `shipment`
--


--
-- Dumping data for table `transaction`
--

-- Dumping data for table `user`
--

INSERT INTO user VALUES (1,'Ho Chi Minh',NULL,'2022-04-22 13:14:58',_binary '\0',NULL,'admin@gmail.com','admin','$2a$10$WmqVgrbLSD97T63/oJ0s6uefast5MSu0WHwO1WBvea.cRbe4GyS2O',0,'2022-04-22 13:14:58','admin',NULL,1);
INSERT INTO user VALUES (2,'Ha Noi',NULL,'2022-04-22 13:14:59',_binary '\0',NULL,'user@gmail.com','user','$2a$10$h7L9UFEhNxNy4zUSL4gvjOmoLDWHg6yqpTqmMGxCNlJKp3iwX1pFS',0,'2022-04-22 13:14:59','user',NULL,2);
INSERT INTO user VALUES (3,'Hai Phong',NULL,'2022-04-22 13:17:02',_binary '\0',NULL,'trietsm@gmail.com','Sai Minh Triet','$2a$10$p.J8gRWxPekdzPFciH910OeFo8CTDmbTWuoRybE0J3L3mE4liog7O',0,'2022-04-22 14:04:24','trietsm',NULL,2);
INSERT INTO user VALUES (4,'Nam Dinh',NULL,'2022-04-22 13:18:01',_binary '\0',NULL,'taidt@gmail.com','Do Tuan Tai','$2a$10$Vjk87pZjUNPQ6CdU.ED4buIlnJhkzShrN9Vl.3FiqZflRzhshNjTO',0,'2022-04-22 14:03:18','taidt',NULL,2);
INSERT INTO user VALUES (5,'Hue',NULL,'2022-04-22 13:19:18',_binary '\0',NULL,'nghiepph@gmail.com','Phan Hao Nghiep','$2a$10$EL0peiP2m6SlqdMLsSVlheyLfBP6A9UoWdtitBEaCbEvE.XQGjnbS',0,'2022-04-30 17:47:12','nghiepph',1,2);
INSERT INTO user VALUES (6,'Nghe An',NULL,'2022-04-22 13:20:38',_binary '\0',NULL,'an508@gmail.com','Vu Binh An','$2a$10$od4NLGL47A5G2eW37NM2p.3JUpXL9QLhsBul9UQ143SWjo.Y0w3B.',0,'2022-04-30 17:52:01','anvippro',2,2);
INSERT INTO user VALUES (7,'Ha Noi',NULL,'2022-04-26 19:17:35',_binary '\0',NULL,'vinhdq@gmail.com','Dang Quang Vinh','$2a$10$FuXH5u09esgcAm1PHQSWy.BS72eM4LYPmAjaCuyTbiK.fTDSEF49O',0,'2022-04-26 19:56:33','1901040241',NULL,1);
INSERT INTO user VALUES (8,'Ha Noi',NULL,'2022-04-26 19:18:42',_binary '\0',NULL,'soda@gmail.com','Nguyen Dang Cong Son','$2a$10$YLNZErXlMEDsBDzt8gffIu/hfYKaDcBDhV185XHsWo0CAXnPJOmwK',0,'2022-04-26 19:58:40','1901040176',NULL,1);
INSERT INTO user VALUES (9,'Ha Noi',NULL,'2022-04-26 19:19:41',_binary '\0',NULL,'sugara@gmail.com','Khuat Dinh Linh','$2a$10$hPjPyZ9BRWZaJqbY1pvxquL.qO8mLGEQOpvHlu4y1SKWGzl9HhrPe',0,'2022-04-26 19:58:47','1901040122',NULL,1);
INSERT INTO user VALUES (10,'Ha Nam',NULL,'2022-04-26 19:20:29',_binary '\0',NULL,'duclt@gmail.com','Lai Tien Duc','$2a$10$jlG2MMcaUrJRwlUnXULZp.dimcw0KiI2h7g7ESn8eR5dRsTDvvknW',0,'2022-04-26 19:59:31','1901040059',NULL,1);
INSERT INTO user VALUES (11,'Ha Noi',NULL,'2022-04-26 19:22:19',_binary '\0',NULL,'vudoimu@gmail.com','Trinh Long Vu','$2a$10$0UbqdhHYMXOkHvDh.M2Fe.h9rBEV507a0QsDZx3Q/PuYcjWUBNddy',0,'2022-04-26 20:00:09','1901040245',NULL,1);
INSERT INTO user VALUES (12,'Nam Dinh',NULL,'2022-04-26 19:23:50',_binary '\0',NULL,'quynhvl@gmail.com','Vu Le Quynh','$2a$10$215rMdWe1u8.l3Tt3alFtOlwi1Fzw5hWk8WjHol8O7nDVcE6Q9b4q',0,'2022-04-30 17:54:06','quynhvl',3,2);
INSERT INTO user VALUES (13,'Hung Yen',NULL,'2022-04-26 19:24:52',_binary '\0',NULL,'thykm@gmail.com','Kieu Mai Thy','$2a$10$reR9uVvH2p91Nz8Q3XJPduJ9MMoqKWOkNEUbIikhTfwhTJh.Oz3cq',0,'2022-04-26 19:27:02','thykm',NULL,2);
INSERT INTO user VALUES (14,'Hai Phong',NULL,'2022-04-26 19:27:10',_binary '\0',NULL,'phucnd@gmail.com','Ngo Dinh Phuc','$2a$10$bEFoCQ.RLpV4gFk4jdkn8.QoUqcYzM.3ZwgXrZ7WhERxGmXUPGk3a',0,'2022-04-30 17:58:12','phucnd',4,2);
INSERT INTO user VALUES (15,'Thai Binh',NULL,'2022-04-26 19:28:49',_binary '\0',NULL,'duongld@gmail.com','Ly Dong Duong','$2a$10$rJyHVc7k/xiz5R64RaZC0O31vSUchXo9qYUdJUEHOXasg/3W.F4h6',0,'2022-04-26 19:29:01','duongld',NULL,2);
INSERT INTO user VALUES (16,'Hung Yen',NULL,'2022-04-26 19:29:39',_binary '\0',NULL,'hunglt@gmail.com','Ly The Hung','$2a$10$7v4CBcjM1OxJMF788Q7mZuyVAxLg5syLp2ErFfSRD6eUuvbteFyfG',0,'2022-04-30 18:00:07','hunglt',5,2);
INSERT INTO user VALUES (17,'Lao Cai',NULL,'2022-04-26 19:30:22',_binary '\0',NULL,'lanlh@gmail.com','Ly Hoang Lan','$2a$10$aC/U10bt1jIk3nTPtGBwLu5VeyZ6OUvfU3j6AvOwUhpkF/YFaJX0m',0,'2022-04-30 18:08:13','lanlh',6,2);
INSERT INTO user VALUES (18,'Son La',NULL,'2022-04-26 19:31:24',_binary '\0',NULL,'ngocbv@gmail.com','Bui Van Ngoc','$2a$10$G5xo9eOT0J37nxIVGH89NORYW2nhjlQQaTHT4/QuTKQDGHtx6yRNe',0,'2022-04-30 18:12:31','ngocbv',7,2);
INSERT INTO user VALUES (19,'Bac Lieu',NULL,'2022-04-26 19:32:11',_binary '\0',NULL,'maibt@gmail.com','Bui Thanh Mai','$2a$10$GNQgBBYpx7hYInVmQXW7FuOTipPqN9thpGoQmgArVv6uOPMjKpOVe',0,'2022-04-26 19:32:22','maibt',NULL,2);
INSERT INTO user VALUES (20,'Ho Chi Minh',NULL,'2022-04-26 19:33:04',_binary '\0',NULL,'hangnt@gmail.com','Nguyen Thanh Hang','$2a$10$tFUWFsZZZzB/lfz/70lvHO2YwxdaGWMER2mKG9BvMp.CwHW1j16ie',0,'2022-04-26 19:33:14','hangnt',NULL,2);
INSERT INTO user VALUES (21,'Thai Nguyen',NULL,'2022-04-26 20:00:54',_binary '\0',NULL,'anh@gmail.com','Tran Ngoc Anh','$2a$10$mizEJVMJmxqB5tcTzZ4tGekeQ17FLcQRqpaMWbzC8eUTB4J98k/jG',0,'2022-04-26 20:00:54','1901040026',NULL,1);
INSERT INTO user VALUES (22,'Cao Bang',NULL,'2022-04-26 20:01:45',_binary '\0',NULL,'hoanbn@gmail.com','Bui Ngoc Hoan','$2a$10$QXPVshkWbuRnIg6cULmEc.M29maLnKJz2pamD0mjqdZ.ARwC.80ze',0,'2022-04-26 20:01:45','hoanbn',NULL,2);
INSERT INTO user VALUES (23,'Bac Can',NULL,'2022-04-26 20:02:45',_binary '\0',NULL,'thaipa@gmail.com','Phan Anh Thai','$2a$10$RZwn/nMSvNhEVIn3Ka.MS.RMjOePKPXhli.lA1N7XR.gOprVSiukW',0,'2022-04-26 20:02:45','thaipa',NULL,2);
INSERT INTO user VALUES (24,'Ha Long',NULL,'2022-04-26 20:03:23',_binary '\0',NULL,'hieupt@gmail.com','Phan Trong Hieu','$2a$10$TP2TAwTrlUUOIfIHxNBtSubSQr/Q3tnWxvV5SqSV810.GVRO/Z5Vy',0,'2022-04-26 20:03:23','hieupt',NULL,2);
INSERT INTO user VALUES (25,'Tuyen Quang',NULL,'2022-04-26 20:04:07',_binary '\0',NULL,'baorpg@gmail.com','Phan Gia Bao','$2a$10$rcAKY2iGVh.SFLzJShaTIeSCVvd1I3cb6SItWDEMmz9R9ZMMHTEH2',0,'2022-04-26 20:04:07','baopg',NULL,2);
INSERT INTO user VALUES (26,'An Giang',NULL,'2022-04-26 20:04:45',_binary '\0',NULL,'minhdn@gmail.com','Dinh Nhat Minh','$2a$10$g3DIWwXVBcX5dmcQjBiRy.3ZPA90/PH.OgqLVlsKUtjMn/kBA1VHK',0,'2022-04-26 20:04:45','minhdn',NULL,2);
INSERT INTO user VALUES (27,'Nghe An',NULL,'2022-04-26 20:06:01',_binary '\0',NULL,'hoangtc@gmail.com','Tieu Chi Hoang','$2a$10$OG97NeZ2ZpoRS.fr6HKer.9KHLlWIInFwJDj2V0oCf0lg4fIXuysq',0,'2022-04-26 20:06:01','hoangtc',NULL,2);

--
-- Dumping data for table `user_log`
--

INSERT INTO user_log VALUES (1,'2022-04-30 17:47:12',5);
INSERT INTO user_log VALUES (2,'2022-04-30 17:52:01',6);
INSERT INTO user_log VALUES (3,'2022-04-30 17:54:06',12);
INSERT INTO user_log VALUES (4,'2022-04-30 17:55:52',12);
INSERT INTO user_log VALUES (5,'2022-04-30 17:56:00',12);
INSERT INTO user_log VALUES (6,'2022-04-30 17:58:12',14);
INSERT INTO user_log VALUES (7,'2022-04-30 18:00:07',16);
INSERT INTO user_log VALUES (8,'2022-04-30 18:08:13',17);
INSERT INTO user_log VALUES (9,'2022-04-30 18:12:31',18);

--
-- Dumping data for table `voucher`
--

INSERT INTO voucher VALUES (1,'Sale 15% cap at $100!','11:55:00',100,'change Old to New',15,'11:55:00');
INSERT INTO voucher VALUES (2,'Sale 10% cap at $100!','11:55:00',100,'Summer',10,'11:55:00');
INSERT INTO voucher VALUES (3,'Sale 20% cap at $100!','11:55:00',100,'30/4 - 1/5',20,'11:55:00');
INSERT INTO voucher VALUES (4,'Sale 15% cap at $80!','11:55:00',80,'SaleMore',15,'11:55:00');
INSERT INTO voucher VALUES (5,'Sale 85% cap at $10!','11:55:00',10,'shock',85,'11:55:00');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed