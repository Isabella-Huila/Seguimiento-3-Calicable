
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Lista lista = new Lista();
        int opcion = 0;
        int contadorTurnos = 0;

        while (opcion != 5) {
            System.out.println("Hola, bienvenido a Bancolombia, por favor digita una opción");
            System.out.println("1. Dar turno");
            System.out.println("2. Mostrar turno actual");
            System.out.println("3. Pasar turno");
            System.out.println("4. Seguir");
            System.out.println("5. Salir");
            System.out.println("Lista de Turnos hasta este momento : ");lista.mostrarLista(); // siemore me muestra todos loa turnos
            // coloque esa línea para no equivocarme, quitar antes de entregar

            System.out.print("Ingrese una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    contadorTurnos++;
                    lista.agregar(contadorTurnos);
                    System.out.println("Se ha agregado el turno " + contadorTurnos + " a la lista.");
                    break;
                case 2:
                    lista.mostrarActual();
                    break;
                case 3:
                    lista.pasarTurno();
                    System.out.println("El turno actual ha sido cambiado.");
                    break;
                case 4:
                    lista.eliminar(lista.actual);
                    System.out.println("El turno actual ha sido eliminado.");
                    break;
                case 5:
                    System.out.println("¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
        }
    }
}

