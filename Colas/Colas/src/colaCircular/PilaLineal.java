package colaCircular;

public class PilaLineal {
    private static final int TAMPILA = 49;
    private int cima;
    private Object[] listaPila;

    public PilaLineal() {
        cima = -1; // condición de pila vacía
        listaPila = new Object[TAMPILA];
    }

    // operaciones que añaden o extraen elementos
    public void insertar(Object elemento) throws Exception {
        if (pilaLlena()) {
            throw new Exception("Desbordamiento pila");
        }
        // incrementar puntero cima y copia elemento
        cima++;
        listaPila[cima] = elemento;
    }

    public Object quitar() throws Exception {
        Object aux;
        if (pilaVacia()) {
            throw new Exception("Pila vacía, no se puede extraer.");
        }
        // guarda elemento de la cima
        aux = listaPila[cima];
        // decrementar cima y devolver elemento
        cima--;
        return aux;
    }

    public Object cimaPila() throws Exception {
        if (pilaVacia()) {
            throw new Exception("Pila vacía, no hay elementos.");
        }
        return listaPila[cima];
    }

    // resto de operaciones
    public boolean pilaVacia() {
        return cima == -1;
    }

    public boolean pilaLlena() {
        return cima == TAMPILA - 1;
    }

    public void limpiarPila() {
        cima = -1;
    }
}
