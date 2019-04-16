CREATE  PROCEDURE SP_select_caller4(OUT SP_name varchar(20), IN id1 varchar(20)) 
BEGIN
	SELECT id INTO SP_name FROM dev WHERE id=id1;
END;