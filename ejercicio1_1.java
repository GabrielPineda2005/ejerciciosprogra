import java.util.Scanner;

public class ejercicio1_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Porfavor, ingresa un numero: ");
        int numero = scanner.nextInt();
        if(numero<0){
            System.out.println("El numero es negativo");
        }else if(numero>0){
            System.out.println("El numero es positivo");
        }else{
            System.out.println("El numero es 0");
        }
    }
}
