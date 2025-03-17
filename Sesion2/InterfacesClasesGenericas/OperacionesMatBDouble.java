package InterfacesClasesGenericas;

public class OperacionesMatBDouble implements Operable<Double> {
	@Override
	public Double suma(Double operando1, Double operando2) {
		return operando1 + operando2;
	}
	public Double resta(Double operando1, Double operando2) {
		return operando1 - operando2;
	}
	public Double producto(Double operando1, Double operando2) {
		return operando1 * operando2;
	}
	public Double division(Double operando1, Double operando2) {
		return operando1 / operando2;
	}
}
