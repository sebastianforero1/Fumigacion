import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("================ PESTICIDAS EL CARRANCHIL =======================");

        // Aqui pedimos cuantos Hogares hay
        Scanner sc = new Scanner(System.in);
        int cantidadHogares = 0;
        boolean datoCorrecto = false;

        do {
            try {
                System.out.print("\nIngresa la cantidad de Hogares que hay en el conjunto residencial: ");
                cantidadHogares = sc.nextInt();

                if (cantidadHogares > 0)
                    datoCorrecto = true;
                else {
                    System.out.println("Error; Ingresa una cantidad valida de hogares");
                }
            } catch (InputMismatchException errorDato) {
                System.out.println("Error; Ingrese correctamente el dato, por favor digital el numero de hogares");
                sc.next();
            }
        } while (!datoCorrecto);

        System.out.println("Comienza el proceso");

        // Instancia de la clase UnidadR
        UnidadR miUnidad = new UnidadR(cantidadHogares);
        Hogar miHogar = new Hogar();
        CasasFumigadas porcentaje = miUnidad.ObtienePorcentajeHogaresFumigados();
        System.out.println("Las plagas que estan afectando a la comunidad son:");

        int contador = 1;
        Hogar[] hogar = miUnidad.hogar;

        for (Hogar hogar1 : hogar) {
            System.out.println("Casa No. " + contador + ", " + hogar1.toString());
            contador++;
        }
        System.out.println("El Porcentaje de casas fumigadas fue: " + porcentaje.getPorcentaje() + "%");

        ProductoModa productoFavorito = miUnidad.ObtieneProductoPlagaMasUtilizado();
        System.out.println("METODO FINAL ================================================");
        System.out.println(productoFavorito);

    }

}