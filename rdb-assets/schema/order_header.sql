CREATE TABLE `#` (
  `id` varchar(50) COLLATE utf8_bin NOT NULL,
  `profile_id` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `datetime` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

