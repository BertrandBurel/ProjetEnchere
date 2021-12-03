USE ENCHERES_GRP3_BDD;
GO


-- Script de nettoyage de la base de données ENCHERES
--   type :      SQL Server 2012
--

DROP TABLE ENCHERES;
DROP TABLE RETRAITS;
DROP TABLE ARTICLES_VENDUS;
DROP TABLE CATEGORIES;
DROP TABLE UTILISATEURS;

GO


-- Script de création de la base de données ENCHERES
--   type :      SQL Server 2012
--

CREATE TABLE CATEGORIES (
    no_categorie   INTEGER IDENTITY(1,1) NOT NULL,
    libelle        VARCHAR(30) NOT NULL
)

ALTER TABLE CATEGORIES ADD constraint categorie_pk PRIMARY KEY (no_categorie)

CREATE TABLE ENCHERES (
    no_utilisateur   INTEGER NOT NULL,
    no_article       INTEGER NOT NULL,
    date_enchere     datetime NOT NULL,
	montant_enchere  INTEGER NOT NULL

)

ALTER TABLE ENCHERES ADD constraint enchere_pk PRIMARY KEY (no_utilisateur, no_article, date_enchere)  /*ajout de la date à la clé primaire pour permettre plusieurs enchères par une même personne*/

CREATE TABLE RETRAITS (
	no_article         INTEGER NOT NULL,
    rue              VARCHAR(30) NOT NULL,
    code_postal      VARCHAR(5) NOT NULL, /*Code postal sur 15 char remis à 5*/
    ville            VARCHAR(30) NOT NULL
)

ALTER TABLE RETRAITS ADD constraint retrait_pk PRIMARY KEY  (no_article)

CREATE TABLE UTILISATEURS (
    no_utilisateur   INTEGER IDENTITY(1,1) NOT NULL,
    pseudo           VARCHAR(30) NOT NULL UNIQUE, /*changement, pseudo unique*/
    nom              VARCHAR(30) NOT NULL,
    prenom           VARCHAR(30) NOT NULL,
    email            VARCHAR(20) NOT NULL UNIQUE, /*changement, mail unique*/
    telephone        VARCHAR(15),
    rue              VARCHAR(30) NOT NULL,
    code_postal      VARCHAR(5) NOT NULL,  /*code postal à 5 chiffres et non 10*/
    ville            VARCHAR(30) NOT NULL,
    mot_de_passe     VARCHAR(30) NOT NULL,
    credit           INTEGER NOT NULL,
    administrateur   bit NOT NULL
)

ALTER TABLE UTILISATEURS ADD constraint utilisateur_pk PRIMARY KEY (no_utilisateur)


CREATE TABLE ARTICLES_VENDUS (
    no_article                    INTEGER IDENTITY(1,1) NOT NULL,
    nom_article                   VARCHAR(30) NOT NULL,
    description                   VARCHAR(300) NOT NULL,
	date_debut_encheres           DATE NOT NULL,
    date_fin_encheres             DATE NOT NULL,
    prix_initial                  INTEGER NOT NULL, /*changement, prix initial renseign� � la cr�taion de l'article*/
    prix_vente                    INTEGER,
    no_utilisateur                INTEGER NOT NULL,
    no_categorie                  INTEGER NOT NULL
)

ALTER TABLE ARTICLES_VENDUS ADD constraint articles_vendus_pk PRIMARY KEY (no_article)

ALTER TABLE ENCHERES /*changement de table point�e, c'est la cl�e des ench�res, pas celle des ventes*/
    ADD CONSTRAINT encheres_utilisateur_fk FOREIGN KEY ( no_utilisateur ) REFERENCES UTILISATEURS ( no_utilisateur )
ON DELETE CASCADE /*changement, passage en cascade pour respect de la volont�e client sur la partie administration des comptes*/
    ON UPDATE no action 

ALTER TABLE ENCHERES
    ADD CONSTRAINT encheres_articles_vendus_fk FOREIGN KEY ( no_article )
        REFERENCES ARTICLES_VENDUS ( no_article )
ON DELETE NO ACTION 
    ON UPDATE no action 

ALTER TABLE RETRAITS
    ADD CONSTRAINT retraits_articles_vendus_fk FOREIGN KEY ( no_article )
        REFERENCES ARTICLES_VENDUS ( no_article )
ON DELETE NO ACTION 
    ON UPDATE no action 

ALTER TABLE ARTICLES_VENDUS
    ADD CONSTRAINT articles_vendus_categories_fk FOREIGN KEY ( no_categorie )
        REFERENCES categories ( no_categorie )
ON DELETE NO ACTION 
    ON UPDATE no action 

ALTER TABLE ARTICLES_VENDUS
    ADD CONSTRAINT articles_vendus_utilisateur_fk FOREIGN KEY ( no_utilisateur ) /*changement nom de cl�, pour plus de clart�*/
        REFERENCES utilisateurs ( no_utilisateur )
ON DELETE CASCADE /*changement, passage en cascade pour respect de la volont�e client sur la partie administration des comptes*/
    ON UPDATE no action 

GO

-- Script de création de jeu de test
--				SQL Server 12C
--

--
-- USER
--

INSERT INTO UTILISATEURS (nom, prenom, pseudo, email, telephone, rue
      , code_postal, ville, mot_de_passe, credit, administrateur)
	VALUES ('LESTEVEN', 'Erik', 'VikingBreton', 'jaime@bretagne.fr', '0213465789', '11 rue du petit drakkar',
			'49000', 'ANGERS', 'Odin', 1200, 1),
		   ('BUREL', 'Bertrand', 'PetitBouchon', 'java@javapas.fr', '0215487369', '5 rue du coude levé',
			'49000', 'ANGERS', 'Riesling', 1000, 1),
		   ('DUCASSE', 'Alain', 'PigeonRacan', 'trois@etoiles.fr', '0295487613', '1 rue du marmiton',
			'44000', 'NANTES', 'Orthez3*', 400, 0),
		   ('HADDOCK', 'Archibald', 'MilleSabords', 'moule@agauffres.fr', '0232459825', '32 rue du mousaillon',
			'44600', 'SAINT-NAZAIRE', 'Corsaire', 100, 0),
		   ('MILOU', 'Tintin', 'Tintin49', 'crabe@pincesor.fr', '0298877665', '17 rue de l''enquête',
			'49300', 'CHOLET', 'Milou', 50, 0),
		   ('SCHTROUMF', 'Grand', 'RougeBarbe', 'village@cache.fr', '0266611999', 'Lac de Grand-Lieu',
			'44860', 'SAINT-AIGNAN-GRANDLIEU', 'schtroumfette', 620, 0);
			
--
-- CATEGORY
--

INSERT INTO CATEGORIES (libelle)
	VALUES ('Informatique'),
		('Ameublement'),
		('Vêtement'),
		('Sport&Loisir');
		
		
--
-- SOLD_ARTICLE
--
		
INSERT INTO ARTICLES_VENDUS
           (nom_article, description, 
		   date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie)
     VALUES
           ('Trotinette', 'Moteur éléctrique avec chargeur 220V. Modèle enfant, peu servi. Enbouts plastiques du guidon abimés.', 
		   '2021-11-24', '2021-12-30', 20, null, 3, 4),
		   ('IPad 24', 'Super révolutionnaire! Ecran 58 pouces, peut être porté en écharpe de Hipster! Batterie morte et soudée à l''appareil, mais rien qu''un AppStore ne puisse réparer moyennent votre âme!', 
		   '2021-09-22', '2021-10-30', 8000, 9785, 2, 1),
		   ('Sofa J&M', 'Sofa confortable, revetement cuir. Troqué avec ses coussins et un petit tapis de sol en coton. Option clic-clac. Etat usagé, quelques traces sur le cuir de l''assise', 
		   '2021-12-15', '2021-12-24', 150, null, 1, 2),
		   ('PC GAMERZZZ DX MAX', 'PC gaming pour les vrais! Avec des vrais petits bouts de Call Of et de LoL dedans. Système anti-humidité au sel, reproidissement à l''azote gazeux!', 
		   '2021-11-10', '2021-11-14', 100, 250, 6, 1),
		   ('Altères, jeu de poids 1/15kg', 'Mes vieilles altères. Très polivalentes, pour commencer la muscu ou pour le perfectionnement. Mon médecin m''a interdit le sport car c''est dangereux pour la santé!', 
		   '2021-11-25', '2021-12-25', 50, null, 4, 4),
		   ('Matelas de sport Pourdormire', 'Matelas 220x140, propre. Idéal pour les push-up et les ron-pich!', 
		   '2021-10-30', '2021-11-24', 15, 48, 5, 4),
		   ('Star Craft Troie', 'Jeux de gestion de magasin à l''époque de la guerre de Troie. Le but est de confectionner des épées de papier pour équiper son armée de chanteurs des Enfoirés', 
		   '2021-10-24', '2021-12-30', 40, null, 2, 1)
		   
--
-- AUCTION
--
		   
INSERT INTO ENCHERES
           (no_utilisateur, no_article, date_enchere, montant_enchere)
     VALUES
           (6, 6, convert(datetime,'20211110 03:00:00 PM'), 39),
           (1, 6, convert(datetime,'20211113 06:00:00 AM'), 48),
           (2, 4, convert(datetime,'20211111 03:00:00 AM'), 250),
           (6, 1, convert(datetime,'20211125 07:00:00 PM'), 30),
           (4, 2, convert(datetime,'20211001 09:00:00 PM'), 8700),
           (5, 2, convert(datetime,'20211022 01:00:00 PM'), 9750),
           (6, 2, convert(datetime,'20211029 09:00:00 AM'), 9785),
           (3, 7, convert(datetime,'20211029 10:00:00 AM'), 50),
           (4, 7, convert(datetime,'20211112 06:00:00 PM'), 55)	
           
--
-- WITHDRAWAL
--
           
INSERT INTO RETRAITS
           (no_article, rue, code_postal, ville)
     VALUES
           (3, '11 rue du petit drakkar', '49000', 'ANGERS'),
           (1, '1 rue du marmiton', '44000', 'NANTES'),
           (2, '5 rue du coude levé', '49000', 'ANGERS'),
           (4, 'Lac de Grand-Lieu', '44860', 'SAINT-AIGNAN-GRANDLIEU'),
           (5, '32 rue du mousaillon', '44600', 'SAINT-NAZAIRE'),
           (6, '17 rue de l''enquête', '49300', 'CHOLET'),
           (7, '2 rue du troupomet', '01085', 'VILLE L''AIN')
           
GO
