package btree;
//EJERCICIO 3.1
import java.util.ArrayList;

public class BNode<E> {
    protected ArrayList<E> keys;
    protected ArrayList<BNode<E>> childs;
    protected int count;
    protected int idNode;
    private static int nextId = 0;

    public BNode(int n) {
        this.keys = new ArrayList<E>(n);
        this.childs = new ArrayList<BNode<E>>(n);
        this.count = 0;
        this.idNode = nextId++;
        
        for(int i = 0; i < n; i++) {
            this.keys.add(null);
            this.childs.add(null);
        }
    }


    public boolean nodeFull(int maxKeys) {
        return count >= maxKeys;
    }


    public boolean nodeEmpty() {
        return count == 0;
    }


    public boolean searchNode(E key, int[] pos) {
        pos[0] = 0;
        while (pos[0] < count) {
            int cmp = ((Comparable<E>)key).compareTo(keys.get(pos[0]));
            if (cmp == 0) {
                return true; // Key found
            } else if (cmp < 0) {
                break; 
            }
            pos[0]++;
        }
        return false; 
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Node ").append(idNode).append(": [");
        for (int i = 0; i < count; i++) {
            if (i > 0) sb.append(", ");
            sb.append(keys.get(i));
        }
        sb.append("]");
        return sb.toString();
    }

    public int getIdNode() {
        return idNode;
    }
    
    public ArrayList<E> getKeys() {
        return keys;
    }
    
    public ArrayList<BNode<E>> getChilds() {
        return childs;
    }
    
    public int getCount() {
        return count;
    }
}