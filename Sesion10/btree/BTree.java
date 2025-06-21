package btree;
import java.io.BufferedReader; 
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import Exceptions.ItemNotFound;
//EJERCICIO 3.2
public class BTree<E extends Comparable<E>> {
    public BNode<E> root;
    private int orden;
    private boolean up;
    private BNode<E> nDes;

    public BTree(int orden) {
        this.orden = orden;
        this.root = null;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public void insert(E cl) {
        up = false;
        E mediana;
        BNode<E> pnew;
        mediana = push(this.root, cl);
        if (up) {
            pnew = new BNode<E>(this.orden);
            pnew.count = 1;
            pnew.keys.set(0, mediana);
            pnew.childs.set(0, this.root);
            pnew.childs.set(1, nDes);
            this.root = pnew;
        }
    }

    private E push(BNode<E> current, E cl) {
        int pos[] = new int[1];
        E mediana;
        if(current == null) {
            up = true;
            nDes = null;
            return cl;
        }
        else {
            boolean f1;
            f1 = current.searchNode(cl, pos);
            if(f1) {
                System.out.println("Item duplicado\n");
                up = false;
                return null;
            }
            mediana = push(current.childs.get(pos[0]), cl);
            if(up) {
                if(current.nodeFull(this.orden-1))
                    mediana = dividedNode(current, mediana, pos[0]);
                else {
                    up = false;
                    putNode(current, mediana, nDes, pos[0]);
                }
            }
            return mediana;
        }
    }

    private void putNode(BNode<E> current, E cl, BNode<E> rd, int k) {
        int i;
        for(i = current.count-1; i >= k; i--) {
            current.keys.set(i+1, current.keys.get(i));
            current.childs.set(i+2, current.childs.get(i+1));
        }
        current.keys.set(k, cl);
        current.childs.set(k+1, rd);
        current.count++;
    }

    private E dividedNode(BNode<E> current, E cl, int k) {
        BNode<E> rd = nDes;
        int i, posMdna;
        posMdna = (k <= this.orden/2) ? this.orden/2 : this.orden/2+1;
        nDes = new BNode<E>(this.orden);
        for(i = posMdna; i < this.orden-1; i++) {
            nDes.keys.set(i-posMdna, current.keys.get(i));
            nDes.childs.set(i-posMdna+1, current.childs.get(i+1));
        }
        nDes.count = (this.orden - 1) - posMdna;
        current.count = posMdna;
        if(k <= this.orden/2)
            putNode(current, cl, rd, k);
        else
            putNode(nDes, cl, rd, k-posMdna);
        E median = current.keys.get(current.count-1);
        nDes.childs.set(0, current.childs.get(current.count));
        current.count--;
        return median;
    }

    // Método toString para mostrar el árbol completo
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (isEmpty()) {
            sb.append("BTree is empty...");
        } else {
            sb.append("BTree (orden ").append(orden).append("):\n");
            writeTree(root, sb, 0, -1);
        }
        return sb.toString();
    }

    // Método auxiliar recursivo para recorrer el árbol
    private void writeTree(BNode<E> current, StringBuilder sb, int level, int parentId) {
        if (current == null) return;
        
        // Mostrar información del nodo actual
        sb.append("Nivel ").append(level).append(", ID: ").append(current.idNode);
        if (parentId != -1) {
            sb.append(", Padre: ").append(parentId);
        }
        sb.append(", Claves: [");
        for (int i = 0; i < current.count; i++) {
            if (i > 0) sb.append(", ");
            sb.append(current.keys.get(i));
        }
        sb.append("]");
        
        // Mostrar hijos si existen
        if (current.childs.get(0) != null) {
            sb.append(", Hijos: [");
            boolean first = true;
            for (int i = 0; i <= current.count; i++) {
                if (current.childs.get(i) != null) {
                    if (!first) sb.append(", ");
                    sb.append(current.childs.get(i).idNode);
                    first = false;
                }
            }
            sb.append("]");
        }
        sb.append("\n");
        
        // Recorrer hijos recursivamente
        for (int i = 0; i <= current.count; i++) {
            writeTree(current.childs.get(i), sb, level + 1, current.idNode);
        }
    }
    
//EJERCICIO 1
    public boolean search(E cl) {
        return searchRecursive(root, cl);
    }
    
    private boolean searchRecursive(BNode<E> current, E cl) {
        if (current == null) return false;
        
        int[] pos = new int[1];
        boolean found = current.searchNode(cl, pos);
        if (found) {
            System.out.println(cl + " se encuentra en el nodo " + current.idNode + " en la posición " + pos[0]);
            return true;
        }
        
        return searchRecursive(current.childs.get(pos[0]), cl);
    }
//EJERCICIO 2
    public void remove(E cl) {
        if (root == null) {
            System.out.println("El árbol está vacío");
            return;
        }
        
        // Llamar al método de eliminación recursivo
        removeRecursive(root, cl);
        
        // Si la raíz queda vacía después de la eliminación
        if (root.count == 0) {
            if (root.childs.get(0) == null) {
                // Árbol vacío
                root = null;
            } else {
                // Hacer que el primer hijo sea la nueva raíz
                root = root.childs.get(0);
            }
        }
    }

    private void removeRecursive(BNode<E> current, E cl) {
        int[] pos = new int[1];
        boolean found = current.searchNode(cl, pos);
        
        if (found) {
            // Caso 1: La clave está en un nodo hoja
            if (current.childs.get(0) == null) {
                removeFromLeaf(current, pos[0]);
            } 
            // Caso 2: La clave está en un nodo interno
            else {
                removeFromInternalNode(current, pos[0]);
            }
        } else {
            // La clave no está en este nodo, continuar buscando en el hijo apropiado
            if (current.childs.get(0) == null) {
                System.out.println("La clave " + cl + " no existe en el árbol");
                return;
            }
            
            // Flag para indicar si el camino por donde descendemos tiene el mínimo de claves
            boolean isMin = (current.childs.get(pos[0]).count <= (orden/2) - 1);
            
            if (isMin) {
                // Intentar redistribución primero con el hermano derecho, luego con el izquierdo
                if (pos[0] < current.count && 
                    current.childs.get(pos[0]+1).count > (orden/2) - 1) {
                    // Redistribuir con hermano derecho
                    redistributeRight(current, pos[0]);
                } else if (pos[0] > 0 && 
                           current.childs.get(pos[0]-1).count > (orden/2) - 1) {
                    // Redistribuir con hermano izquierdo
                    redistributeLeft(current, pos[0]);
                } else {
                    // No se puede redistribuir, hay que fusionar
                    if (pos[0] < current.count) {
                        // Fusionar con hermano derecho
                        mergeNodes(current, pos[0]);
                    } else {
                        // Fusionar con hermano izquierdo
                        mergeNodes(current, pos[0]-1);
                        pos[0]--; // Actualizar posición después de fusionar
                    }
                }
            }
            
            // Si fusionamos con el último hijo y el nodo actual es la raíz que queda vacía
            if (current == root && current.count == 0) {
                return;
            }
            
            // Continuar la eliminación recursivamente
            removeRecursive(current.childs.get(pos[0]), cl);
        }
    }

    private void removeFromLeaf(BNode<E> node, int pos) {
        // Simplemente eliminar la clave y desplazar las demás
        for (int i = pos + 1; i < node.count; i++) {
            node.keys.set(i-1, node.keys.get(i));
        }
        node.count--;
    }

    private void removeFromInternalNode(BNode<E> node, int pos) {
        // Encontrar el predecesor (máximo en el subárbol izquierdo)
        E predecessor = getPredecessor(node.childs.get(pos));
        // Reemplazar la clave a eliminar con el predecesor
        node.keys.set(pos, predecessor);
        // Eliminar recursivamente el predecesor
        removeRecursive(node.childs.get(pos), predecessor);
    }

    private E getPredecessor(BNode<E> node) {
        // Ir al hijo más a la derecha hasta llegar a una hoja
        while (node.childs.get(node.count) != null) {
            node = node.childs.get(node.count);
        }
        // Devolver la última clave
        return node.keys.get(node.count - 1);
    }

    private void redistributeRight(BNode<E> parent, int pos) {
        BNode<E> leftChild = parent.childs.get(pos);
        BNode<E> rightChild = parent.childs.get(pos + 1);
        
        // Mover la clave del padre al hijo izquierdo
        leftChild.keys.set(leftChild.count, parent.keys.get(pos));
        leftChild.count++;
        
        // Mover la primera clave del hijo derecho al padre
        parent.keys.set(pos, rightChild.keys.get(0));
        
        // Mover el primer hijo del derecho si existe
        if (rightChild.childs.get(0) != null) {
            leftChild.childs.set(leftChild.count, rightChild.childs.get(0));
        }
        
        // Desplazar las claves e hijos del hijo derecho
        for (int i = 1; i < rightChild.count; i++) {
            rightChild.keys.set(i-1, rightChild.keys.get(i));
        }
        for (int i = 1; i <= rightChild.count; i++) {
            rightChild.childs.set(i-1, rightChild.childs.get(i));
        }
        rightChild.count--;
    }

    private void redistributeLeft(BNode<E> parent, int pos) {
        BNode<E> rightChild = parent.childs.get(pos);
        BNode<E> leftChild = parent.childs.get(pos - 1);
        
        // Desplazar claves e hijos del hijo derecho para hacer espacio
        for (int i = rightChild.count; i > 0; i--) {
            rightChild.keys.set(i, rightChild.keys.get(i-1));
        }
        for (int i = rightChild.count + 1; i > 0; i--) {
            rightChild.childs.set(i, rightChild.childs.get(i-1));
        }
        
        // Mover la clave del padre al hijo derecho
        rightChild.keys.set(0, parent.keys.get(pos - 1));
        rightChild.count++;
        
        // Mover la última clave del hijo izquierdo al padre
        parent.keys.set(pos - 1, leftChild.keys.get(leftChild.count - 1));
        
        // Mover el último hijo del izquierdo si existe
        if (leftChild.childs.get(leftChild.count) != null) {
            rightChild.childs.set(0, leftChild.childs.get(leftChild.count));
        }
        
        leftChild.count--;
    }

    private void mergeNodes(BNode<E> parent, int pos) {
        BNode<E> leftChild = parent.childs.get(pos);
        BNode<E> rightChild = parent.childs.get(pos + 1);
        
        // Mover la clave del padre al hijo izquierdo
        leftChild.keys.set(leftChild.count, parent.keys.get(pos));
        leftChild.count++;
        
        // Mover las claves del hijo derecho al izquierdo
        for (int i = 0; i < rightChild.count; i++) {
            leftChild.keys.set(leftChild.count + i, rightChild.keys.get(i));
        }
        
        // Mover los hijos del hijo derecho al izquierdo
        for (int i = 0; i <= rightChild.count; i++) {
            leftChild.childs.set(leftChild.count + i, rightChild.childs.get(i));
        }
        
        leftChild.count += rightChild.count;
        
        // Eliminar la clave del padre y desplazar las demás
        for (int i = pos + 1; i < parent.count; i++) {
            parent.keys.set(i-1, parent.keys.get(i));
        }
        
        // Eliminar el puntero al hijo derecho y desplazar los demás
        for (int i = pos + 2; i <= parent.count; i++) {
            parent.childs.set(i-1, parent.childs.get(i));
        }
        
        parent.count--;
    }
//EJERCICIO 3  
    public static BTree<Integer> building_BTree(String filename) throws ItemNotFound {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            // Leer el orden
            String linea = br.readLine();
            if (linea == null) throw new ItemNotFound("Archivo vacío");
            int orden = Integer.parseInt(linea.trim());
            BTree<Integer> arbol = new BTree<>(orden);
            
            String lineaNodo;
            while ((lineaNodo = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(lineaNodo, ",");
                if (st.countTokens() < 3) {
                    br.close();
                    throw new ItemNotFound("Formato inválido en línea: " + lineaNodo);
                }
                
                int nivel = Integer.parseInt(st.nextToken().trim());
                int idNode = Integer.parseInt(st.nextToken().trim());
                
                // Leer las claves del nodo
                while (st.hasMoreTokens()) {
                    int clave = Integer.parseInt(st.nextToken().trim());
                    arbol.insert(clave);
                }
            }
            br.close();
            return arbol;
        } catch (IOException e) {
            throw new ItemNotFound("Error leyendo el archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            throw new ItemNotFound("Formato numérico inválido: " + e.getMessage());
        }
    }
//EJERCICIO 4   
    public String buscarNombre(int codigo) {
        // Crea un objeto temporal con el código y nombre vacío
        E temp = (E) new RegistroEstudiante(codigo, "");
        // Inicia búsqueda recursiva desde la raíz
        return buscarNombreRec(root, temp);
    }

    // Método recursivo que busca el nombre en el árbol
    private String buscarNombreRec(BNode<E> current, E buscado) {
        // Si el nodo actual es nulo, no se encontró
        if (current == null) return "No encontrado";

        // Arreglo para almacenar la posición encontrada
        int[] pos = new int[1];
        // Busca el elemento en el nodo actual
        boolean found = current.searchNode(buscado, pos);

        if (found) {
            // Extrae el objeto encontrado y devuelve el nombre
            RegistroEstudiante reg = (RegistroEstudiante) current.keys.get(pos[0]);
            return reg.getNombre();
        }

        // Si no se encontró, continúa la búsqueda en el hijo correspondiente
        return buscarNombreRec(current.childs.get(pos[0]), buscado);
    }
}