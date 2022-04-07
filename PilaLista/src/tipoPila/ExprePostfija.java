package tipoPila;

public class ExprePostfija {
    public static String postFija(String expOrg) throws Exception {
        PilaLista pila;
        String e;
        Character at;
        char[] expsion;
        char ch;
        boolean desapila;
        int n = 0; // contador de expresión en postfija

        if (!valido(expOrg))
            throw new Exception("Caracter no válido en una expresión");

        e = expOrg.toUpperCase(); // operandos en mayúsculas
        expsion = new char[e.length()];
        pila = new PilaLista();

        for (int i = 0; i < e.length(); i++) {
            ch = e.charAt(i);
            // análisis del elemento
            if (operando(ch)) {
                expsion[n++] = ch;
            } else if (ch != ')') { // es un operador o un '('
                desapila = true;
                while (desapila) {
                    char opeCima = ' ';
                    if (!pila.pilaVacia()) {
                        at = (Character) pila.cimaPila();
                        opeCima = at.charValue();
                    }
                    if (pila.pilaVacia() || (prdadFuera(ch) > prdadDentro(opeCima))) {
                        pila.insertar(ch);
                        desapila = false;
                    } else if (prdadFuera(ch) <= prdadDentro(opeCima)) {
                        at = (Character) pila.quitar();
                        expsion[n++] = at.charValue();
                    }
                }
            } else { // es un ')'
                at = (Character) pila.quitar();
                do {
                    expsion[n++] = at.charValue();
                    at = (Character) pila.quitar();
                } while (at.charValue() != '(');
            }
        }
        /*
         * se vuelca los operadores que quedan en la pila y se pasan a la expresión.
         */
        while (!pila.pilaVacia()) {
            at = (Character) pila.quitar();
            expsion[n++] = at.charValue();
        }

        return new String(expsion, 0, n); // expresión en postfija
    }

    private static int prdadDentro(char op) {
        int pdp = -1;
        switch (op) {
            case '^':
                pdp = 3;
                break;
            case '*':
            case '/':
                pdp = 2;
                break;
            case '+':
            case '-':
                pdp = 1;
                break;
            case '(':
                pdp = 0;
        }
        return pdp;
    }

    // prioridad del operador en la expresión infija
    private static int prdadFuera(char op) {
        int pfp = -1;
        switch (op) {
            case '^':
                pfp = 4;
                break;
            case '*':
            case '/':
                pfp = 2;
                break;
            case '+':
            case '-':
                pfp = 1;
                break;
            case '(':
                pfp = 5;
        }
        return pfp;
    }

    private static boolean valido(String expresion) {
        boolean sw = true;
        for (int i = 0; (i < expresion.length()) && sw; i++) {
            char c;
            c = expresion.charAt(i);
            sw = sw && ( (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')
                    || (c == '^' || c == '/' || c == '*' || c == '+'
                    || c == '-' || c == '(' || c == ')') );
        }
        return sw;
    }

    public static boolean operando(char c) {
        return (c >= 'A' && c <= 'Z');
    }
}
