package pe.edu.uni.educa.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.uni.educa.dto.MatriculaDto;
import pe.edu.uni.educa.service.ProcesosService;

@RestController
@RequestMapping("/educa")
public class ProcesosRest {

    @Autowired
    private ProcesosService procesosService;

    @PostMapping("/matricular")
    public MatriculaDto matricular(@RequestBody MatriculaDto bean){
        return procesosService.matricular(bean);
    }

}
