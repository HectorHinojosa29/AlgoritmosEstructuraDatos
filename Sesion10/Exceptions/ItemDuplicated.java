// Excepción personalizada que se lanza cuando se intenta insertar un elemento duplicado en el árbol
package Exceptions;

public class ItemDuplicated extends Exception {

    // Constructor con mensaje personalizado
    public ItemDuplicated(String msg) {
        super(msg);
    }

    // Constructor por defecto
    public ItemDuplicated() {
        super();
    }
}
