import java.util.Scanner;

public class Main {

    /*
    * BIENVENIDO AL PROYECTO FINAL
    * PROFESOR Giovani A. Sánchez
    *
    *          -INTEGRANTES-
    *   - INTEGRANTE 1
    *   - INTEGRANTE 2
    *   - INTEGRANTE 3
    *   - INTEGRANTE 4 (opcional)
    *
    *           -GRUPO
    *           1SL211 EJEMPLO RECORDAR ELIMINAR    ***********************
    *
    * */

    public static void main(String[] args) {

                //  INSTANCIAS PARA LAS CLASES

        Scanner scanner = new Scanner(System.in);

        Logica_articulos Articulos;

                //  DECLARACION DE VARIABLES LOCALES DEL MAIN

        int opcion = 0;

        try {
            Articulos = new Logica_articulos("Articulos.txt");
        }catch (Exception e){
            System.out.println(e);
        }


                                    // MENU PRINCIPAL
        /*
        * EL MENU PRINCIPAL CONSTA DE MOSTRAR EN PANTALLA UN MENU DE LAS OPCIONES HABILES POR ESCOJER
        * CADA UNA REFLEJARA UNA ACCION POR MEDIO DE LA CLASE CORRESPONDIENTE.
        * */
        
        do {
            System.out.println("\nMenú Principal");
            System.out.println("1. Articulos");
            System.out.println("2. Registro de articulos");
            System.out.println("3. Busqueda de articulos");
            System.out.println("4. Stock de articulos");
            System.out.println("5. Consultas de ventas");
            System.out.println("6. Pedidos");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");

            try {
                opcion = scanner.nextInt();

            } catch (Exception e) {
                System.out.println("\nEntrada inválida. Se esperaba un número");
                opcion = -1;
                scanner.next();     // Limpiar la entrada no válida
            }

            switch (opcion) {
                case 1:                 // <------ ARTICULOS ------>

                    System.out.println("\n\nOpción de Articulos seleccionada.\n");

                    int opcion_sub = 0;

                    // SubMenú de Categorías

                    /*
                    *  ESTE MENU BASA EN RELFEJAR 10 ARTICULOS MINIMOS POR CATEGORIA SELECCIONADA
                    *  POR MEDIO DE UNA TABLA CON FORMATO, DANDO LA INFORMACION DEL PRODUCTO
                    * (Código, Categoría, Ubicación, Nombre, descripción, Costo, Precio Y Stock)
                    *  */

                    do {
                        System.out.println("\nMenú de Categorías");
                        System.out.println("1. Electrónica");
                        System.out.println("2. Ropa");
                        System.out.println("3. Hogar");
                        System.out.println("4. Ferreteria");
                        System.out.println("5. Libros");
                        System.out.println("0. Atrás");
                        System.out.print("Selecciona una opción: ");

                        try {
                            opcion_sub = scanner.nextInt();

                        }catch (Exception e){
                            System.out.println("\nEntrada inválida. Se esperaba un número");
                            opcion_sub = -1;
                            scanner.next();     //Limpiar entrada
                        }

                        switch (opcion_sub) {
                            case 1:
                                System.out.printf("%-10s %-15s %-15s %-20s %-30s %-10s %-10s %-10s%n",
                                        "Codigo", "Categoria", "Ubicacion", "Nombre", "Descripcion", "Costo", "Precio", "Stock");
                                System.out.println("---------------------------------------------------------------------------------------------------------------------------");




                                break;

                            case 2:
                                break;

                            case 3:
                                break;

                            case 4:
                                break;

                            case 5:

                                break;

                            case 0:
                                System.out.println("Volviendo al menú principal...");
                                break;

                            default:
                                System.out.println("Intenta digitar el número de la opción preferida del menú de categorias...");
                        }

                    }while(opcion_sub != 0);



                    break;

                case 2:

                    break;

                case 3:

                    break;

                case 4:

                    break;

                case 5:

                    break;

                case 6:

                    break;

                case 0:                                  // Opcion de salir del programa mas una despedida.
                    System.out.println("\nGracias por usar nuestros servicios");
                    scanner.close();
                    System.exit(0);  // Cerrar el programa
                    break;

                default:
                    System.out.println("Intenta digitar el número de la opción preferida del menú...");
            }

        } while (opcion != 0);

    }
}