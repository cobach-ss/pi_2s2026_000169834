package service;

import model.Personaje;
import model.Pelea;


public class GestorPelea {
    private Pelea[] pelea;
    private int cantidad;

    public GestorPelea() {
        this.pelea = new Pelea[100];
        this.cantidad = 0;
    }

    public boolean registrarPelea(Personaje p1, Personaje p2) {
        if(cantidad >= pelea.length) {
            System.out.println("El numero de peleas ha alcanzado su limite");
            return false;
        }
        if (p1 == null || p2 == null) {
            System.out.println("Deben haber dos personajes ya existentes para registrar la pelea");
            return false;
        }

        pelea[cantidad] = new Pelea(p1, p2);
        cantidad++;
        return true;
    }

    public void listaHistorial(){
        if(cantidad == 0){
            System.out.println("No hay peleas registradas en el historial");
            return;
        }
        System.out.println("Historial de Peleas");
        for (int i = 0; i < cantidad; i++){
            System.out.println((i + 1)+". " + pelea[i].toString());
        }
        System.out.println("Total de peleas: " + cantidad);
    }
}
