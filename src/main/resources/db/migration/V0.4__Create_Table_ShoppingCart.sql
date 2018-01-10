CREATE TABLE `t_shopping_cart_item` (
  `id`  BIGINT  NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `user_id` VARCHAR(255) NOT NULL,
  `goods_id`  BIGINT NOT NULL
);