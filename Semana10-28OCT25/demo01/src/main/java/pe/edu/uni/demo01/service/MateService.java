package pe.edu.uni.demo01.service;

import org.springframework.stereotype.Service;
import pe.edu.uni.demo01.dto.MateDto;

@Service
public class MateService {

    public int sumar(int n1, int n2){
        return (n1 + n2);
    }

    public long factorial(int n){
        if(n == 0 || n == 1){
            return 1;
        }
        return n * factorial(n-1);
    }

    public MateDto opera(MateDto bean){
        // Proceso
        bean.setSuma(this.sumar(bean.getN1(), bean.getN2()));
        // Reporte
        return bean;
    }

}
