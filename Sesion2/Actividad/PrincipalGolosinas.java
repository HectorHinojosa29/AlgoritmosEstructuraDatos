package Actividad;
//BOLSA DE GOLOSINAS Actividad 7
public class PrincipalGolosinas {
	public static void main(String[] args) {
		Bolsa < Golosina > bolsaGol = new Bolsa<Golosina>(100);
		Golosina g = new Golosina("caramelo",5);
		Golosina g1 = new Golosina("paleta",4);
		Golosina g2 = new Golosina("chicle",2);
		bolsaGol.add(g);
		bolsaGol.add(g1);
		bolsaGol.add(g2);
		
		for (Golosina golosina: bolsaGol) {
			System.out.println(golosina.getNombre());
		}
	}
}
