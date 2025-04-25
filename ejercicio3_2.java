import java.util.Scanner;

public class ejercicio3_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int contador = 0;

        while (true) {
            //incrementar el contador
            contador++;
            System.out.println("Accion #"+contador+": Hello, Dexter Morgan");
            System.out.println("Quieres continuar si/no:");
            String respuesta = scanner.nextLine();
            if(!respuesta.equalsIgnoreCase("si")){
                break;
            }
        }

        System.out.println("El programa ha realizado la accion " + contador + " veces");
    }
}
