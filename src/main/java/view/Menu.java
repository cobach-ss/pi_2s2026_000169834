package view;

import model.Estudiante;
import model.Personaje;
import service.GestorPersonaje;
import service.GestorPelea;
import util.Validador;

import java.util.Scanner;

public class Menu {

    private Scanner scanner;
    private GestorPersonaje gestorPersonaje;
    private GestorPelea gestorPelea;
    private Estudiante estudiante;

    public Menu(){

        this.scanner = new Scanner(System.in);
        this.gestorPersonaje = new GestorPersonaje();
        this.gestorPelea = new GestorPelea();
        this.estudiante = new Estudiante
                ("Sebastián", "Apellido" , "000169834", "Ingenieria en sistemas");

    }

    public void mostrarMenu(){

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
    }

    public void ejecutar(){

        int opcion;

        do{
            mostrarMenu();
            opcion =Validador.leerEntero(scanner, "Seleccione una opcion: ");
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

        }while(opcion ! =9);


    }
}
