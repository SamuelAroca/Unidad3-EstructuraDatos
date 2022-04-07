package tipoPila;

import java.io.*;

public class EvalPostfija {
    public static double evalua(String postFija, double v[]) throws Exception {
        PilaLista pila;
        double valor = -1.0;
        double a, b;
        int i;

        pila = new PilaLista();

        for (i = 0; i < postFija.length(); i++) {
            char op;
            op = postFija.charAt(i);
            if (ExprePostfija.operando(op)) { // es un operando
                int indice;
                indice = op - 'A';
                pila.insertar(v[indice]);
            } else { // es un operador
                Double opCima;
                opCima = (Double) pila.quitar();
                b = opCima.doubleValue();
                opCima = (Double) pila.quitar();
                a = opCima.doubleValue();

                switch (op) {
                    case '^':
                        valor = Math.pow(a, b);
                        break;
                    case '*':
                        valor = a * b;
                        break;
                    case '/':
                        if (b != 0.0)
                            valor = a / b;
                        else
                            throw new Exception("División por cero.");
                        break;
                    case '+':
                        valor = a + b;
                        break;
                    case '-':
                        valor = a - b;
                }
                pila.insertar(valor);
            }
        }
        return ((Double) pila.quitar()).doubleValue();
    }

    public static void valorOprdos(String postFija, double v[]) throws Exception {
        // asignan valores numïéricos a los operandos
        int i;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        for (i = 0; i < postFija.length(); i++) {
            char op;

            op = postFija.charAt(i);

            if (ExprePostfija.operando(op)) { // es un operando
                int indice;
                Double d;

                indice = op - 'A';
                if (v[indice] == 0) {
                    System.out.print(op + " = ");
                    d = Double.valueOf(entrada.readLine());
                    v[indice] = d.doubleValue();
                }
            }
        }
    }
}
