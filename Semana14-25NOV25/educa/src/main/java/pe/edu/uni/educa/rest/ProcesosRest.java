package pe.edu.uni.educa.rest;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.uni.educa.dto.ErrorResponse;
import pe.edu.uni.educa.dto.MatriculaDto;
import pe.edu.uni.educa.service.ProcesosService;

import java.time.LocalDateTime;

@CrossOrigin("*")
@RestController
@RequestMapping("/educa")
public class ProcesosRest {

    @Autowired
    private ProcesosService procesosService;

    /*
    @PostMapping("/matricular")
    public MatriculaDto matricular(@RequestBody MatriculaDto bean){
        return procesosService.matricular(bean);
    }*/


    @PostMapping("/matricular")
    public ResponseEntity<?> matricular(@RequestBody MatriculaDto bean, HttpServletRequest request) {
        try {
            MatriculaDto resultado = procesosService.matricular(bean);
            return ResponseEntity.ok(resultado);
        } catch (Exception e) {
            ErrorResponse error = new ErrorResponse(
                    e.getMessage(),
                    LocalDateTime.now().toString(),
                    request.getRequestURI()
            );
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }

}
