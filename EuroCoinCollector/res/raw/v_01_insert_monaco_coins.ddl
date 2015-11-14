/*
* A file inserting Monaco coins into coins table.
*/

INSERT INTO coins (country_code,facial_value,value,image,description,shape,weight,diameter,thickness,commemorative,currency_type)
 SELECT * FROM ( SELECT 'MC','1','0.01','mc_1_cent',null,'round',2.3,16.25,1.67,'false','Cent'
        UNION ALL SELECT 'MC','2','0.02','mc_2_cent',null,'round',3.06,18.75,1.67,'false','Cent'
        UNION ALL SELECT 'MC','5','0.05','mc_5_cent',null,'round',3.92,21.25,1.67,'false','Cent'
        UNION ALL SELECT 'MC','10','0.10','mc_10_cent',null,'round',4.1,19.75,1.93,'false','Cent'
        UNION ALL SELECT 'MC','20','0.20','mc_20_cent',null,'round',5.74,22.25,2.14,'false','Cent'
        UNION ALL SELECT 'MC','50','0.50','mc_50_cent',null,'round',7.8,24.25,2.38,'false','Cent'
        UNION ALL SELECT 'MC','1','1.00','mc_1_euro',null,'round',7.5,23.25,2.33,'false','Euro'
        UNION ALL SELECT 'MC','2','2.00','mc_2_euro',null,'round',8.5,25.75,2.2,'false','Euro'
);