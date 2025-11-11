package pe.edu.uni.educa.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.uni.educa.dto.EmpleadoDto;
import pe.edu.uni.educa.dto.UsuarioDto;
import pe.edu.uni.educa.service.LogonService;

import java.util.Map;

@RestController
@RequestMapping("/educa")
public class LogonRest {

    @Autowired
    private LogonService logonService;

    @PostMapping("/validar")
    public ResponseEntity<?> validar(@RequestBody UsuarioDto usuario){
        try {
            // Lógica de validación
            EmpleadoDto empleado = logonService.validar(usuario);
            return ResponseEntity.ok(empleado);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", "Error en el procrso"));
        }
    }
}
