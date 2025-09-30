-- Consulta 1


select 
	cur_id id, cur_nombre nombre,
	cur_vacantes vacantes,
	cur_matriculados matriculador,
	cast(cur_matriculados * 100.00 / cur_vacantes as decimal(10,2)) porcVentas
from curso;


-- Consulta 2
-- Aplicar CTE

with 
mat as (
	select 
		cur_id id,
		COUNT(1) matriculados,
		SUM(mat_precio) proyectado
	from MATRICULA
	group by cur_id
),
rec as (
	select 
		cur_id id,
		SUM(pag_importe) recaudado
	from pago
	group by cur_id
)
select
	mat.id, c.cur_nombre nombre,
	mat.matriculados, mat.proyectado,
	ISNULL(rec.recaudado,0.0) recaudado,
	(mat.proyectado - ISNULL(rec.recaudado,0.0)) deuda
from curso c
join mat on c.cur_id = mat.id
left join rec on mat.id = rec.id


select count(1) cont from CURSO
where cur_id=55 
and (cur_vacantes - cur_matriculados) > 0

Update CURSO
set cur_matriculados = cur_matriculados + 1
where cur_id=?


select * from matricula


insert into MATRICULA(cur_id,alu_id,emp_id,mat_tipo,
mat_fecha,mat_precio,mat_cuotas)
values(?,?,?,?,GETDATE(),?,?)


SELECT * FROM CURSO;
SELECT * FROM MATRICULA;






