import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class cajero {

    public static void main(String[] args) {
        String nombreArchivo = "saldo.dat";
        double valorInicial = 1000.50;
        File archivo = new File(nombreArchivo);

        try {
            if (!archivo.exists()) {
                archivo.createNewFile();
                FileOutputStream fos = new FileOutputStream(archivo);
                BufferedOutputStream bos = new BufferedOutputStream(fos);
                DataOutputStream dos = new DataOutputStream(bos);
                dos.writeDouble(valorInicial);
                dos.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            //clearScreen();
            System.out.println("1. Consulta de saldo");
            System.out.println("2. Retiro de dinero");
            System.out.println("0. Salir");
            System.out.println("Opcion: ");
            opcion = leerOpcion(scanner);
            switch (opcion) {
                case 1:
                    consultarSaldo(archivo);
                    break;
                case 2:
                    retiro(archivo, scanner);
                    break;
            }
        } while (opcion != 0);
    }

    public static void consultarSaldo(File archivo) {
        try {
            // Crear un FileInputStream para leer el archivo binario
            FileInputStream fis = new FileInputStream(archivo);
            DataInputStream dis = new DataInputStream(fis);

            // Leer el valor double desde el archivo
            double valorLeido = dis.readDouble();

            // Mostrar el valor en la consola
            System.out.println("El Saldo de su cuenta es el siguiente: " + valorLeido);

            // Cerrar el DataInputStream
            dis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int leerOpcion(Scanner scanner) {
        int opcion = -1;
        try {
            opcion = scanner.nextInt();  // Leer la opción ingresada por el usuario
        } catch (Exception e) {
            scanner.nextLine();  // Limpiar el buffer de entrada en caso de error
            System.out.println("Por favor ingrese un número válido.");
        }
        return opcion;
    }

    public static int leerNumero(Scanner scanner) {
        int numero = -1;
        System.out.print("Ingrese un número entero: ");
        try {
            numero = scanner.nextInt();  // Leer un número entero
        } catch (Exception e) {
            scanner.nextLine();  // Limpiar el buffer de entrada en caso de error
            System.out.println("Por favor ingrese un número válido.");
        }
        return numero;
    }

    public static void retiro(File archivo, Scanner scanner) {
        try {
            // Crear un FileInputStream para leer el archivo binario
            FileInputStream fis = new FileInputStream(archivo);
            DataInputStream dis = new DataInputStream(fis);

            // Leer el valor double desde el archivo
            double valorLeido = dis.readDouble();
            int nr = leerNumero(scanner);  // Ahora lee un número entero

            if (nr > valorLeido) {
                System.out.println("No hay suficiente dinero en la cuenta para realizar el retiro.");
            } else {
                valorLeido -= nr;  // Realizar el retiro de dinero
                FileOutputStream fos = new FileOutputStream(archivo);
                DataOutputStream dos = new DataOutputStream(fos);
                dos.writeDouble(valorLeido);  // Escribir el nuevo saldo
                dos.close();
                System.out.println("Transacción exitosa! Saldo actual: " + valorLeido);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
