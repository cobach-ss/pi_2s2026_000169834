package model;

public class Estudiante {
    private String nombre;
    private String apellido;
    private String carrera;
    private String carnet;

    public Estudiante(String nombre, String apellido, String carnet, String carrera) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.carnet = carnet;
        this.carrera = carrera;
    }

    public Estudiante() {
        this("", "", "", "");
    }

    public void setCarrera(String carrera)   {
        this.carrera = carrera;
    }

    public void setNombre(String nombre)     {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }


    public String getNombre()   {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCarnet()   {
        return carnet;
    }

    public String getCarrera()  {
        return carrera;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " " + apellido +
                "\nCarnet: " + carnet +
                "\nCarrera: " + carrera;
    }
}
