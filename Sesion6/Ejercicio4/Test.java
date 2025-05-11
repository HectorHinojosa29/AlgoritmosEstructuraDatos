package Ejercicio4;


public class Test {
    public static void main(String[] args) {
        // Casos de prueba del laboratorio
        String[] pruebas = {
            "()()()[()]()",    // true
            "((()))[]",        // true
            "([])[](",         // false
            "([{)]}",          // false
            "[",               // false
            "[][][]{{{}}}"     // true
        };
        
        System.out.println("=== Resultados de las Pruebas ===");
        System.out.println("Expresión\t\tBalanceado?");
        System.out.println("--------------------------------");
        
        for (String prueba : pruebas) {
            boolean resultado = Aplication.symbolBalancing(prueba);
            System.out.println(prueba + "\t\t" + resultado);
        }
        
        // Mis propias pruebas adicionales
        System.out.println("\n=== Mis Pruebas Adicionales ===");
        probarCaso("", true);               // Cadena vacía
        probarCaso("({[]})", true);         // Anidamiento correcto
        probarCaso("{[}]", false);          // Mezcla incorrecta
        probarCaso("(a[b{c}d]e)", true);    // Con otros caracteres
        probarCaso("((())", false);         // Falta cerrar
        probarCaso("(()))", false);         // Falta abrir
    }
    
    // Método auxiliar para mostrar pruebas
    private static void probarCaso(String expresion, boolean esperado) {
        boolean resultado = Aplication.symbolBalancing(expresion);
        String estado = (resultado == esperado) ? "✓" : "✗";
        System.out.printf("%s %-15s → Esperado: %-5b Obtenido: %-5b\n", 
                         estado, "\"" + expresion + "\"", esperado, resultado);
    }
}