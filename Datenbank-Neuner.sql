create table Artikel (
	ID INT not null,
	Artikelname VARCHAR(255) not null,
	Preis double precision not null,
	primary key (ID)
);

create table Kunde (
	ID INT not null,
	TitelV VARCHAR(255),
	Vorname VARCHAR(255) not null,
	Nachname VARCHAR(255) not null,
	TitelN VARCHAR(255),
	primary key (ID)
);

create table Bestellung_v3 (
	ID INT not null,
	Kunde_ID INT references Kunde(ID)  not null,
	Adresse_Rechnung_ID INT not null,
	Adresse_Liefer_ID INT references Adresse(ID)  not null,
	primary key (ID)
);	

create table Bestellung_Artikel (
	Bestell_ID INT references bestellung_v3(ID) not null,
	Artikel_ID INT references artikel(ID) not null,
	Menge INT,
	primary key (Bestell_ID, Artikel_ID)
);

create table Adresse (
	ID INT not null,
	Stadt VARCHAR(255) not null,
	Strasse VARCHAR(255) not null,
	PLZ INT not null,
	Hnr VARCHAR(255) not null,
	primary key (ID)
);


