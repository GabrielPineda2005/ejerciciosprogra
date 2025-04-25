import java.util.Scanner;

public class ejercicio1_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese un año para verificar si es biciesto:");
        int año = scanner.nextInt();

        //verificacion si el año es biciesto
        if((año%4 == 0 && año%100 !=0) || (año%400 == 0)){
            System.out.println(año + " es un año biciesto");
        }else{
            System.out.println(año + " No es un año biciesto");
        }
    }
}

//8330 + 15300 = 23 630
//23630 - 6200


