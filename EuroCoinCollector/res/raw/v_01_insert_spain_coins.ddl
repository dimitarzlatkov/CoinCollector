/*
* A file inserting Spain coins into coins table.
*/

INSERT INTO coins (country_code,facial_value,value,image,description,shape,weight,diameter,thickness,commemorative,currency_type)
 SELECT * FROM ( SELECT 'ES','1','0.01','es_1_cent',null,'round',2.3,16.25,1.67,'false','Cent'
        UNION ALL SELECT 'ES','2','0.02','es_2_cent',null,'round',3.06,18.75,1.67,'false','Cent'
        UNION ALL SELECT 'ES','5','0.05','es_5_cent',null,'round',3.92,21.25,1.67,'false','Cent'
        UNION ALL SELECT 'ES','10','0.10','es_10_cent',null,'round',4.1,19.75,1.93,'false','Cent'
        UNION ALL SELECT 'ES','20','0.20','es_20_cent',null,'round',5.74,22.25,2.14,'false','Cent'
        UNION ALL SELECT 'ES','50','0.50','es_50_cent',null,'round',7.8,24.25,2.38,'false','Cent'
        UNION ALL SELECT 'ES','1','1.00','es_1_euro',null,'round',7.5,23.25,2.33,'false','Euro'
        UNION ALL SELECT 'ES','2','2.00','es_2_euro',null,'round',8.5,25.75,2.2,'false','Euro'
        UNION ALL SELECT 'ES','2','2.00','es_2_euro','Escorial monastery','round',8.5,25.75,2.2,'true','Euro'
        UNION ALL SELECT 'ES','2','2.00','es_2_euro','Don Quixote','round',8.5,25.75,2.2,'true','Euro'
        UNION ALL SELECT 'ES','2','2.00','es_2_euro','50th Anniversary of the Treaty of Rome','round',8.5,25.75,2.2,'true','Euro'
        UNION ALL SELECT 'ES','2','2.00','es_2_euro','10th Anniversary of the European Monetary Union','round',8.5,25.75,2.2,'true','Euro'
        UNION ALL SELECT 'ES','2','2.00','es_2_euro','Cordoba Historical Center','round',8.5,25.75,2.2,'true','Euro'
        UNION ALL SELECT 'ES','2','2.00','es_2_euro','Alhambra','round',8.5,25.75,2.2,'true','Euro'
        UNION ALL SELECT 'ES','2','2.00','es_2_euro','10 Years of Euro Cash','round',8.5,25.75,2.2,'true','Euro'
        UNION ALL SELECT 'ES','2','2.00','es_2_euro','Burgos Cathedral','round',8.5,25.75,2.2,'true','Euro'
        UNION ALL SELECT 'ES','2','2.00','es_2_euro','Gaudi&apos;s Guell Park','round',8.5,25.75,2.2,'true','Euro'
        UNION ALL SELECT 'ES','2','2.00','es_2_euro','King Felipe VI Accession to Spanish Throne','round',8.5,25.75,2.2,'true','Euro'
        UNION ALL SELECT 'ES','2','2.00','es_2_euro','Cueva de Altamira','round',8.5,25.75,2.2,'true','Euro'
);