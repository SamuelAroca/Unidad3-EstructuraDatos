package colaCircular;

public class ElMain {
    public static void main(String[] args) throws Exception {

        int numero = 1451;

        int contador;

        ColaCircular colas = new ColaCircular();
        PilaLineal pilas = new PilaLineal();

        while (numero != 0 ) {
            contador = numero % 10;
            numero = numero / 10;

            pilas.insertar(contador);
            colas.insertar(contador);
        }

        int comparador;
        int comparador2;

        while (!pilas.pilaVacia()) {
            comparador = (int) pilas.quitar();
            comparador2 = (int) colas.quitar();

            if (comparador != comparador2) {
                System.out.println("No es");
                return;
            }
        }
        System.out.println("Es Capicúa");
    }
}
