CREATE TABLE Hall (
    Id INT AUTO_INCREMENT PRIMARY KEY,
    City VARCHAR(255) NOT NULL,
    Postcode VARCHAR (10) CHECK (Postcode REGEXP '^[0-9]{2}-[0-9]{3}$'),
    Street VARCHAR(255) NOT NULL,
    BuildingNumber INT CHECK(BuildingNumber>0) NOT NULL,
    FanCapacity INT NOT NULL
);

CREATE TABLE Team(
    Id INT AUTO_INCREMENT PRIMARY KEY,
    NameT VARCHAR (255) NOT NULL,
    YearOfFundation INT CHECK(YearOfFundation>0) NOT NULL,
    Tables VARCHAR(255),
    Balls VARCHAR(255),
    LogoURL VARCHAR (511) NOT NULL,
    IdHall INT,
    FOREIGN KEY (IdHall) REFERENCES Hall (Id),
    IdCaptain INT
);


CREATE TABLE Player (
    Id INT AUTO_INCREMENT PRIMARY KEY,
    Pesel VARCHAR(11) CHECK (Pesel REGEXP '^[0-9]{11}'),
    NameP VARCHAR (255) NOT NULL,
    Surname VARCHAR (255) NOT NULL,
    DateOfBirth DATE NOT NULL,
    Nationality VARCHAR (255) NOT NULL,
    Height INT CHECK(Height>0),
    WeightP INT CHECK(WeightP>0),
    Hand VARCHAR (5),
    Blade VARCHAR (255),
    ImgURL VARCHAR(511) NOT NULL,
    IdTeam INT,
    FOREIGN KEY (IdTeam) REFERENCES Team (Id)
);

ALTER TABLE Team
    ADD FOREIGN KEY (IdCaptain) REFERENCES Player(Id);

CREATE TABLE Game (
    Id INT AUTO_INCREMENT PRIMARY KEY,
    Round INT NOT NULL,
    DateOfMatch DATE NOT NULL,
    NumberOfSupporters INT,
    ResultHome INT,
    ResultGuest INT,
    IdHome INT NOT NULL,
    FOREIGN KEY (IdHome) REFERENCES Team (Id),
    IdGuest INT NOT NULL,
    FOREIGN KEY (IdGuest) REFERENCES Team (Id)
);


CREATE TABLE SinglesMatch (
    Id INT AUTO_INCREMENT PRIMARY KEY ,
    ResultPlayerHome INT,
    ResultPlayerGuest INT,
    IdPlayerHome INT NOT NULL,
    FOREIGN KEY (IdPlayerHome) REFERENCES Player(Id),
    IdPlayerGuest INT NOT NULL ,
    FOREIGN KEY (IdPlayerGuest) REFERENCES Player(Id),
    IdGame INT NOT NULL,
    FOREIGN KEY (IdGame) REFERENCES Game (Id)
);
