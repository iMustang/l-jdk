CREATE  PROCEDURE SP_select_caller2(IN SP_name varchar(20)) 
BEGIN
	IF SP_name=null OR SP_name=' ' THEN
	    SELECT * FROM dev;
	ELSE
	    SELECT * FROM dev WHERE id=SP_name;
	END IF;
END;