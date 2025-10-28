package pe.edu.uni.demo01.dto;

import pe.edu.uni.demo01.service.MateService;

public class MateDto
{
    // Datos
    private int n1;
    private int n2;
    // Respuesta
    private int suma;
    private int mcd;
    private int mcm;

    public MateDto() {
    }

    public MateDto(int n1, int n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    public int getN1() {
        return n1;
    }

    public void setN1(int n1) {
        this.n1 = n1;
    }

    public int getN2() {
        return n2;
    }

    public void setN2(int n2) {
        this.n2 = n2;
    }

    public int getSuma() {
        return suma;
    }

    public void setSuma(int suma) {
        this.suma = suma;
    }

    public int getMcd() {
        return mcd;
    }

    public void setMcd(int mcd) {
        this.mcd = mcd;
    }

    public int getMcm() {
        return mcm;
    }

    public void setMcm(int mcm) {
        this.mcm = mcm;
    }
}
