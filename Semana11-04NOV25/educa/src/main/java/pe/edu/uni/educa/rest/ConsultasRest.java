package pe.edu.uni.educa.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.uni.educa.service.ConsultasService;

@RestController
@RequestMapping("/educa")
public class ConsultasRest {

    @Autowired
    private ConsultasService consultasService;

    @GetMapping("/curso/precio/{idCurso}")
    public ResponseEntity<Double> precioCurso(@PathVariable int idCurso) {
        try {
            double precio = consultasService.precioCurso(idCurso);
            return ResponseEntity.ok(precio);
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/curso/matriculados/{idCurso}")
    public ResponseEntity<Integer> matriculados(@PathVariable int idCurso){
        try {
            Integer contador = consultasService.matriculados(idCurso);
            return ResponseEntity.ok(contador);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }


}
