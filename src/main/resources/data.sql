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

