/*
* COPYRIGHT 2012 MUSALA SOFT
*
* A file inserting templates into templates table.
*/

INSERT INTO countries (code,country_name,country_flag)
 SELECT * FROM ( SELECT 'DE','Germany','germany'
        UNION ALL SELECT 'BE','Belgium','belgium'
);