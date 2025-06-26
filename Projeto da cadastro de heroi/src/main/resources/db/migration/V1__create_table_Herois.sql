CREATE TABLE IF NOT EXISTS `herois` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(120) NOT NULL,
  `nome_do_heroi` VARCHAR(120) NOT NULL,
  `data_de_nascimento` DATETIME,
  `altura` float,
  `peso` float,
  PRIMARY KEY (`id`)
) 