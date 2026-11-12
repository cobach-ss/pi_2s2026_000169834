package model;

public class Personaje {
    private int id;
    private String nombre;
    private String arma;
    private String[] habilidades;
    private int nivelPoder;

    public Personaje(){
        this.habilidades = new String[5];
    }

    public void setArma(String arma) {
        this.arma = arma;
    }
    public void setHabilidad(int indice, String habilidad) {
        if (indice >= 0 && indice < 5){
            this.habilidades[indice] = habilidad;
        }
    }

    public void setNivelPoder(int nivel) {
        this.nivelPoder = nivel;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getNivelPoder() {
        return nivelPoder;
    }

    public String getNombre() {
        return nombre;
    }

    public String getArma() {
        return arma;
    }

    public String[] getHabilidad() {
        return habilidades;
    }


}
