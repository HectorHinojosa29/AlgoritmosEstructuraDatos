package Ejercicio4;

import Ejercicio1.StackLink;
import Actividad1.ExceptionIsEmpty;

public class Aplication {
    

    public static boolean symbolBalancing(String expresion) {

        StackLink<Character> miPila = new StackLink<Character>();
        

        for (int i = 0; i < expresion.length(); i++) {
            char simbolo = expresion.charAt(i);

            if (simbolo == '(' || simbolo == '[' || simbolo == '{') {
                miPila.push(simbolo);
            } 
      
            else if (simbolo == ')' || simbolo == ']' || simbolo == '}') {
                try {
         
                    char tope = miPila.pop();
                    
          
                    if (!corresponden(tope, simbolo)) {
                        return false;  
                    }
                } catch (ExceptionIsEmpty e) {
 
                    return false;
                }
            }

        }
        
 
        return miPila.isEmpty();
    }
    

    private static boolean corresponden(char abre, char cierra) {
        return (abre == '(' && cierra == ')') ||
               (abre == '[' && cierra == ']') ||
               (abre == '{' && cierra == '}');
    }
}