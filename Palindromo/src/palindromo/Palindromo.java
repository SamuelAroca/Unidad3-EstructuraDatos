package palindromo;

import java.io.*;

public class Palindromo {
    public static void main(String[] args) {
        PilaLineal pilaChar;
        boolean esPalindromo;
        String pal;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try {
            pilaChar = new PilaLineal(); // crea pila vacía
            System.out.print("Teclea la palabra" + " a verificar si es palíndromo: ");
            pal = entrada.readLine();
            // se crea la pila con los caracteres de la palabra
            for (int i = 0; i < pal.length();) {
                Character c;
                c = pal.charAt(i++);
                if (c != ' ')
                    pilaChar.insertar(c);
            }
            // se comprueba si es palíndromo
            esPalindromo = true;
            for (int j = 0; esPalindromo && !pilaChar.pilaVacia();) {
                Character c;
                c = (Character) pilaChar.quitar();
                while (pal.charAt(j) == ' ')
                    j++;
                esPalindromo = pal.charAt(j++) == c.charValue();
            }
            pilaChar.limpiarPila();
            if (esPalindromo)
                System.out.println("La palabra " + pal + " es un palíndromo \n");
            else
                System.out.println("La palabra " + pal + " no es un palíndromo \n");
        } catch (Exception er) {
            System.err.println("Excepcion: " + er);
        }
    }
}
