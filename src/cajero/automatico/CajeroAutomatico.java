package cajero.automatico;

import java.util.Scanner;

public class CajeroAutomatico {

    public static void main(String[] args) {

        Scanner x = new Scanner(System.in);

        int i = 0, error = 0, numerorandom, retiro, consignacion;
        int totalAportes = 0, conts = 0;
        String clave = "alexan.perez", dig;
        String opcion, semillero;
        
        numerorandom = (int) (Math.random() * 10 + 1) * 100000;
        boolean salir = false;

        System.out.println("BIENVENIDO AL CAJERO AUTOMATICO");
        System.out.println("----------------------------------");
        
        while (i < 3) {
            System.out.println("Digite su contraseña --- intento: " + (i + 1));
            dig = x.next();
            System.out.println("-----------------------------------------------------");
            
            if (dig.equalsIgnoreCase(clave)) {
                break;
            } else {
                error++;
                i++;

                if (i < 3) {
                    System.out.println("Su contraseña es incorrecta, por favor escríbala otra vez.");
                } else {
                    System.out.println("Su contraseña es incorrecta, su cuenta ha sido bloqueada.");
                    return; 
                }
            }
        }

        System.out.println("BIENVENIDO AL CAJERO AUTOMATICO, YA PUEDE UTILIZAR NUESTRO SERVICIO.\n");

        while (!salir) {

            System.out.println("\n******** SELECCIONAR TRANSACCION A REALIZAR ***********");
            System.out.println("a) Consignar\nb) Retirar\nc) Consultar el saldo\nd) SALIR");
            System.out.print("Seleccione una opción: ");

            opcion = x.next().toLowerCase();

            switch (opcion) {

                case "a":
                    System.out.println("\n¿Cuál es el valor de la consignación?");
                    System.out.println("Recuerde que se cobra una tarifa de $5,000 por consignación.");
                    consignacion = x.nextInt();

                    int descuentoBase = 5000;
                    int aporteSemillero = 0;

                    System.out.println("¿Desea hacer un aporte voluntario de $1,000 al SEMILLERO DE PROGRAMACION? (SI/NO)");
                    semillero = x.next();

                    if (semillero.equalsIgnoreCase("SI")) {
                        aporteSemillero = 1000;
                        totalAportes += aporteSemillero;
                        conts++;
                    }

                    numerorandom += (consignacion - descuentoBase - aporteSemillero);

                    System.out.println("//////////////////////////////////////////////////////////////");
                    System.out.println("Transacción EXITOSA. Consignación: $" + consignacion);
                    System.out.println("Nuevo saldo en la cuenta: $" + numerorandom);
                    System.out.println("//////////////////////////////////////////////////////////////");
                    break;

                case "b":
                    System.out.println("\n¿Cuál es el valor del retiro?");
                    System.out.println("Recuerde que se cobra una tarifa de $5,000 por retiro.");
                    retiro = x.nextInt();

                    int costoTotalRetiro = retiro + 5000;
 
                    if (costoTotalRetiro <= numerorandom) {
                        numerorandom -= costoTotalRetiro;
                        System.out.println("Transacción VÁLIDA. Retiro realizado: $" + retiro);
                        System.out.println("Total saldo restante: $" + numerorandom);
                    } else {
                        System.out.println("Transacción INVÁLIDA. Saldo insuficiente para realizar el retiro de $" 
                                           + retiro + " (más $5,000 de comisión).");
                        System.out.println("////////////////////////////////////////////////////////////////");
                    }
                    break;

                case "c":
                    System.out.println("\nSu saldo actual es: $" + numerorandom);
                    break;

                case "d":
                    salir = true;
                    break;

                default:
                    System.out.println("\nOpción no válida. Por favor intente de nuevo.");
                    System.out.println("-------------------------------------------------------------");
                    break;
            }
        }

        System.out.println("\n---------------------------------------------------------------------------------------");
        System.out.println("Se realizó(aron) " + conts + " aporte(s) al SEMILLERO DE PROGRAMACIÓN por un total de $" + totalAportes);
        System.out.println("Finalizando operaciones en el cajero automático...");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("*********** CÓDIGO REALIZADO POR ALEXANDER PEREZ CORREA Y JUAN DAVID RAMIREZ ************");
    }
}