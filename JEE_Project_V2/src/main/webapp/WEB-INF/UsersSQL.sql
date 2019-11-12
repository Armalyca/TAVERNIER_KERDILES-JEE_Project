/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  emili
 * Created: 2 nov. 2019
 */

/*On supprime les tables si elles existent */
DROP TABLE IF EXISTS credentials;

/*Création de la table credentials*/
CREATE TABLE credentials (
	id INTEGER NOT NULL AUTO_INCREMENT,
	login VARCHAR(8) NOT NULL,
	pwd VARCHAR(8) NOT NULL,
	CONSTRAINT primary_key_membre PRIMARY KEY (ID)
);

/*Insertion de 4 membres*/
INSERT INTO credentials (login, pwd) VALUES
('admin','admin'),
('empl','empl');