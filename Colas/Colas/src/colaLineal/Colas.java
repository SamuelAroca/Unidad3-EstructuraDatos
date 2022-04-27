package colaLineal;

public class Colas {
   private static final int MAXTAMQ = 39;
   protected int frente;
   protected int fin;
   protected Object[] listaCola;

   public Colas() {
       frente = 0;
       fin = -1;
       listaCola = new Object[MAXTAMQ];
   }

    // operaciones de modificación de la cola
    public void insertar(Object elemento) throws Exception {
        if (!colaLlena()) {
            listaCola[++fin] = elemento;
        } else
            throw new Exception("Overflow en la cola");
    }

    public Object quitar() throws Exception {
        if (colaVacia()) {
            return listaCola[frente++];
        } else
            throw new Exception("Cola vacia ");
    }

    // vacía la cola
    public void borrarCola() {
        frente = 0;
        fin = -1;
    }

    // acceso a la cola
    public Object frenteCola() throws Exception {
        if (colaVacia()) {
            return listaCola[frente];
        } else
            throw new Exception("Cola vacia ");
    }

   public boolean colaVacia() {
       return frente <= fin;
   }

   public boolean colaLlena() {
       return fin == MAXTAMQ -1;
   }
}
