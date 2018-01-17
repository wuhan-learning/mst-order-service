CREATE TABLE `t_shopping_cart_item` (
  `id`         BIGINT(20)   NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `user_name`  VARCHAR(255) NOT NULL,
  `goods_id`   BIGINT(20)   NOT NULL,
  `quantity`   BIGINT(20)   NOT NULL,
  `created_date` BIGINT(20)   NOT NULL,
  `updated_date` BIGINT(20)
);