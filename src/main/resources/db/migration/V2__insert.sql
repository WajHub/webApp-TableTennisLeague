INSERT INTO Hall (City, Postcode, Street, BuildingNumber, FanCapacity) VALUES
('Gdansk', '73-240', 'Kubacza', 21, 1000);

INSERT INTO Team(NameT, YearOfFundation, Tables, Balls, LogoURL, IdHall, PeselCaptain) VALUES
    ('Balta AWFiS', 2015, 'Butterfly', 'Butterfly', 'https://s-trojmiasto.pl/zdj/c/n/3/3156/600x0/3156857.webp',1,NULL);

INSERT INTO Player(Pesel, NameP, Surname, DateOfBirth,Nationallity, Height,WeightP,Hand,Blade,ImgURL,IdTeam) VALUES
    ('12345678999','Hubert','Wajda', '2018-11-18','Poland', 175, 65, 'prawa', 'Timo Boll ZLC', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSNNb3ZktPA7kj7sZKpItq-ch-kjelgtCigpBq4GKwnXw&s',1);

UPDATE Team SET PeselCaptain = '12345678999' WHERE (Id = 1);