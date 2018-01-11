CREATE TABLE `t_order` (
  `id`           BIGINT(20)   NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `number`       VARCHAR(255) NOT NULL,
  `created_date` BIGINT(20)   NOT NULL,
  `updated_date` BIGINT(20) DEFAULT NULL,
  `total_price`  DOUBLE     DEFAULT 0
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;