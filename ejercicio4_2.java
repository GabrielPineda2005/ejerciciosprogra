import java.util.Scanner;

public class ejercicio4_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //pedir el numero que ingrese el numero n
        System.out.println("Ingrese un numero entero N: ");
        int N = scanner.nextInt();

        //iniciar variable suma
        int suma=0;

        //ciclo para calcular la suma de los primeros numeros n naturales 
        for(int i=1; i<=N; i++){
            suma+=i;// suma el valor de i a la suma
        }

        //mostrar el resultado
        System.out.println("la Suma de los primeros " + N + " numeros naturales es:" +suma);
    }
}
