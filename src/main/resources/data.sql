INSERT INTO aventurero (NOMBRE_AVENTURERO) VALUES ('Euris');

insert into arma (NOMBRE_ARMA, DANYO, aventurero) values ('Chumchummaru', 'cortante',(select ID_ADV from aventurero where NOMBRE_AVENTURERO = 'Euris'));