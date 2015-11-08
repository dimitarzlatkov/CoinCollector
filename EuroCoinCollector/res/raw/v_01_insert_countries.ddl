/*
*
* A file inserting countries into countries table.
*/

INSERT INTO countries (code,country_name,country_flag)
 SELECT * FROM ( SELECT 'AD','Andorra','andorra'
 		UNION ALL SELECT 'AT','Austria','austria'
        UNION ALL SELECT 'BE','Belgium','belgium'
        UNION ALL SELECT 'CY','Cyprus','cyprus'
        UNION ALL SELECT 'EE','Estonia','estonia'
        UNION ALL SELECT 'FI','Finland','finland'
        UNION ALL SELECT 'FR','France','france'
        UNION ALL SELECT 'DE','Germany','germany'
        UNION ALL SELECT 'GR','Greece','greece'
        UNION ALL SELECT 'IE','Ireland','ireland'
        UNION ALL SELECT 'IT','Italy','italy'
        UNION ALL SELECT 'LV','Latvia','latvia'
        UNION ALL SELECT 'LT','Lithuania','lithuania'
        UNION ALL SELECT 'LU','Luxembourg','luxembourg'
        UNION ALL SELECT 'MT','Malta','malta'
        UNION ALL SELECT 'MC','Monaco','monaco'
        UNION ALL SELECT 'NL','the Netherlands','netherlands'
        UNION ALL SELECT 'PT','Portugal','portugal'
        UNION ALL SELECT 'SM','San Marino','sanmarino'
        UNION ALL SELECT 'SK','Slovakia','slovakia'
        UNION ALL SELECT 'SI','Slovenia','slovenia'
        UNION ALL SELECT 'ES','Spain','spain'
        UNION ALL SELECT 'VA','Vatican','vatican'
);