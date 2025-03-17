package PyPooAct1;

import java.util.Scanner;

import PyPooEje1.ContainerRect;

public class Principal {

    public static Rectangulo rectanguloSobre(Rectangulo r1, Rectangulo r2) {
 
        double x1 = Math.max(r1.getEsquina1().getX(), r2.getEsquina1().getX());
        double y1 = Math.max(r1.getEsquina1().getY(), r2.getEsquina1().getY());
        double x2 = Math.min(r1.getEsquina2().getX(), r2.getEsquina2().getX());
        double y2 = Math.min(r1.getEsquina2().getY(), r2.getEsquina2().getY());

        return new Rectangulo(new Coordenada(x1, y1), new Coordenada(x2, y2));
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Ingrese una esquina del 1er rectángulo:");
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();
      
        
        System.out.println("Ingrese la esquina opuesta del 1er rectángulo:");
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();

        Rectangulo A = new Rectangulo(new Coordenada(x1, y1), new Coordenada(x2, y2));

        System.out.println("Ingrese una esquina del 2do rectángulo:");
        double x3 = scanner.nextDouble();
        double y3 = scanner.nextDouble();

        
        System.out.println("Ingrese la esquina opuesta del 2do rectángulo: ");
        double x4 = scanner.nextDouble();
        double y4 = scanner.nextDouble();

        Rectangulo B = new Rectangulo(new Coordenada(x3, y3), new Coordenada(x4, y4));


        System.out.println("Rectángulo A: " + A);
        System.out.println("Rectángulo B: " + B);


        if (Verificador.esSobrePos(A, B)) {
            System.out.println("Los rectángulos A y B se sobreponen.");
            Rectangulo sobreposicion = rectanguloSobre(A, B);
            
        } else if (Verificador.esJunto(A, B)) {
            System.out.println("Los rectángulos A y B están juntos.");
        } else {
            System.out.println("Los rectángulos A y B son disjuntos.");
        }

     // Crear un contenedor con capacidad para 5 rectángulos
        ContainerRect contenedor = new ContainerRect(5);
        
        // Crear algunos rectángulos
        Rectangulo r1 = new Rectangulo(new Coordenada(1.5, 0.3), new Coordenada(7.6, 2.2));
        Rectangulo r2 = new Rectangulo(new Coordenada(4.0, 4.2), new Coordenada(9.4, -2.5));
        
        // Agregar los rectángulos al contenedor
        contenedor.agregarRectangulo(r1);
        contenedor.agregarRectangulo(r2);
        
        // Mostrar los rectángulos almacenados
        System.out.println(contenedor);
    }
 	}

