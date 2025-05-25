package Actividad;

//Árbol AVL que extiende BSTree y mantiene balance automático
public class AVLTree<E extends Comparable<E>> extends BSTree<E> {

 @Override
 public void insert(E data) {
     setRoot(insert(getRoot(), data)); // Inserta y actualiza raíz
 }

 // Inserción recursiva con balanceo AVL
 protected NodeAVL<E> insert(NodeAVL<E> node, E data) {
     if (node == null) return new NodeAVL<>(data); // Caso base

     int cmp = data.compareTo(node.getData());
     if (cmp < 0) {
         node.left = insert((NodeAVL<E>) node.left, data);
         node = updateBalanceAfterInsertLeft(node); // Balanceo izquierdo
     } else if (cmp > 0) {
         node.right = insert((NodeAVL<E>) node.right, data);
         node = updateBalanceAfterInsertRight(node); // Balanceo derecho
     }
     return node;
 }

 // Actualiza balance tras inserción izquierda
 private NodeAVL<E> updateBalanceAfterInsertLeft(NodeAVL<E> node) {
     node.bf--; // Disminuye factor de balance
     if (node.bf == -2) return balanceToRight(node); // Rotación si está desbalanceado
     return node;
 }

 // Actualiza balance tras inserción derecha
 private NodeAVL<E> updateBalanceAfterInsertRight(NodeAVL<E> node) {
     node.bf++; // Aumenta factor de balance
     if (node.bf == 2) return balanceToLeft(node); // Rotación si está desbalanceado
     return node;
 }

 // Rotación simple a izquierda (Left-Left case)
 private NodeAVL<E> rotateSL(NodeAVL<E> node) {
     NodeAVL<E> child = (NodeAVL<E>) node.right;
     node.right = child.left;
     child.left = node;
     return child; // Devuelve nueva raíz del subárbol
 }

 // Rotación simple a derecha (Right-Right case)
 private NodeAVL<E> rotateSR(NodeAVL<E> node) {
     NodeAVL<E> child = (NodeAVL<E>) node.left;
     node.left = child.right;
     child.right = node;
     return child; // Devuelve nueva raíz del subárbol
 }

 // Balanceo para lado izquierdo (casos Left-Left y Left-Right)
 private NodeAVL<E> balanceToLeft(NodeAVL<E> node) {
     NodeAVL<E> child = (NodeAVL<E>) node.right;
     switch (child.bf) {
         case 1: // Caso Left-Left
             node.bf = child.bf = 0;
             return rotateSL(node);
         case -1: // Caso Left-Right
             NodeAVL<E> grandchild = (NodeAVL<E>) child.left;
             // Ajusta factores de balance según caso
             if (grandchild.bf == -1) {
                 node.bf = 0;
                 child.bf = 1;
             } else if (grandchild.bf == 0) {
                 node.bf = child.bf = 0;
             } else {
                 node.bf = -1;
                 child.bf = 0;
             }
             grandchild.bf = 0;
             node.right = rotateSR(child);
             return rotateSL(node);
     }
     return node;
 }

 private NodeAVL<E> balanceToRight(NodeAVL<E> node) {
	    // 1. Obtiene el hijo izquierdo (child)
	    NodeAVL<E> child = (NodeAVL<E>) node.left;
	    
	    // 2. Evalúa el factor de balance (bf) del hijo
	    switch (child.bf) {
	        case -1: // Caso Right-Right (simple)
	            node.bf = 0;    // Actualiza factores de balance
	            child.bf = 0;
	            return rotateSR(node); // Rotación simple a derecha
	            
	        case 1: // Caso Right-Left (doble rotación)
	            NodeAVL<E> grandchild = (NodeAVL<E>) child.right;
	            
	            // 3. Ajusta factores según el nieto (grandchild)
	            switch (grandchild.bf) {
	                case 1: // Subcaso A
	                    node.bf = 0;
	                    child.bf = -1;
	                    break;
	                case 0: // Subcaso B
	                    node.bf = 0;
	                    child.bf = 0;
	                    break;
	                case -1: // Subcaso C
	                    node.bf = -1;
	                    child.bf = 0;
	                    break;
	            }
	            grandchild.bf = 0; // El nieto queda balanceado
	            
	            // 4. Rotación compuesta:
	            node.left = rotateSL(child); // Primero rotación izquierda al hijo
	            return rotateSR(node);       // Luego rotación derecha al nodo original
	    }
	    return node; // Retorna el nodo si no requiere balanceo
	}
 
 // ---- Ejercicio 2: Eliminación ----
 public void delete(E data) {
     setRoot(delete(getRoot(), data)); // Elimina y actualiza raíz
 }

 private NodeAVL<E> delete(NodeAVL<E> node, E data) {
     if (node == null) return null; // No encontrado

     int cmp = data.compareTo(node.getData());
     if (cmp < 0) {
         node.left = delete((NodeAVL<E>) node.left, data);
         node = updateBalanceAfterDeleteLeft(node); // Balanceo izquierdo
     } else if (cmp > 0) {
         node.right = delete((NodeAVL<E>) node.right, data);
         node = updateBalanceAfterDeleteRight(node); // Balanceo derecho
     } else {
         // Caso 1: Nodo con 0 o 1 hijo
         if (node.left == null) return (NodeAVL<E>) node.right;
         if (node.right == null) return (NodeAVL<E>) node.left;

         // Caso 2: Nodo con 2 hijos
         NodeAVL<E> successor = findMin((NodeAVL<E>) node.right);
         node.setData(successor.getData());
         node.right = delete((NodeAVL<E>) node.right, successor.getData());
         node = updateBalanceAfterDeleteRight(node);
     }
     return node;
 }

 // Encuentra el nodo mínimo en un subárbol
 private NodeAVL<E> findMin(NodeAVL<E> node) {
     while (node.left != null) node = (NodeAVL<E>) node.left;
     return node;
 }

 // Actualiza balance tras eliminación izquierda
 private NodeAVL<E> updateBalanceAfterDeleteLeft(NodeAVL<E> node) {
     node.bf++;
     if (node.bf == 2) return balanceToLeft(node);
     return node;
 }

 // Actualiza balance tras eliminación derecha
 private NodeAVL<E> updateBalanceAfterDeleteRight(NodeAVL<E> node) {
     node.bf--;
     if (node.bf == -2) return balanceToRight(node);
     return node;
 }
}