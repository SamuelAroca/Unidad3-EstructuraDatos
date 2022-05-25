import java.io.*;
import java.util.*;

public class ElMain {
    static Bicola bicola = new Bicola();
    static Bicola bicola2 = new Bicola();
    static Bicola bicola3 = new Bicola();

    public void quiz4() throws Exception {
        try {

            File archivo = new File("entrada.txt");
            if (archivo.exists()) {

                BufferedReader archivoLeer = new BufferedReader(new FileReader(archivo));
                String lineaLeida;
                int n = 0;

                while ((lineaLeida = archivoLeer.readLine()) != null) {
                    n++;
                    for (int i = 0; i < lineaLeida.length(); i++) {
                        if (n <= 1) {
                            int c = lineaLeida.charAt(i) - '0';
                            bicola.insertar(c);
                        }
                        if (n > 1) {
                            int s = lineaLeida.charAt(i) - '0';
                            bicola2.insertar(s);
                        }
                    }
                }


                System.out.println("Pila 1");
                List<Long> sumador = new ArrayList<>();
                List<Long> sumador2 = new ArrayList<>();
                while (!bicola.colaVacia()) {


                    //System.out.print(bicola.quitar());
                }
                System.out.println("\nPila 2");
                while (!bicola2.colaVacia()) {
                    //System.out.print(bicola2.quitar());
                    sumador2.add((Long) bicola2.quitar());
                }
                for (int i = 0; i < sumador.size(); i++) {
                    System.out.println(sumador);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) throws Exception {
        ElMain main = new ElMain();

        main.quiz4();
    }

}
