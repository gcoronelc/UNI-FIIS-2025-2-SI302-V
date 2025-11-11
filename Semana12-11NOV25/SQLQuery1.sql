-- Consultar la cantidad de alumnos matriculados

select COUNT(1) matriculados 
from MATRICULA 
where cur_id = 70;
go


-- Consultar si existe el curso
select COUNT(1) contador 
from CURSO 
where cur_id = 77;
go

-- Lista de matriculados por curso

select 
	m.cur_id idCurso, m.alu_id idAlumno, 
	a.alu_nombre nombre, m.mat_tipo tipo,
	m.mat_precio precio, m.mat_cuotas cuotas,
	m.mat_nota nota
from MATRICULA m
join ALUMNO a on m.alu_id = a.alu_id
where m.cur_id = 1;
go


-- Consultar si la matricula ya existe
select COUNT(1) contador 
from MATRICULA 
where cur_id = 1 and alu_id=30;
go


select * from curso;
go

update curso set cur_matriculados=30
where cur_id=8;
go

update curso
set cur_matriculados = cur_matriculados + 1
where cur_id = 8 and cur_matriculados < cur_vacantes;
go


select cur_precio from CURSO where cur_id=1;
go

select * from MATRICULA;
go

insert into MATRICULA(cur_id,alu_id,emp_id,mat_tipo,mat_fecha,mat_precio,mat_cuotas)
values(?,?,?,?,GETDATE(),?,?)
go


select * from CURSO where cur_id = 1;
select * from MATRICULA where cur_id = 1;
go


sp_help empleado
go










