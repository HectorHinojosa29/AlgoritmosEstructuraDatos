// Excepción personalizada para cuando no se encuentra un elemento en el árbol
package Exceptions;

public class ItemNotFound extends Exception {

    // Constructor que permite especificar un mensaje de error
    public ItemNotFound(String msg) {
        super(msg);
    }

    // Constructor por defecto sin mensaje
    public ItemNotFound() {
        super();
    }
}
