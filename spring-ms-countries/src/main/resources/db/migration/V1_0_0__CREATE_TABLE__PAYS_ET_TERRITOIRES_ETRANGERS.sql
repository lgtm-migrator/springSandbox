CREATE TABLE pays
(
   cog varchar(5), 
   actual varchar(1), 
   capay varchar(5), 
   crpay varchar(5), 
   ani varchar(4), 
   libcog varchar(70),
   libenr varchar(70),
   ancnom varchar(30),
   codeiso2 varchar(2),
   codeiso3 varchar(3),
   codenum3 varchar(3),
   CONSTRAINT pk_pays PRIMARY KEY (libcog)
);