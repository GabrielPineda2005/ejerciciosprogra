import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class lab2_2 {
    public static void main(String[] args) {
        ArrayList<String> listaCompras = cargarListaDesdeArchivo("listaCompras.txt");
        Scanner scanner = new Scanner(System.in);
        int opcion = 0; // Inicializamos la opción

        do {
            try {
                System.out.println("\nMenú de opciones:");
                System.out.println("1. Agregar un producto a la lista");
                System.out.println("2. Mostrar la lista de compras");
                System.out.println("3. Eliminar un producto de la lista");
                System.out.println("4. Buscar un producto en la lista");
                System.out.println("5. Ordenar la lista de productos alfabéticamente");
                System.out.println("6. Guardar la lista en archivo");
                System.out.println("7. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer

                switch (opcion) {
                    case 1:
                        String producto;
                        do {
                            System.out.print("Ingrese el nombre del producto (no puede estar vacío): ");
                            producto = scanner.nextLine();
                            if (producto.trim().isEmpty()) {
                                System.out.println("Error: El nombre del producto no puede estar vacío o contener solo espacios.");
                            }
                        } while (producto.trim().isEmpty()); // Repetir si el producto es inválido
                        listaCompras.add(producto);
                        System.out.println("Producto agregado.");
                        break;

                    case 2:
                        System.out.println("\nLista de compras:");
                        if (listaCompras.isEmpty()) {
                            System.out.println("La lista de compras está vacía.");
                        } else {
                            for (String item : listaCompras) {
                                System.out.println("- " + item);
                            }
                        }
                        break;

                    case 3:
                        System.out.print("Ingrese el nombre del producto a eliminar: ");
                        String productoEliminar = scanner.nextLine();
                        if (listaCompras.remove(productoEliminar)) {
                            System.out.println("Producto eliminado.");
                        } else {
                            System.out.println("El producto no se encuentra en la lista.");
                        }
                        break;

                    case 4:
                        System.out.print("Ingrese el nombre del producto a buscar: ");
                        String productoBuscar = scanner.nextLine();
                        if (listaCompras.contains(productoBuscar)) {
                            System.out.println("El producto está en la lista.");
                        } else {
                            System.out.println("El producto no está en la lista.");
                        }
                        break;

                    case 5:
                        Collections.sort(listaCompras);
                        System.out.println("Lista ordenada alfabéticamente.");
                        break;

                    case 6:
                        guardarListaEnArchivo("listaCompras.txt", listaCompras);
                        System.out.println("Lista guardada en archivo.");
                        break;

                    case 7:
                        System.out.println("Saliendo del programa...");
                        break;

                    default:
                        System.out.println("Opción inválida, intente nuevamente.");
                }
            } catch (Exception e) {
                System.out.println("Error: Ingrese un número válido como opción.");
                scanner.nextLine(); // Limpiar buffer en caso de entrada incorrecta
            }
        } while (opcion != 7);

        scanner.close();
    }

    private static ArrayList<String> cargarListaDesdeArchivo(String nombreArchivo) {
        ArrayList<String> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lista.add(linea);
            }
        } catch (IOException e) {
            System.out.println("No se pudo cargar la lista desde el archivo: " + e.getMessage());
        }
        return lista;
    }

    private static void guardarListaEnArchivo(String nombreArchivo, ArrayList<String> lista) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (String item : lista) {
                bw.write(item);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("No se pudo guardar la lista en el archivo: " + e.getMessage());
        }
    }
}