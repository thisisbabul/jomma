/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 8.0.33-0ubuntu0.22.04.2 : Database - jomma
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`jomma` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `jomma`;

/*Table structure for table `products` */

DROP TABLE IF EXISTS `products`;

CREATE TABLE `products` (
  `product_id` bigint NOT NULL AUTO_INCREMENT,
  `product_name` varchar(200) DEFAULT NULL,
  `product_code` varchar(50) DEFAULT NULL,
  `unit_price` double DEFAULT NULL,
  `gain_loss` double DEFAULT NULL,
  `year_to_date` double DEFAULT NULL,
  `active_status` tinyint DEFAULT '1',
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `products` */

insert  into `products`(`product_id`,`product_name`,`product_code`,`unit_price`,`gain_loss`,`year_to_date`,`active_status`) values (1,'ROBI AXIATA LIMITED','ROBI',100,5,2,1),(2,'GRAMEEN PHONE','GP',120,-10,10,1),(3,'SQUARE PHARMACEUTICALS','SQUAREPHRM',200,20,15.2,0);

/*Table structure for table `transactions` */

DROP TABLE IF EXISTS `transactions`;

CREATE TABLE `transactions` (
  `transaction_id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint DEFAULT NULL,
  `product_id` bigint DEFAULT NULL,
  `order_amount` double DEFAULT NULL,
  `created_on` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`transaction_id`),
  KEY `PRODUCT_R01` (`product_id`),
  CONSTRAINT `PRODUCT_R01` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `transactions` */

insert  into `transactions`(`transaction_id`,`user_id`,`product_id`,`order_amount`,`created_on`) values (1,1,1,100,'2023-06-10 08:03:00.944241'),(2,1,2,120,'2023-06-10 08:03:00.944270'),(3,1,2,120,'2023-06-10 08:09:20.309289'),(4,1,2,120,'2023-06-10 08:09:24.669259'),(5,1,2,120,'2023-06-10 08:09:25.972301'),(6,1,2,120,'2023-06-10 08:09:26.928863'),(7,1,2,120,'2023-06-10 08:09:27.752363'),(8,1,2,120,'2023-06-10 08:09:28.544212'),(9,1,2,120,'2023-06-10 08:09:29.309498'),(10,1,2,120,'2023-06-10 08:09:30.211975'),(11,1,2,120,'2023-06-10 08:10:50.566592'),(12,1,2,120,'2023-06-10 08:10:52.811892'),(13,1,2,120,'2023-06-10 08:11:32.181011'),(14,1,2,120,'2023-06-10 08:11:35.994960'),(15,1,2,120,'2023-06-10 08:11:36.929888'),(16,1,2,120,'2023-06-10 08:11:39.107312'),(17,1,2,120,'2023-06-10 08:11:40.088632');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
