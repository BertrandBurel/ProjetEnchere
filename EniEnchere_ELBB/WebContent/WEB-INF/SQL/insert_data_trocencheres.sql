-- Script de création de jeu de test
--				SQL Server 12C
--

USE ENCHERES_GRP3_BDD;
GO

--
-- USER
--

INSERT INTO UTILISATEURS
	VALUES (1 , "LESTEVEN", "Erik", "VikingBreton", "jaime@bretagne.fr", "0213465789", "11 rue du petit drakkar",
			"49000", "ANGERS", "Odin", "1200", "1");
INSERT INTO UTILISATEURS
	VALUES (2 , "BUREL", "Bertrand", "PetitBouchon", "java@javapas.fr", "0215487369", "5 rue du coude levé",
			"49000", "ANGERS", "Riesling", "1000", "1");
INSERT INTO UTILISATEURS
	VALUES (3 , "DUCASSE", "Alain", "PigeonRacan", "trois@etoiles.fr", "0295487613", "1 rue du marmiton",
			"44000", "NANTES", "Orthez3*", "400", "0");
INSERT INTO UTILISATEURS
	VALUES (4 , "HADDOCK", "Archibald", "MilleSabords", "moule@agauffres.fr", "0232459825", "32 rue du mousaillon",
			"44600", "SAINT-NAZAIRE", "Corsaire", "100", "0");
INSERT INTO UTILISATEURS
	VALUES (5 , "MILOU", "Tintin", "Tintin49", "crabe@pincesor.fr", "0298877665", "17 rue de l'enquête",
			"49300", "CHOLET", "Milou", "50", "0");
INSERT INTO UTILISATEURS
	VALUES (6 , "SCHTROUMF", "Grand", "RougeBarbe", "village@cache.fr", "0266611999", "Lac de Grand-Lieu",
			"44860", "SAINT-AIGNAN-GRANDLIEU", "schtroumfette", "620", "0");