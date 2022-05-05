package tipoCola;

import tipoPila.PilaLista;
import java.io.*;

public class Aerodromo {
    static int maxAvtaFila = 16;

    public static void main(String[] a) {
        String avta;
        char ch = ' ';
        String c;
        Bicola fila;
        boolean esta, valido, mas = true;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        fila = new Bicola();
        while (mas) {
            System.out.println("Para terminar la simulación: X");
            try {
                do {
                    System.out.print("acción(E/S/T): ");
                    c = entrada.readLine();
                    ch = c.charAt(0);
                    ch = Character.toUpperCase(ch);
                    valido = (c.length() == 1) && (ch == 'E' || ch == 'S' || ch == 'T' || ch == 'X');
                } while (!valido);
                if (ch == 'S') {
                    if (!fila.bicolaVacia()) {
                        avta = (String) fila.quitarFrente();
                        System.out.println("Salida de la avioneta: " + avta);
                    }
                } else if (ch == 'E') {
                    if (fila.numElemsBicola() < maxAvtaFila) {
                        System.out.print("matrícula: ");
                        avta = entrada.readLine();
                        fila.ponerFinal(avta);
                    }
                } else if (ch == 'T') {
                    System.out.print("matrícula: ");
                    avta = entrada.readLine();
                    esta = retirar(fila, avta);
                    if (!esta)
                        System.out.println("¡¡avioneta no encontrada!!");
                }
            } catch (Exception er) {
                System.err.println("Excepción en la simulación: " + er);
            }
            mas = !(ch == 'X');
        }
    }

    static boolean retirar(Bicola fila, String avioneta) throws Exception {
        boolean encontrada = false;
        PilaLista pila = new PilaLista();
        while (!encontrada && !fila.bicolaVacia()) {
            String avta;
            avta = (String) fila.quitarFrente();
            if (avioneta.equals(avta)) {
                encontrada = true;
                System.out.println("Avioneta " + avta + " retirada");
            } else
                pila.insertar(avta);
        }
        // elementos de la pila se meten de nuevo en la fila
        while (!pila.pilaVacia()) {
            fila.ponerFrente(pila.quitar());
        }
        return encontrada; // operación realizada
    }
}
