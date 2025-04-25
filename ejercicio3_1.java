import java.util.Scanner;

public class ejercicio3_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double suma = 0;
        while (true) {
            // en esta parte pedira el ingreso de un numero
            System.out.println("Ingrese un numero para realizar la suma:");
            double numero = scanner.nextDouble();
            //condicion para que si se ingresa un numero negativo se termine el bucle
            if(numero<0){
                break;
            }

            //suma en cadena de los numero
            suma+=numero;
        }
        //mostrar el resultado final de la suma
        System.out.println("La suma total es:"+suma);
    }
}
