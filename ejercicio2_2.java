import java.time.LocalDate;
import java.util.Scanner;

public class ejercicio2_2 {
    public static void main(String[] args) {
        // impresion de mensaje o informacion del programa
        System.out.println("Seleccione una de las opciones:");
        System.out.println("1. Mostrar mensaje de bienvenida");
        System.out.println("2. Mostrar fecha actual");
        System.out.println("3. Salir");
        Scanner scanner = new Scanner(System.in);
        int opcion = scanner.nextInt();
        switch (opcion) {
            case 1:
                // codigo para imprimir el mensaje
                System.out.println("Bienvenidos al programa");
                break;
            case 2:
                // obtener la fecha actual
                LocalDate fechaHoy = LocalDate.now();
                // mostrar la fecha en formato YYYY-MM-DD
                System.out.println("La fecha de hoy es:" + fechaHoy);
                break;
            case 3:
                // codigo para salir del programa
                System.exit(0);
                break;
        }
    }
}
