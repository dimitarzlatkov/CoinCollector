/*
* A file inserting Estonia coins into coins table.
*/

INSERT INTO coins (country_code,facial_value,value,image,description,shape,weight,diameter,thickness,commemorative,currency_type)
 SELECT * FROM ( SELECT 'EE','1','0.01','ee_1_cent',null,'round',2.3,16.25,1.67,'false','Cent'
        UNION ALL SELECT 'EE','2','0.02','ee_2_cent',null,'round',3.06,18.75,1.67,'false','Cent'
        UNION ALL SELECT 'EE','5','0.05','ee_5_cent',null,'round',3.92,21.25,1.67,'false','Cent'
        UNION ALL SELECT 'EE','10','0.10','ee_10_cent',null,'round',4.1,19.75,1.93,'false','Cent'
        UNION ALL SELECT 'EE','20','0.20','ee_20_cent',null,'round',5.74,22.25,2.14,'false','Cent'
        UNION ALL SELECT 'EE','50','0.50','ee_50_cent',null,'round',7.8,24.25,2.38,'false','Cent'
        UNION ALL SELECT 'EE','1','1.00','ee_1_euro',null,'round',7.5,23.25,2.33,'false','Euro'
        UNION ALL SELECT 'EE','2','2.00','ee_2_euro',null,'round',8.5,25.75,2.2,'false','Euro'
);