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
	
	public Integer raizCuad(Integer operando1) {
		return (int) Math.sqrt(operando1);
	}
	
	public Integer raizCubi(Integer operando1) {
		return (int) Math.cbrt(operando1);
	}
	
}
