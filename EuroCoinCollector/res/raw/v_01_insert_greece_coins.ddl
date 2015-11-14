/*
* A file inserting Greece coins into coins table.
*/

INSERT INTO coins (country_code,facial_value,value,image,description,shape,weight,diameter,thickness,commemorative,currency_type)
 SELECT * FROM ( SELECT 'GR','1','0.01','gr_1_cent',null,'round',2.3,16.25,1.67,'false','Cent'
        UNION ALL SELECT 'GR','2','0.02','gr_2_cent',null,'round',3.06,18.75,1.67,'false','Cent'
        UNION ALL SELECT 'GR','5','0.05','gr_5_cent',null,'round',3.92,21.25,1.67,'false','Cent'
        UNION ALL SELECT 'GR','10','0.10','gr_10_cent',null,'round',4.1,19.75,1.93,'false','Cent'
        UNION ALL SELECT 'GR','20','0.20','gr_20_cent',null,'round',5.74,22.25,2.14,'false','Cent'
        UNION ALL SELECT 'GR','50','0.50','gr_50_cent',null,'round',7.8,24.25,2.38,'false','Cent'
        UNION ALL SELECT 'GR','1','1.00','gr_1_euro',null,'round',7.5,23.25,2.33,'false','Euro'
        UNION ALL SELECT 'GR','2','2.00','gr_2_euro',null,'round',8.5,25.75,2.2,'false','Euro'
);