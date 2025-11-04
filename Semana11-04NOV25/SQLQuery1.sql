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
where m.cur_id = 2;
go









