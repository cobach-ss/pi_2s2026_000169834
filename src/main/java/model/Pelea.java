package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Pelea {
    private Personaje personaje1;
    private Personaje personaje2;
    private LocalDateTime fechaHora;

    public Pelea(Personaje personaje1, Personaje personaje2) {
        this.personaje1 = personaje1;
        this.personaje2 = personaje2;
        this.fechaHora = LocalDateTime.now();
    }

    public Personaje getPersonaje1() {
        return personaje1;
    }

    public Personaje getPersonaje2() {
        return personaje2;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    @Override
    public String toString() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return personaje1.getNombre() + " vs " + personaje2.getNombre() +
                " | Fecha: " + fechaHora.format(formato);
    }
}
