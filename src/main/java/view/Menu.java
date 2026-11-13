package view;

import model.Estudiante;
import model.Personaje;
import service.GestorPersonaje;
import service.GestorPelea;
import util.Validador;

import java.util.Scanner;

public class Menu {

    private Scanner scanner;
    private GestorPersonaje gestorPersonajes;
    private GestorPelea gestorPeleas;
    private Estudiante estudiante;

    public Menu(){

        this.scanner = new Scanner(System.in);
        this.gestorPersonajes = new GestorPersonaje();
        this.gestorPeleas = new GestorPelea();
        this.estudiante = new Estudiante
                ("Sebastián", "García" , "000169834", "Ingenieria en sistemas");

    }

    public void mostrarMenu(){

        System.out.println("                                       ");
        System.out.println("SISTEMA DE GESTION DE PERSONAJE ");
        System.out.println("1. Agregar personaje");
        System.out.println("2. Modificar personaje");
        System.out.println("3. Eliminar personaje");
        System.out.println("4. Ver datos de un Personaje");
        System.out.println("5. Ver listado de Personajes");
        System.out.println("6. Realizar pelea entre personajes");
        System.out.println("7. Ver Historial de Peleas");
        System.out.println("8. Ver datos de estudiante");
        System.out.println("9. Salir");
        System.out.println("                                       ");
    }

    public void ejecutar(){

        int opcion;

        do{
            mostrarMenu();
            opcion = Validador.leerEntero(scanner, "Seleccione una opcion: ");

            if (!Validador.validarOpcion(opcion, 1 , 9)){
                System.out.println("Opcion invalida");
                continue;
            }
            switch (opcion){
                case 1:
                    agregarPersonaje();
                    break;
                case 2:
                    modificarPersonaje();
                    break;
                case 3:
                    eliminarPersonaje();
                    break;
                case 4:
                    verDatosPersonaje();
                    break;
                case 5:
                    gestorPersonajes.lista();
                    break;
                case 6:
                    realizarPelea();
                    break;
                case 7:
                    gestorPeleas.listaHistorial();
                    break;
                case 8:
                    verDatosEstudiante();
                    break;
                case 9:
                    System.out.println("Saliendo del juego...");
                    break;
            }
        }
        while(opcion != 9);
    }
    private void agregarPersonaje() {
        System.out.println("\n--- AGREGAR PERSONAJE ---");

        String nombre;
        do {
            System.out.print("Nombre del personaje: ");
            nombre = scanner.nextLine().trim();
            if (!Validador.validarTextoNoVacio(nombre)) {
                System.out.println("Error: El nombre no puede estar vacio.");
            } else if (gestorPersonajes.existeNombre(nombre)) {
                System.out.println("Error: Ya existe un personaje con ese nombre. Ingrese otro.");
                nombre = "";
            }
        } while (!Validador.validarTextoNoVacio(nombre));

        String arma;
        do {
            System.out.print("Arma del personaje: ");
            arma = scanner.nextLine().trim();
            if (!Validador.validarTextoNoVacio(arma)) {
                System.out.println("Error: El arma no puede estar vacia.");
            }
        } while (!Validador.validarTextoNoVacio(arma));

        Personaje personaje = new Personaje();
        personaje.setNombre(nombre);
        personaje.setArma(arma);


        int cantHabilidades;
        do {
            cantHabilidades = Validador.leerEntero(scanner, "Cuantas habilidades desea agregar (1-5): ");
            if (!Validador.validarOpcion(cantHabilidades, 1, 5)) {
                System.out.println("Error: La cantidad debe estar entre 1 y 5.");
            }
        } while (!Validador.validarOpcion(cantHabilidades, 1, 5));


        for (int i = 0; i < cantHabilidades; i++) {
            String habilidad;
            do {
                System.out.print("Habilidad " + (i + 1) + ": ");
                habilidad = scanner.nextLine().trim();
                if (!Validador.validarTextoNoVacio(habilidad)) {
                    System.out.println("Error: La habilidad no puede estar vacia.");
                }
            } while (!Validador.validarTextoNoVacio(habilidad));
            personaje.setHabilidad(i, habilidad);
        }


        int nivelPoder;
        do {
            nivelPoder = Validador.leerEntero(scanner, "Nivel de poder (1-100): ");
            if (!Validador.validarNivelPoder(nivelPoder)) {
                System.out.println("Error: El nivel de poder debe estar entre 1 y 100.");
            }
        } while (!Validador.validarNivelPoder(nivelPoder));
        personaje.setNivelPoder(nivelPoder);


        if (gestorPersonajes.agregar(personaje)) {
            System.out.println("Personaje agregado exitosamente con ID: " + personaje.getId());
        } else {
            System.out.println("No se pudo agregar el personaje.");
        }
    }

    private void modificarPersonaje() {
        System.out.println("\n--- MODIFICAR PERSONAJE ---");
        gestorPersonajes.lista();

        int id = Validador.leerEntero(scanner, "Ingrese el ID del personaje a modificar: ");
        Personaje personaje = gestorPersonajes.buscarPorId(id);

        if (personaje == null) {
            System.out.println("No se encontro un personaje con ID: " + id);
            return;
        }

        System.out.println("\nDatos actuales del personaje:");
        System.out.println(personaje.mostrarInformacion());


        System.out.print("\nNueva arma (Enter para mantener '" + personaje.getArma() + "'): ");
        String arma = scanner.nextLine().trim();
        if (Validador.validarTextoNoVacio(arma)) {
            personaje.setArma(arma);
        }


        System.out.print("Desea modificar las habilidades? (s/n): ");
        String respuesta = scanner.nextLine().trim();
        if (respuesta.equalsIgnoreCase("s")) {
            int cantHabilidades;
            do {
                cantHabilidades = Validador.leerEntero(scanner, "Cuantas habilidades desea agregar (1-5): ");
                if (!Validador.validarOpcion(cantHabilidades, 1, 5)) {
                    System.out.println("Error: La cantidad debe estar entre 1 y 5.");
                }
            } while (!Validador.validarOpcion(cantHabilidades, 1, 5));

            for (int i = 0; i < 5; i++) {
                personaje.setHabilidad(i, null);
            }

            for (int i = 0; i < cantHabilidades; i++) {
                String habilidad;
                do {
                    System.out.print("Habilidad " + (i + 1) + ": ");
                    habilidad = scanner.nextLine().trim();
                    if (!Validador.validarTextoNoVacio(habilidad)) {
                        System.out.println("Error: La habilidad no puede estar vacia.");
                    }
                } while (!Validador.validarTextoNoVacio(habilidad));
                personaje.setHabilidad(i, habilidad);
            }
        }

        System.out.print("Desea modificar el nivel de poder? (s/n): ");
        respuesta = scanner.nextLine().trim();
        if (respuesta.equalsIgnoreCase("s")) {
            int nivelPoder;
            do {
                nivelPoder = Validador.leerEntero(scanner, "Nuevo nivel de poder (1-100): ");
                if (!Validador.validarNivelPoder(nivelPoder)) {
                    System.out.println("Error: El nivel de poder debe estar entre 1 y 100.");
                }
            } while (!Validador.validarNivelPoder(nivelPoder));
            personaje.setNivelPoder(nivelPoder);
        }

        if (gestorPersonajes.modificar(personaje)) {
            System.out.println("Personaje modificado exitosamente.");
        } else {
            System.out.println("No se pudo modificar el personaje.");
        }
    }

    private void eliminarPersonaje() {
        System.out.println("\n--- ELIMINAR PERSONAJE ---");
        gestorPersonajes.lista();

        int id = Validador.leerEntero(scanner, "Ingrese el ID del personaje a eliminar: ");
        Personaje personaje = gestorPersonajes.buscarPorId(id);

        if (personaje == null) {
            System.out.println("No se encontro un personaje con ID: " + id);
            return;
        }

        System.out.println("Personaje encontrado: " + personaje.toString());
        System.out.print("Esta seguro de eliminar este personaje? (s/n): ");
        String confirmacion = scanner.nextLine().trim();

        if (confirmacion.equalsIgnoreCase("s")) {
            if (gestorPersonajes.eliminar(personaje)) {
                System.out.println("Personaje eliminado exitosamente.");
            } else {
                System.out.println("No se pudo eliminar el personaje.");
            }
        } else {
            System.out.println("Eliminacion cancelada.");
        }
    }

    private void verDatosPersonaje() {
        System.out.println("\n--- VER DATOS DE PERSONAJE ---");
        int id = Validador.leerEntero(scanner, "Ingrese el ID del personaje: ");
        Personaje personaje = gestorPersonajes.buscarPorId(id);

        if (personaje == null) {
            System.out.println("No se encontro un personaje con ID: " + id);
            return;
        }

        System.out.println(personaje.mostrarInformacion());
    }

    private void realizarPelea() {
        System.out.println("\n--- REALIZAR PELEA ---");
        gestorPersonajes.lista();


        int id1 = Validador.leerEntero(scanner, "Ingrese el ID del primer personaje: ");
        Personaje p1 = gestorPersonajes.buscarPorId(id1);

        if (p1 == null) {
            System.out.println("No se encontro un personaje con ID: " + id1);
            return;
        }

        int id2 = Validador.leerEntero(scanner, "Ingrese el ID del segundo personaje: ");

        if (id1 == id2) {
            System.out.println("Error: Un personaje no puede pelear contra si mismo.");
            return;
        }

        Personaje p2 = gestorPersonajes.buscarPorId(id2);
        if (p2 == null) {
            System.out.println("No se encontro un personaje con ID: " + id2);
            return;
        }

        if (gestorPeleas.registrarPelea(p1, p2)) {
            System.out.println("Pelea registrada exitosamente: " +
                    p1.getNombre() + " vs " + p2.getNombre());
        } else {
            System.out.println("No se pudo registrar la pelea.");
        }
    }

    private void verDatosEstudiante() {
        System.out.println("\n" + estudiante.toString());
    }
}
