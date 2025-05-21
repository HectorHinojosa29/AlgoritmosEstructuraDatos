// Excepción personalizada que se lanza cuando se intenta operar con un árbol vacío
package Exceptions;

public class ExceptionIsEmpty extends Exception {
    
    // Constructor que permite enviar un mensaje personalizado
    public ExceptionIsEmpty(String msg) {
        super(msg);
    }

    // Constructor por defecto sin mensaje
    public ExceptionIsEmpty() {
        super();
    }
}
