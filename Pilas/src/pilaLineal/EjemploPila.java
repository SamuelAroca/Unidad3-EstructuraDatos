package pilaLineal;

import java.io.*;

public class EjemploPila {
    public static void main(String[] args) {
        PilaLineal pila;
        int x;
        final int CLAVE = -1;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Teclea los elemento (termina con -1).");
        try {
            pila = new PilaLineal(); // crea pila vacía
            do {
                x = Integer.parseInt(entrada.readLine());
                if (x == CLAVE )
                    break;
                pila.insertar(x);
            } while (true);
            System.out.println("Elementos de la Pila: ");
            while (!pila.pilaVacia()) {
                x = (Integer)pila.quitar();
                System.out.print(x + " ");
            }
        } catch (Exception er) {
            System.err.println("Excepcion: " + er);
        }
    }
}
