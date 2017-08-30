CREATE SCHEMA `frituurfrida` IF NOT EXISTS ;

CREATE USER cursist IDENTIFIED BY 'cursist';
GRANT ALL ON frituurfrida.* TO cursist;

CREATE TABLE `frituurfrida`.`sauzen` IF NOT EXISTS (
  `id` INT(10) NOT NULL AUTO_INCREMENT,
  `naam` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `idsauzen_UNIQUE` (`id` ASC));

CREATE TABLE `frituurfrida`.`sauzeningredienten` IF NOT EXISTS (
  `sausid` INT(10) NOT NULL,
  `ingredientenid` INT(10) NOT NULL);

CREATE TABLE `frituurfrida`.`ingredienten` IF NOT EXISTS (
  `id` INT(10) NOT NULL AUTO_INCREMENT,
  `naam` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`));

INSERT INTO sauzen (naam) VALUES ("Cocktail");
INSERT INTO sauzen (naam) VALUES ("Mayonaise");
INSERT INTO sauzen (naam) VALUES ("Mosterd");
INSERT INTO sauzen (naam) VALUES ("Tartare");
INSERT INTO sauzen (naam) VALUES ("Vinaigrette");

INSERT INTO ingredienten (naam) VALUES ("Mayonaise");
INSERT INTO ingredienten (naam) VALUES ("Cognac");
INSERT INTO ingredienten (naam) VALUES ("Ketchup");
INSERT INTO ingredienten (naam) VALUES ("Ei");
INSERT INTO ingredienten (naam) VALUES ("Mosterd");
INSERT INTO ingredienten (naam) VALUES ("Olie");
INSERT INTO ingredienten (naam) VALUES ("Azijn");
INSERT INTO ingredienten (naam) VALUES ("Witte wijn");
INSERT INTO ingredienten (naam) VALUES ("Agurk");
INSERT INTO ingredienten (naam) VALUES ("Tabasco");
INSERT INTO ingredienten (naam) VALUES ("Olijfolie");

INSERT INTO sauzeningredienten (sausid,ingredientenid) VALUES (1,1);
INSERT INTO sauzeningredienten (sausid,ingredientenid) VALUES (1,2);
INSERT INTO sauzeningredienten (sausid,ingredientenid) VALUES (1,3);
INSERT INTO sauzeningredienten (sausid,ingredientenid) VALUES (2,4);
INSERT INTO sauzeningredienten (sausid,ingredientenid) VALUES (2,5);
INSERT INTO sauzeningredienten (sausid,ingredientenid) VALUES (2,6);
INSERT INTO sauzeningredienten (sausid,ingredientenid) VALUES (3,7);
INSERT INTO sauzeningredienten (sausid,ingredientenid) VALUES (3,5);
INSERT INTO sauzeningredienten (sausid,ingredientenid) VALUES (3,8);
INSERT INTO sauzeningredienten (sausid,ingredientenid) VALUES (4,1);
INSERT INTO sauzeningredienten (sausid,ingredientenid) VALUES (4,9);
INSERT INTO sauzeningredienten (sausid,ingredientenid) VALUES (4,10);
INSERT INTO sauzeningredienten (sausid,ingredientenid) VALUES (5,7);
INSERT INTO sauzeningredienten (sausid,ingredientenid) VALUES (5,5);
INSERT INTO sauzeningredienten (sausid,ingredientenid) VALUES (5,11);