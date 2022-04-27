package colaCircular;

public class ColaCircular {
    private static final int MAXTAMQ = 99;
    protected int frente;
    protected int fin;
    protected Object[] listaCola;

    // avanza una posición
    private int siguiente(int r) {
        return (r + 1) % MAXTAMQ;
    }

    // inicializa la cola vacía
    public ColaCircular() {
        frente = 0;
        fin = MAXTAMQ - 1;
        listaCola = new Object[MAXTAMQ];
    }

    // operaciones de modificación de la cola
    public void insertar(Object elemento) throws Exception {
        if (!colaLlena()) {
            fin = siguiente(fin);
            listaCola[fin] = elemento;
        } else
            throw new Exception("Overflow en la cola");
    }

    public Object quitar() throws Exception {
        if (!colaVacia()) {
            Object tm = listaCola[frente];
            frente = siguiente(frente);
            return tm;
        } else
            throw new Exception("Cola vacia ");
    }

    public void borrarCola() {
        frente = 0;
        fin = MAXTAMQ - 1;
    }

    // acceso a la cola
    public Object frenteCola() throws Exception {
        if (!colaVacia()) {
            return listaCola[frente];
        } else
            throw new Exception("Cola vacia ");
    }

    // métodos de verificación del estado de la cola
    public boolean colaVacia() {
        return frente == siguiente(fin);
    }

    // comprueba si está llena
    public boolean colaLlena() {
        return frente == siguiente(siguiente(fin));
    }
}
