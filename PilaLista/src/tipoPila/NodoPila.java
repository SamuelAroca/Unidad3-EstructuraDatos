package tipoPila;

public class NodoPila {
    Object elemento;
    NodoPila siguiente;

    NodoPila(Object x) {
        elemento = x;
        siguiente = null;
    }
}
