package service;

import model.Personaje;

public class GestorPersonaje {
    private Personaje[] personajes;
    private int cantidad;
    private int siguienteId;

    public GestorPersonaje() {
        this.personajes = new Personaje[100];
        this.cantidad = 0;
        this.siguienteId = 1;

    }

    public boolean existeNombre(String nombre) {
        for (int i = 0; i < cantidad; i++) {
            if (personajes[i].getNombre().equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        return false;
    }


    public boolean agregar(Personaje personaje) {
        if (cantidad >= personajes.length) {
            System.out.println("El sistema ha alcanzado el limite de personajes.");
            return false;

        }
        if (existeNombre(personaje.getNombre())){
            System.out.println("El nombre ya existe" + personaje.getNombre());
            return false;
        }
        personaje.setId(siguienteId);
        siguienteId++;
        personajes[cantidad] = personaje;
        cantidad++;
        return true;
    }

    public boolean modificar(Personaje personaje) {
        for (int i = 0; i < cantidad; i++) {
            if (personajes[i].getId() == personaje.getId()) {
                personajes[i] = personaje;
                return true;
            }
        }
        return false;
    }
    public boolean eliminar(Personaje personaje) {
        for (int i = 0; i < cantidad; i++) {
            if (personajes[i].getId() == personaje.getId()) {
                // Desplazar elementos hacia la izquierda para cubrir el hueco
                for (int j = i; j < cantidad - 1; j++) {
                    personajes[j] = personajes[j + 1];
                }
                // Limpiar la ultima posicion y reducir la cantidad
                personajes[cantidad - 1] = null;
                cantidad--;
                return true;
            }
        }
        return false;
    }

    public Personaje buscarPorId(int id) {
        for (int i = 0; i < cantidad; i++) {
            if (personajes[i].getId() == id) {
                return personajes[i];
            }
        }
        return null;
    }

    public void lista() {
        if (cantidad == 0) {
            System.out.println("No hay personajes registrados en el sistema.");
            return;
        }
        System.out.println("\n===== LISTADO DE PERSONAJES =====");
        for (int i = 0; i < cantidad; i++) {
            System.out.println(personajes[i].toString());
        }
        System.out.println("Total de personajes: " + cantidad);
    }
}


