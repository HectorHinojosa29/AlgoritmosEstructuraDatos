package Actividades_Ejercicios;

import Exceptions.ItemDuplicated;  
import Exceptions.ItemNotFound;
import java.util.LinkedList;
import java.util.Queue;
import Exceptions.ExceptionIsEmpty;

//Implementación de un Árbol Binario de Búsqueda (BST) usando nodos enlazados

public class LinkedBST<E extends Comparable<E>> implements BinarySearchTree<E> {

	 // ACTIVIDADES
		
	 // Clase interna para los nodos del árbol
	 class Node {
	     public E data;
	     public Node left;
	     public Node right;
	
	     public Node(E data) {
	         this(data, null, null);
	     }
	
	     public Node(E data, Node left, Node right) {
	         this.data = data;
	         this.left = left;
	         this.right = right;
	     }
	 }
	
	 private Node root; // Raíz del árbol
	
	 public LinkedBST() {
	     this.root = null; // Árbol vacío al inicio
	 }
	
	 public boolean isEmpty() {
	     return root == null;
	 }
	
	 // Inserta un elemento en el árbol
	 @Override
	 public void insert(E data) throws ItemDuplicated {
	     root = insert(root, data);
	 }
	
	 private Node insert(Node node, E data) throws ItemDuplicated {
	     if (node == null) {
	         return new Node(data);
	     }
	
	     int compareResult = data.compareTo(node.data);
	
	     if (compareResult < 0) {
	         node.left = insert(node.left, data);
	     } else if (compareResult > 0) {
	         node.right = insert(node.right, data);
	     } else {
	         throw new ItemDuplicated("El elemento " + data + " ya existe en el árbol");
	     }
	
	     return node;
	 }
	
	 // Busca un elemento en el árbol
	 @Override
	 public E search(E data) throws ItemNotFound {
	     Node result = search(root, data);
	     if (result == null) {
	         throw new ItemNotFound("El elemento " + data + " no se encontró en el árbol");
	     }
	     return result.data;
	 }
	
	 private Node search(Node node, E data) {
	     if (node == null) return null;
	
	     int compareResult = data.compareTo(node.data);
	
	     if (compareResult < 0) return search(node.left, data);
	     else if (compareResult > 0) return search(node.right, data);
	     else return node;
	 }
	
	 // Elimina un elemento del árbol
	 @Override
	 public void delete(E data) throws ExceptionIsEmpty {
	     if (isEmpty()) {
	         throw new ExceptionIsEmpty("El árbol está vacío, no se puede eliminar");
	     }
	     root = delete(root, data);
	 }
	
	 private Node delete(Node node, E data) {
	     if (node == null) return null;
	
	     int compareResult = data.compareTo(node.data);
	
	     if (compareResult < 0) {
	         node.left = delete(node.left, data);
	     } else if (compareResult > 0) {
	         node.right = delete(node.right, data);
	     } else {
	         // Nodo sin hijos
	         if (node.left == null && node.right == null) {
	             return null;
	         }
	         // Nodo con un solo hijo
	         else if (node.left == null) {
	             return node.right;
	         } else if (node.right == null) {
	             return node.left;
	         }
	         // Nodo con dos hijos
	         else {
	             Node successor = findMinNode(node.right);
	             node.data = successor.data;
	             node.right = delete(node.right, successor.data);
	         }
	     }
	
	     return node;
	 }
	
	 // Recorridos en orden
	 public String inOrder() {
	     StringBuilder sb = new StringBuilder();
	     inOrder(root, sb);
	     return sb.toString();
	 }
	
	 private void inOrder(Node node, StringBuilder sb) {
	     if (node != null) {
	         inOrder(node.left, sb);
	         sb.append(node.data).append(" ");
	         inOrder(node.right, sb);
	     }
	 }
	
	 public String preOrder() {
	     StringBuilder sb = new StringBuilder();
	     preOrder(root, sb);
	     return sb.toString();
	 }
	
	 private void preOrder(Node node, StringBuilder sb) {
	     if (node != null) {
	         sb.append(node.data).append(" ");
	         preOrder(node.left, sb);
	         preOrder(node.right, sb);
	     }
	 }
	
	 public String postOrder() {
	     StringBuilder sb = new StringBuilder();
	     postOrder(root, sb);
	     return sb.toString();
	 }
	
	 private void postOrder(Node node, StringBuilder sb) {
	     if (node != null) {
	         postOrder(node.left, sb);
	         postOrder(node.right, sb);
	         sb.append(node.data).append(" ");
	     }
	 }
	
	 // Muestra el árbol en orden por defecto
	 @Override
	 public String toString() {
	     return inOrder();
	 }
	
	 // Encuentra el nodo con el valor mínimo
	 private Node findMinNode(Node node) {
	     while (node.left != null) {
	         node = node.left;
	     }
	     return node;
	 }
	
	 // Encuentra el nodo con el valor máximo
	 private Node findMaxNode(Node node) {
	     while (node.right != null) {
	         node = node.right;
	     }
	     return node;
	 }
	
	 public E findMin() throws ItemNotFound {
	     if (isEmpty()) {
	         throw new ItemNotFound("El árbol está vacío");
	     }
	     return findMinNode(root).data;
	 }
	
	 public E findMax() throws ItemNotFound {
	     if (isEmpty()) {
	         throw new ItemNotFound("El árbol está vacío");
	     }
	     return findMaxNode(root).data;
	 }
	
	  //EJERCICIOS
	 
	 
	 
	//Elimina todos los nodos del árbol (lo vacía)
	public void destroyNodes() throws ExceptionIsEmpty {
	  if (isEmpty()) {
	      throw new ExceptionIsEmpty("El árbol está vacío, no hay nodos que eliminar");
	  }
	  root = null;  // Se pone la raíz en null para borrar todo
	}
	
	//Cuenta todos los nodos del árbol (hojas y no hojas)
	public int countAllNodes() {
	  return countAllNodes(root);
	}
	private int countAllNodes(Node node) {
	  if (node == null) return 0;
	  return 1 + countAllNodes(node.left) + countAllNodes(node.right);
	}
	
	//Cuenta solo los nodos que no son hojas (tienen al menos un hijo)
	public int countNodes() {
	  return countNodes(root);
	}
	private int countNodes(Node node) {
	  if (node == null || (node.left == null && node.right == null)) return 0;
	  return 1 + countNodes(node.left) + countNodes(node.right);
	}
	
	//Calcula la altura del subárbol cuyo dato es x (usando búsqueda y recorrido iterativo)
	public int height(E x) throws ItemNotFound {
	  Node subTreeRoot = search(root, x);
	  if (subTreeRoot == null) return -1;
	
	  Queue<Node> queue = new LinkedList<>();
	  queue.add(subTreeRoot);
	  int height = -1;
	
	  while (!queue.isEmpty()) {
	      int levelSize = queue.size();
	      height++;
	
	      for (int i = 0; i < levelSize; i++) {
	          Node current = queue.poll();
	          if (current.left != null) queue.add(current.left);
	          if (current.right != null) queue.add(current.right);
	      }
	  }
	  return height;
	}
	
	//Devuelve la cantidad de nodos en un nivel específico (amplitud)
	public int amplitude(int level) {
	  if (root == null || level < 0) return 0;
	
	  Queue<Node> queue = new LinkedList<>();
	  queue.add(root);
	  int currentLevel = 0;
	
	  while (!queue.isEmpty()) {
	      if (currentLevel == level) return queue.size();
	
	      int levelSize = queue.size();
	      for (int i = 0; i < levelSize; i++) {
	          Node current = queue.poll();
	          if (current.left != null) queue.add(current.left);
	          if (current.right != null) queue.add(current.right);
	      }
	      currentLevel++;
	  }
	  return 0;
	}
	
	//Calcula el "área" del árbol como altura * número de hojas
	public int areaBST() throws ItemNotFound {
	  if (root == null) return 0;
	
	  int treeHeight = height(root.data);  // Altura del árbol completo
	  int leafCount = countLeaves();
	
	  return treeHeight * leafCount;
	}
	
	//Cuenta cuántas hojas tiene el árbol
	private int countLeaves() {
	  return countLeaves(root);
	}
	private int countLeaves(Node node) {
	  if (node == null) return 0;
	  if (node.left == null && node.right == null) return 1;
	  return countLeaves(node.left) + countLeaves(node.right);
	}
	
	//Imprime una representación gráfica simple del árbol en consola
	public void drawBST() {
	  System.out.println("Representación gráfica del árbol:");
	  printTree(root, 0);
	}
	private void printTree(Node node, int level) {
	  if (node == null) return;
	
	  printTree(node.right, level + 1);  // Imprime primero el hijo derecho (nivel más alto)
	
	  for (int i = 0; i < level; i++) System.out.print("    ");
	  System.out.println(node.data);
	
	  printTree(node.left, level + 1);   // Luego imprime el hijo izquierdo
	}
	
	//Imprime el árbol con paréntesis y sangría para mostrar estructura jerárquica
	public void parenthesize() {
	  parenthesize(root, 0);
	}
	private void parenthesize(Node node, int depth) {
	  if (node == null) return;
	
	  for (int i = 0; i < depth; i++) System.out.print("  ");
	  System.out.println(node.data + " (");
	
	  parenthesize(node.left, depth + 1);
	  parenthesize(node.right, depth + 1);
	
	  for (int i = 0; i < depth; i++) System.out.print("  ");
	  System.out.println(")");
	}

}