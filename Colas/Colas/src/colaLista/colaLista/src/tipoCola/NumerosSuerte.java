package tipoCola;

import java.util.Random;

public class NumerosSuerte {

    public static void main(String[] args) {

        int n, n1, n2, i;
        int nv;
        ColaLista q = new ColaLista();
        Random r = new Random();
        try {
            // número inicial de elementos de la lista
            n = 11 + r.nextInt(49);
            System.out.println("N = " + n);
            // se generan n números aleatorios
            for (i = 1; i <= n; i++) {
                nv = 1 + r.nextInt(101);
                q.insertar(nv);
                System.out.print(" " + nv);
            }
            // se genera aleatoriamente el intervalo n1
            n1 = 2 + r.nextInt(11);
            System.out.println("\nn1= " + n1);
            // se retiran de la cola elementos a distancia n1
            System.out.print("\nSe quita de la lista: ");
            while (n1 <= n) {
                Object nt;
                n2 = 0; // contador de elementos que quedan
                for (i = 1; i <= n; i++) {
                    nt = q.quitar();
                    if (i % n1 == 1) {
                        System.out.print(nt + " ");
                        if (i % 15 == 0) System.out.println(" ");
                    } else {
                        q.insertar(nt); // se vuelve a meter en la cola
                        n2++;
                    }
                }
                n = n2;
                n1 = 2 + r.nextInt(11);
                System.out.println("\nn1= " + n1);
            }
            System.out.println("\nLos números de la suerte: ");
            mostrarCola(q);
            System.out.println();
        } catch (Exception t) {
            System.out.println("Ha ocurrido la excepción: " + t);
        }
    }

    private static void mostrarCola(ColaLista q) throws Exception {
        while (!q.colaVacia()) {
            Integer v;
            v = (Integer) q.quitar();
            System.out.print(" " + v);
        }
    }
}
