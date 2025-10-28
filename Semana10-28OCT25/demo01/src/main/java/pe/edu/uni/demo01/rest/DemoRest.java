package pe.edu.uni.demo01.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.uni.demo01.dto.MateDto;
import pe.edu.uni.demo01.service.MateService;

@RestController
public class DemoRest {

    @Autowired
    private MateService mateService;

    @GetMapping("/saludo")
    public String saludo(){
        return "Hola amigos del futuro!!!";
    }

    @PostMapping("/sumar")
    public String sumar(int n1, int n2){
        int suma = mateService.sumar(n1,n2);
        String rpta = n1 + " + " + n2 + " = " + suma;
        return rpta;
    }

    // Variable en la ruta del servicio
    @GetMapping("/factorial/{n}")
    public long factorial(@PathVariable int n){
        return mateService.factorial(n);
    }

    // Varias operaciones
    @PostMapping("/opera")
    public MateDto opera(@RequestBody MateDto bean){
        return mateService.opera(bean);
    }

}
