package pilaVector;

import java.io.*;

public class EjemploPilaDinamica {
    public static void main(String[] args) {
        PilaVector pila = new PilaVector();
        int x;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Teclea número de elementos: ");
        try {
            x = Integer.parseInt(entrada.readLine());
            for (int j = 1; j <= x; j++) {
                Double d;
                d = Double.valueOf(entrada.readLine());
                pila.insertar(d);
            }
            // vaciado de la pila
            System.out.println("Elementos de la Pila: ");
            while (!pila.pilaVacia()) {
                Double d;
                d = (Double) pila.quitar();
                if (d.doubleValue() > 0.0)
                    System.out.print(d + " ");
            }
        } catch (Exception er) {
            System.err.println("Excepcion: " + er);
        }
    }
}
