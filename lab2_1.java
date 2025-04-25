import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class lab2_1 {
    public static void main(String[] args) {
        boolean continuar = true;
        while (continuar) {
            try {
            String nombreArchivo = "saldo1.dat";
            File archivo = new File(nombreArchivo);
            int opcion = 0;
            Scanner scanner = new Scanner(System.in);
            System.out.println("1. Ingresar datos de array");
            System.out.println("2. Mostrar array");
            System.out.println("3. Sumar elementos de array");
            System.out.println("4. Maximo y minimo de elementos");
            System.out.println("5. Invertir orden array");
            System.out.println("0. Salir");
            System.out.println("Ingrese una opcion: ");
                opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    double[] array = new double[10];
                    System.out.println("Ingrese los elementos del array: ");
                    for (int i = 0; i < 10; i++) {
                        array[i] = scanner.nextDouble();
                    }
                    try {
                            archivo.createNewFile();
                            FileOutputStream fos = new FileOutputStream(archivo, false);
                            BufferedOutputStream bos = new BufferedOutputStream(fos);
                            DataOutputStream dos = new DataOutputStream(bos);
                            for (double value : array) {
                                dos.writeDouble(value);
                            }
                            dos.close();
                            System.out.println("Datos ingresados correctamente!");
                        
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    try (FileInputStream fis = new FileInputStream(archivo);
                            DataInputStream dis = new DataInputStream(fis)) {

                        double[] arrayLeido = new double[10];
                        for (int i = 0; i < 10; i++) {
                            arrayLeido[i] = dis.readDouble();
                        }

                        System.out.println("Los elementos del array son:");
                        for (double valor : arrayLeido) {
                            System.out.println(valor);
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    try (FileInputStream fis = new FileInputStream(archivo);
                            DataInputStream dis = new DataInputStream(fis)) {

                        double[] arrayLeido = new double[10];
                        for (int i = 0; i < 10; i++) {
                            arrayLeido[i] = dis.readDouble();
                        }
                        int suma = 0;

                        for (double valor : arrayLeido) {
                            suma += valor;
                        }

                        System.out.println("La suma de los elementos del array son:" + suma);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    try (FileInputStream fis = new FileInputStream(archivo);
                            DataInputStream dis = new DataInputStream(fis)) {

                        double[] arrayLeido = new double[10];
                        for (int i = 0; i < 10; i++) {
                            arrayLeido[i] = dis.readDouble();
                        }

                        double max = arrayLeido[0];
                        double min = arrayLeido[0];

                        for (double valor : arrayLeido) {
                            if (valor > max) {
                                max = valor;
                            }
                            if (valor < min) {
                                min = valor;
                            }
                        }

                        System.out.println("El valor máximo es: " + max);
                        System.out.println("El valor mínimo es: " + min);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 5:
                    try (FileInputStream fis = new FileInputStream(archivo);
                            DataInputStream dis = new DataInputStream(fis)) {

                        // Leer el array desde el archivo
                        double[] arrayLeido = new double[10];
                        for (int i = 0; i < 10; i++) {
                            arrayLeido[i] = dis.readDouble();
                        }

                        // Invertir el array
                        double[] arrayInvertido = new double[10];
                        for (int i = 0; i < arrayLeido.length; i++) {
                            arrayInvertido[i] = arrayLeido[arrayLeido.length - 1 - i];
                        }

                        // Mostrar el array invertido
                        System.out.println("El array invertido es:");
                        for (double valor : arrayInvertido) {
                            System.out.println(valor);
                        }

                        // Escribir el array invertido de vuelta al archivo
                        try (FileOutputStream fos = new FileOutputStream(archivo);
                                BufferedOutputStream bos = new BufferedOutputStream(fos);
                                DataOutputStream dos = new DataOutputStream(bos)) {

                            for (double value : arrayInvertido) {
                                dos.writeDouble(value);
                            }
                            System.out.println("El array invertido se ha almacenado correctamente en el archivo.");

                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    continuar = false;
                    break;
            }
        } catch (Exception e) {
            System.out.println("Ingresar un dato valido...");
        }
        }
    }
}
