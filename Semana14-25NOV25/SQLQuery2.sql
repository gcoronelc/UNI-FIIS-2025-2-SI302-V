-- Validat usuario


select emp_id id, emp_apellido apellido, emp_nombre nombre,
emp_email email, emp_usuario usuario, '*****' clave
from empleado
where emp_usuario='eaguero' and emp_clave='cazador';
go

select * from EMPLEADO;
