package InterfacesClasesGenericas;

public class OperacionesMatBInteger implements Operable<Integer>{
	@Override
	public Integer suma(Integer operando1, Integer operando2) {
		return operando1 + operando2;
	}
	public Integer resta(Integer operando1, Integer operando2) {
		return operando1 - operando2;
	}
	public Integer producto(Integer operando1, Integer operando2) {
		return operando1 * operando2;
	}
	public Integer division(Integer operando1, Integer operando2) {
		return operando1 / operando2;
	}
	
	public Integer potencia(Integer operando1, Integer operando2) {
		return (int) Math.pow(operando1,operando2);
	}
	
	public Integer potencia(Integer operando1, Integer operando2) {
		return (int) Math.pow(operando1,operando2);
	}
}
