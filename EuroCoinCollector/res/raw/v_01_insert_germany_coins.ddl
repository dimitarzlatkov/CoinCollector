/*
* A file inserting Germany into coins table.
*/

INSERT INTO coins (country_code,facial_value,value,image,description,shape,weight,diameter,thickness,commemorative,currency_type)
 SELECT * FROM ( SELECT 'DE','1','0.01','de_1_cent',null,0,0,0,0,'false','Cent'
        UNION ALL SELECT 'DE','2','0.02','de_2_cent',null,0,0,0,0,'false','Cent'
);