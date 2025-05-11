package Ejercicio3;

import Actividad2.QueueLink;
import Actividad3.PriorityQueue;
import Actividad1.ExceptionIsEmpty;

public class PriorityQueueLinked<E, P extends Comparable<P>> implements PriorityQueue<E, P> {
    
    private QueueLink<E>[] priorityQueues;
    private int maxPriority;
    
    @SuppressWarnings("unchecked")
    public PriorityQueueLinked(int maxPriority) {
        this.maxPriority = maxPriority;
        this.priorityQueues = new QueueLink[maxPriority + 1];
        
        
        for (int i = 0; i <= maxPriority; i++) {
            priorityQueues[i] = new QueueLink<E>();
        }
    }

    @Override
    public void enqueue(E element, P priority) {
        int prio = ((Number) priority).intValue();
        if (prio < 0 || prio > maxPriority) {
            throw new IllegalArgumentException("Prioridad fuera de rango");
        }
        priorityQueues[prio].enqueue(element);
    }

    @Override
    public E dequeue() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La cola de prioridad está vacía");
        }
        
        
        for (int i = maxPriority; i >= 0; i--) {
            if (!priorityQueues[i].isEmpty()) {
                return priorityQueues[i].dequeue();
            }
        }
        
        throw new ExceptionIsEmpty("No se encontraron elementos");
    }

    @Override
    public E front() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La cola de prioridad está vacía");
        }
        
        for (int i = maxPriority; i >= 0; i--) {
            if (!priorityQueues[i].isEmpty()) {
                return priorityQueues[i].front();
            }
        }
        
        throw new ExceptionIsEmpty("No se encontraron elementos");
    }

    @Override
    public E back() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La cola de prioridad está vacía");
        }
        
        for (int i = 0; i <= maxPriority; i++) {
            if (!priorityQueues[i].isEmpty()) {
                return priorityQueues[i].back();
            }
        }
        
        throw new ExceptionIsEmpty("No se encontraron elementos");
    }

    @Override
    public boolean isEmpty() {
        for (QueueLink<E> queue : priorityQueues) {
            if (!queue.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PriorityQueueLinked [ \n");
        
        boolean first = true;
        for (int i = maxPriority; i >= 0; i--) {
            if (!priorityQueues[i].isEmpty()) {
                if (!first) {
                    sb.append(", ");
                }
                sb.append("Prioridad ").append(i).append(": ").append(priorityQueues[i].toString());
                first = false;
            }
        }
        
        sb.append("]");
        return sb.toString();
    }
    
    
}