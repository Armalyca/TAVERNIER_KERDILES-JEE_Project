/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  emili
 * Created: 25 oct. 2019
 */

/*On supprime les tables si elles existent */
DROP TABLE IF EXISTS EMPLOYEES;

/*Création de la table EMPLOYEES*/
CREATE TABLE EMPLOYEES (
	ID INTEGER NOT NULL AUTO_INCREMENT,
	NAME VARCHAR(25) NOT NULL,
	FIRSTNAME VARCHAR(25) NOT NULL,
	TELHOME VARCHAR(10) NOT NULL,
        TELMOB VARCHAR(10) NOT NULL,
	TELPRO VARCHAR(10) NOT NULL,
	ADRESS VARCHAR(150) NOT NULL,
	POSTALCODE VARCHAR(5) NOT NULL,
	CITY VARCHAR(25) NOT NULL,
	EMAIL VARCHAR(64) NOT NULL,
	CONSTRAINT primary_key_membre PRIMARY KEY (ID)
);

/*Insertion de 4 membres*/
INSERT INTO EMPLOYEES(NAME,FIRSTNAME,TELHOME,TELMOB,TELPRO,ADRESS,POSTALCODE,CITY,EMAIL) VALUES
('Simpson','Homer','0123456789','0612345678','0698765432','2 avenue Duff','92700','Colombes','hsimpson@gmail.com'),
('Simpson','Bart','0145362787','0645362718','0611563477','10 rue des Rebelles','92270','Bois-colombes','bsimpson@gmail.com'),
('Lagaffe','Gaston','0187665987','0623334256','0654778654','65 rue de la Paresse','92700','Colombes','glagaffe@yahoo.fr'),
('Mafalda','Querida','0187611987','0783334256','0658878654','6 rue de Buenos Aires','75016','Paris','qmafalda@hotmail.ar'),
('Woodpecker','Woody','0187384987','0622494256','0674178654','5 bvd des Picoreurs','21000','Dijon','woody@mail.co.uk'),
('Brown','Charlie','0122456678','0699854673','0623445166','140 avenue Foche','90000','Nanterre','cbrown@live.com');