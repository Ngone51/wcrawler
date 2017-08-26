CREATE DATABASE `summer` /*!40100 DEFAULT CHARACTER SET utf8 */;

CREATE TABLE `crawler_url` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `url` varchar(45) NOT NULL,
  `parent` int(11) DEFAULT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `url_UNIQUE` (`url`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

CREATE TABLE `proxy` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ip` varchar(20) NOT NULL,
  `port` varchar(10) NOT NULL,
  `quality` double DEFAULT NULL,
  `successTimes` int(11) DEFAULT NULL,
  `failureTimes` int(11) DEFAULT NULL,
  `lastSuccessTimeStamp` bigint(20) DEFAULT NULL,
  `lastSuccessTimeConsume` bigint(20) DEFAULT NULL,
  `avgSuccessTimeConsume` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;