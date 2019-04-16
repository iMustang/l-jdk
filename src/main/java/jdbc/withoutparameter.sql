CREATE  PROCEDURE SP_select_caller3(OUT SP_name varchar(20)) 
BEGIN
	SELECT id INTO  SP_name FROM dev WHERE id=555;
END;