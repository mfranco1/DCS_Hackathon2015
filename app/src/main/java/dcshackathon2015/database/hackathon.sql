BEGIN TRANSACTION;
CREATE TABLE "Trip" (
	`Trip_id`	INTEGER NOT NULL UNIQUE,
	`Trip_name`	TEXT NOT NULL,
	`Terminal_Terminal_id`	INTEGER NOT NULL,
	`Trip_availability`	INTEGER NOT NULL,
	PRIMARY KEY(Trip_id),
	FOREIGN KEY(`Terminal_Terminal_id`) REFERENCES Terminal ( Terminal_id )
);
INSERT INTO `Trip` VALUES (1,'UP Diliman',1,'5 AM - 10PM');
INSERT INTO `Trip` VALUES (2,'UP Diliman',2,'5AM - 11PM');
INSERT INTO `Trip` VALUES (3,'UP Diliman',3,'6AM - 12PM');
INSERT INTO `Trip` VALUES (4,'UP Diliman',4,'5AM - 9PM');
INSERT INTO `Trip` VALUES (5,'Monumento',1,'24-hours');
INSERT INTO `Trip` VALUES (6,'SM North',7,'24-Hours');
CREATE TABLE `Terminal` (
	`Terminal_id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
	`Terminal_place`	TEXT NOT NULL
);
INSERT INTO `Terminal` VALUES (1,'SM North');
INSERT INTO `Terminal` VALUES (2,'Katipunan');
INSERT INTO `Terminal` VALUES (3,'Philcoa');
INSERT INTO `Terminal` VALUES (4,'MRT');
INSERT INTO `Terminal` VALUES (5,'Cubao');
INSERT INTO `Terminal` VALUES (6,'Monumento');
INSERT INTO `Terminal` VALUES (7,'UP Diliman');
COMMIT;
