CREATE TABLE player
(
   firstname varchar(25), 
   lastname varchar(25), 
   country varchar(3),
   gender varchar(1),
   CONSTRAINT pk_player PRIMARY KEY (firstname, lastname)
);