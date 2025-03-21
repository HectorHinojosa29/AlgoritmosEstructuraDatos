package InterfacesClasesGenericas;

public interface Operable<E extends Number> {
	
	public E suma(E operando1, E operando2);
	public E resta(E operando1, E operando2);
	public E producto(E operando1, E operando2);
	public E division(E operando1, E operando2);
	public E potencia(E operando1, E operando2);
	public E raizCuad(E operando1);
	public E raizCubi(E operando1);
	
	
	
}
