/*
* A file inserting Germany coins into coins table.
*/

INSERT INTO coins (country_code,facial_value,value,image,description,shape,weight,diameter,thickness,commemorative,currency_type)
 SELECT * FROM ( SELECT 'DE','1','0.01','de_1_cent',null,round,2.3,16.25,1.67,'false','Cent'
        UNION ALL SELECT 'DE','2','0.02','de_2_cent',null,round,3.06,18.75,1.67,'false','Cent'
        UNION ALL SELECT 'DE','5','0.05','de_5_cent',null,round,3.92,21.25,1.67,'false','Cent'
        UNION ALL SELECT 'DE','10','0.10','de_10_cent',null,round,4.1,19.75,1.93,'false','Cent'
        UNION ALL SELECT 'DE','20','0.20','de_20_cent',null,round,5.74,22.25,2.14,'false','Cent'
        UNION ALL SELECT 'DE','50','0.50','de_50_cent',null,round,7.8,24.25,2.38,'false','Cent'
        UNION ALL SELECT 'DE','1','1.00','de_1_euro',null,round,7.5,23.25,2.33,'false','Euro'
        UNION ALL SELECT 'DE','2','2.00','de_2_euro',null,round,8.5,25.75,2.2,'false','Euro'
);