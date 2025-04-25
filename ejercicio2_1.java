import java.util.Scanner;

public class ejercicio2_1 {
    public static void main(String[] args) {
        // opciones a elegir
        System.out.println("1. Lunes");
        System.out.println("2. Martes");
        System.out.println("3. Miercoles");
        System.out.println("4. Jueves");
        System.out.println("5. Viernes");
        System.out.println("6. Sabado");
        System.out.println("7. Domingo");
        System.out.println("Elija una de las siguientes opciones ingresando el numero: ");
        // en esta parte escanner lee la variable que se esta solicitando
        Scanner scanner = new Scanner(System.in);
        int dia = scanner.nextInt();
        // se utiliza la variable en el switch, dependiendo su valor dara un mensaje acorde a las opciones dadas
        switch (dia) {
            case 1:
                System.out.println("El dia seleccionado es Lunes");
                break;
            case 2:
                System.out.println("El dia seleccionado es Martes");
                break;
            case 3:
                System.out.println("El dia seleccionado es Miercoles");
                break;
            case 4:
                System.out.println("El dia seleccionado es Jueves");
                break;
            case 5:
                System.out.println("El dia seleccionado es Viernes");
                break;
            case 6:
                System.out.println("El dia seleccionado es sabado");
                break;
            case 7:
                System.out.println("El dia seleccionado es Domingo");
                break;
        }
    }
}
