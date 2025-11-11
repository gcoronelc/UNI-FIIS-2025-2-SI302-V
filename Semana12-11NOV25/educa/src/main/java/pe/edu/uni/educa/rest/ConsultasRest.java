package pe.edu.uni.educa.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.uni.educa.service.ConsultasService;

import java.util.List;
import java.util.Map;

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

    @GetMapping("/matricula/listado/{idCurso}")
    public ResponseEntity<?> listaMatriculados(@PathVariable int idCurso) {
        try {
            List<Map<String, Object>> matriculados = consultasService.listaMatriculados(idCurso);
            return ResponseEntity.ok(matriculados);

        } catch (RuntimeException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", e.getMessage()));
        }
    }

}
