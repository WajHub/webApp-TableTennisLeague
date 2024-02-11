INSERT INTO Hall (City, Postcode, Street, BuildingNumber, FanCapacity) VALUES
('Gdansk', '73-240', 'Kubacza', 21, 1000),
('Krakow', '30-001', 'Market Square', 5, 2000),
('Wroclaw', '50-001', 'Old Town', 15, 1800),
('Poznan', '60-001', 'Main Street', 20, 2200);

-- AWF (id=1)
INSERT INTO Team(NameT, YearOfFundation, Tables, Balls, LogoURL, IdHall, PeselCaptain) VALUES
    ('Balta AWFiS', 2015, 'Butterfly', 'Butterfly', 'https://s-trojmiasto.pl/zdj/c/n/3/3156/600x0/3156857.webp',1,NULL);

INSERT INTO Player(Pesel, NameP, Surname, DateOfBirth,Nationallity, Height,WeightP,Hand,Blade,ImgURL,IdTeam) VALUES
    ('12345678999','Hubert','Wajda', '2018-11-18','Poland', 175, 65, 'right', 'Timo Boll ZLC', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSNNb3ZktPA7kj7sZKpItq-ch-kjelgtCigpBq4GKwnXw&s',1);

INSERT INTO Player(Pesel, NameP, Surname, DateOfBirth,Nationallity, Height,WeightP,Hand,Blade,ImgURL,IdTeam) VALUES
    ('99999999999','Hubert2','Wajda2', '2015-11-10','Poland', 180, 65, 'left', 'Timo Boll ZLC', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSNNb3ZktPA7kj7sZKpItq-ch-kjelgtCigpBq4GKwnXw&s',1);

INSERT INTO Player(Pesel, NameP, Surname, DateOfBirth,Nationallity, Height,WeightP,Hand,Blade,ImgURL,IdTeam) VALUES
    ('88888888888','Hubert3','Wajda3', '2012-09-10','Poland', 180, 65, 'left', 'Timo Boll ZLC2', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSNNb3ZktPA7kj7sZKpItq-ch-kjelgtCigpBq4GKwnXw&s',1);

UPDATE Team SET PeselCaptain = '12345678999' WHERE (Id = 1);


-- Inserting Teams
INSERT INTO Team(NameT, YearOfFundation, Tables, Balls, LogoURL, IdHall, PeselCaptain) VALUES
     ('Golden Paddlers', 2008, 'DHS', 'DHS', 'https://example.com/golden_paddlers.jpg', 2, NULL),
     ('Silver Smashers', 2012, 'Donic', 'Donic', 'https://example.com/silver_smashers.jpg', 3, NULL),
     ('Bronze Ballers', 2016, 'Xiom', 'Xiom', 'https://example.com/bronze_ballers.jpg', 4, NULL);

-- Inserting Players
INSERT INTO Player(Pesel, NameP, Surname, DateOfBirth,Nationallity, Height,WeightP,Hand,Blade,ImgURL,IdTeam) VALUES
      ('11122233344', 'John', 'Doe', '1990-09-10', 'England', 180, 75, 'right', 'Tibhar', 'https://example.com/john.jpg', 2),
      ('55566677788', 'Anna', 'Smith', '1992-07-15', 'Germany', 170, 65, 'left', 'Andro', 'https://example.com/anna.jpg', 2),
      ('99988877766', 'Mike', 'Johnson', '1988-04-25', 'USA', 185, 80, 'right', 'Butterfly', 'https://example.com/mike.jpg', 2);

UPDATE Team SET PeselCaptain = '11122233344' WHERE (Id = 2);

-- Inserting Players
INSERT INTO Player(Pesel, NameP, Surname, DateOfBirth,Nationallity, Height,WeightP,Hand,Blade,ImgURL,IdTeam) VALUES
        ('44455566677', 'Emily', 'Brown', '1993-12-20', 'Canada', 175, 68, 'right', 'Stiga', 'https://example.com/emily.jpg', 3),
        ('77788899900', 'Sophia', 'Garcia', '1991-06-05', 'Spain', 178, 70, 'left', 'Donic', 'https://example.com/sophia.jpg', 3),
        ('33322211100', 'Max', 'Müller', '1994-03-15', 'Germany', 182, 77, 'right', 'Xiom', 'https://example.com/max.jpg', 3);

UPDATE Team SET PeselCaptain = '44455566677' WHERE (Id = 3);

-- Inserting Players
INSERT INTO Player(Pesel, NameP, Surname, DateOfBirth,Nationallity, Height,WeightP,Hand,Blade,ImgURL,IdTeam) VALUES
      ('66677788811', 'Emma', 'Johnson', '1995-08-25', 'USA', 170, 62, 'right', 'Butterfly', 'https://example.com/emma.jpg', 4),
      ('88899900022', 'Lukas', 'Kowalski', '1990-11-30', 'Poland', 185, 82, 'left', 'Tibhar', 'https://example.com/lukas.jpg', 4),
      ('22233344455', 'Sara', 'Andersson', '1993-02-10', 'Sweden', 168, 60, 'right', 'Stiga', 'https://example.com/sara.jpg', 4);

UPDATE Team SET PeselCaptain = '66677788811' WHERE (Id = 4);



-- Inserting Games
/*INSERT INTO Game (Round, DateOfMatch, NumberOfSupporters, ResultHome, ResultGuest, IdHome, IdGuest) VALUES
      (1, '2024-03-01', 800, 3, 1, 1, 2),
      (1, '2024-03-01', 900, 2, 3, 3, 2),
      (2, '2024-03-08', 1000, 3, 0, 1, 3),
      (2, '2024-03-08', 1200, 2, 3, 2, 3);

-- Inserting SinglesMatches
INSERT INTO SinglesMatch (ResultPlayerHome, ResultPlayerGuest, IdPlayerHome, IdPlayerGuest, IdGame) VALUES
      (11, 9, '12345678999', '55566677788', 1),
      (8, 11, '99988877766', '55566677788', 2),
      (11, 5, '12345678999', '99988877766', 3),
      (7, 11, '55566677788', '99988877766', 4);*/