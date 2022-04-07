package tipoPila;

public class EjemploEvaluaExpresion {
    public static void main(String[] a) {
        double[] v = new double[26];
        double resultado;
        //BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        String expresion;
        try {
            //System.out.print("\nExpresión aritmética: ");
            //expresion = entrada.readLine();
            expresion = "a*b/(a+c)";

            // Conversión de infija a postfija
            expresion = ExprePostfija.postFija(expresion);
            System.out.println("\nExpresión en postfija: " + expresion);

            // Evaluación de la expresión
            EvalPostfija.valorOprdos(expresion, v); // valor de operandos
            resultado = EvalPostfija.evalua(expresion, v);
            System.out.println("Resultado = " + resultado);
        } catch (Exception e) {
            System.out.println("\nError en el proceso ... " + e);
            e.getStackTrace();
        }
    }
}
