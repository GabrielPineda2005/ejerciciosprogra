
import java.util.Arrays;
public class eje2 {
    public static void main(String[] args) {
        String texto = new String("Hola Mundo");
        System.out.println(texto);
        int[] numeros = {10,20,30,40,50};
        System.out.println("El valor de mi array" + Arrays.toString(numeros));

        int buscado = 30;
        boolean encontrado = false;

        for(int num : numeros) {
            if(num == buscado) {
                encontrado = true;
                break;
            }}
    }
}