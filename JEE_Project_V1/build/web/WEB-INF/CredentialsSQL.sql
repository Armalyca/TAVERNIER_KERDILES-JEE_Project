/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Mathilde Kerdiles et Emilie Tavernier
 * Created: 25 oct. 2019
 */

/*On supprime les tables si elles existent */
DROP TABLE CREDENTIALS;

/*Création de la table EMPLOYEES*/
CREATE TABLE "CREDENTIALS" (
	"LOGIN" VARCHAR(8) NOT NULL,
	"PWD" VARCHAR(8) NOT NULL
);

/*Insertion de 4 membres*/
INSERT INTO CREDENTIALS(LOGIN,PWD) VALUES
('admin','admin'),
('empl','empl');