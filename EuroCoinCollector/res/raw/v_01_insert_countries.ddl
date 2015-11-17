/*
*
* A file inserting countries into countries table.
*/

INSERT INTO countries (code,country_name,country_flag)
 SELECT * FROM ( SELECT 'AD','Andorra','ad'
 		UNION ALL SELECT 'AT','Austria','at'
        UNION ALL SELECT 'BE','Belgium','be'
        UNION ALL SELECT 'CY','Cyprus','cy'
        UNION ALL SELECT 'EE','Estonia','ee'
        UNION ALL SELECT 'FI','Finland','fi'
        UNION ALL SELECT 'FR','France','fr'
        UNION ALL SELECT 'DE','Germany','de'
        UNION ALL SELECT 'GR','Greece','gr'
        UNION ALL SELECT 'IE','Ireland','ie'
        UNION ALL SELECT 'IT','Italy','it'
        UNION ALL SELECT 'LV','Latvia','lv'
        UNION ALL SELECT 'LT','Lithuania','lt'
        UNION ALL SELECT 'LU','Luxembourg','lu'
        UNION ALL SELECT 'MT','Malta','mt'
        UNION ALL SELECT 'MC','Monaco','mc'
        UNION ALL SELECT 'NL','the Netherlands','nl'
        UNION ALL SELECT 'PT','Portugal','pt'
        UNION ALL SELECT 'SM','San Marino','sm'
        UNION ALL SELECT 'SK','Slovakia','sk'
        UNION ALL SELECT 'SI','Slovenia','si'
        UNION ALL SELECT 'ES','Spain','es'
        UNION ALL SELECT 'VA','Vatican','va'
);