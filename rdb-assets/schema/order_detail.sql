CREATE TABLE `#` (
  `id` varchar(50) COLLATE utf8_bin NOT NULL,
  `header_id` varchar(50) COLLATE utf8_bin DEFAULT '',
  `item_id` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
