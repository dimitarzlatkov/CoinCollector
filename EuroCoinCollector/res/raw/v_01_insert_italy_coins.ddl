/*
* A file inserting Italy coins into coins table.
*/

INSERT INTO coins (country_code,facial_value,value,image,description,shape,weight,diameter,thickness,commemorative,currency_type)
 SELECT * FROM ( SELECT 'IT','1','0.01','it_1_cent',null,'round',2.3,16.25,1.67,'false','Cent'
        UNION ALL SELECT 'IT','2','0.02','it_2_cent',null,'round',3.06,18.75,1.67,'false','Cent'
        UNION ALL SELECT 'IT','5','0.05','it_5_cent',null,'round',3.92,21.25,1.67,'false','Cent'
        UNION ALL SELECT 'IT','10','0.10','it_10_cent',null,'round',4.1,19.75,1.93,'false','Cent'
        UNION ALL SELECT 'IT','20','0.20','it_20_cent',null,'round',5.74,22.25,2.14,'false','Cent'
        UNION ALL SELECT 'IT','50','0.50','it_50_cent',null,'round',7.8,24.25,2.38,'false','Cent'
        UNION ALL SELECT 'IT','1','1.00','it_1_euro',null,'round',7.5,23.25,2.33,'false','Euro'
        UNION ALL SELECT 'IT','2','2.00','it_2_euro',null,'round',8.5,25.75,2.2,'false','Euro'
);