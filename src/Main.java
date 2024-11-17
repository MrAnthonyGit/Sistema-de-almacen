import java.util.InputMismatchException;
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

        Logica_articulos Articulos = null;
        Resgistrar_Articulos RegistArt = null;

                //  DECLARACION DE VARIABLES LOCALES DEL MAIN

        int opcion = 0, cantidadArticulos = 0;

        String categoria = "";
        int ubicacion = 0;
        String nombre = "";
        String descripcion;
        float costo;
        float precio;
        int stock;

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

                                // IMPRIMIMOS EL ENCABEZADO DE LA TABLA DE LOS ARTICULOS

                                System.out.printf("%-10s %-15s %-15s %-20s %-30s %-10s %-10s %-10s%n",
                                        "Codigo", "Categoria", "Ubicacion", "Nombre", "Descripcion", "Costo", "Precio", "Stock");
                                System.out.println("---------------------------------------------------------------------------------------------------------------------------");

                                /* ESTE BLOQUE DE CODIGO CONSISTE EN SOLICITAR LA LECTURA*/

                                try {
                                    Articulos.reset_Reader();
                                    while (Articulos.leer() != null){

                                        if (Articulos.getCategoria().equalsIgnoreCase("Electronica")){
                                            System.out.printf("%-10s %-15s %-15s %-20s %-30s %-10s %-10s %-10s%n",
                                                    Articulos.getCodigo(), Articulos.getCategoria(), Articulos.getUbicacion(),Articulos.getNombre(),
                                                    Articulos.getDescripcion(), Articulos.getCosto(), Articulos.getPrecio(), Articulos.getStock());
                                        }
                                    }

                                    break;
                                }catch (Exception e){
                                    System.out.println(e);
                                }

                            case 2:
                                System.out.printf("%-10s %-15s %-15s %-20s %-30s %-10s %-10s %-10s%n",
                                        "Codigo", "Categoria", "Ubicacion", "Nombre", "Descripcion", "Costo", "Precio", "Stock");
                                System.out.println("---------------------------------------------------------------------------------------------------------------------------");
                                try {
                                    Articulos.reset_Reader();
                                    while (Articulos.leer() != null){

                                        if (Articulos.getCategoria().equalsIgnoreCase("Ropa")){
                                            System.out.printf("%-10s %-15s %-15s %-20s %-30s %-10s %-10s %-10s%n",
                                                    Articulos.getCodigo(), Articulos.getCategoria(), Articulos.getUbicacion(),Articulos.getNombre(),
                                                    Articulos.getDescripcion(), Articulos.getCosto(), Articulos.getPrecio(), Articulos.getStock());
                                        }
                                    }



                                }catch (Exception e){
                                    System.out.println(e);
                                }

                                break;

                            case 3:
                                System.out.printf("%-10s %-15s %-15s %-20s %-30s %-10s %-10s %-10s%n",
                                        "Codigo", "Categoria", "Ubicacion", "Nombre", "Descripcion", "Costo", "Precio", "Stock");
                                System.out.println("---------------------------------------------------------------------------------------------------------------------------");
                                try {
                                    Articulos.reset_Reader();
                                    while (Articulos.leer() != null){

                                        if (Articulos.getCategoria().equalsIgnoreCase("Hogar")){
                                            System.out.printf("%-10s %-15s %-15s %-20s %-30s %-10s %-10s %-10s%n",
                                                    Articulos.getCodigo(), Articulos.getCategoria(), Articulos.getUbicacion(),Articulos.getNombre(),
                                                    Articulos.getDescripcion(), Articulos.getCosto(), Articulos.getPrecio(), Articulos.getStock());
                                        }
                                    }

                                }catch (Exception e){
                                    System.out.println(e);
                                }

                                break;

                            case 4:
                                System.out.printf("%-10s %-15s %-15s %-20s %-30s %-10s %-10s %-10s%n",
                                        "Codigo", "Categoria", "Ubicacion", "Nombre", "Descripcion", "Costo", "Precio", "Stock");
                                System.out.println("---------------------------------------------------------------------------------------------------------------------------");
                                try {
                                    Articulos.reset_Reader();
                                    while (Articulos.leer() != null){

                                        if (Articulos.getCategoria().equalsIgnoreCase("Ferreteria")){
                                            System.out.printf("%-10s %-15s %-15s %-20s %-30s %-10s %-10s %-10s%n",
                                                    Articulos.getCodigo(), Articulos.getCategoria(), Articulos.getUbicacion(),Articulos.getNombre(),
                                                    Articulos.getDescripcion(), Articulos.getCosto(), Articulos.getPrecio(), Articulos.getStock());
                                        }
                                    }

                                }catch (Exception e){
                                    System.out.println(e);
                                }

                                break;

                            case 5:
                                System.out.printf("%-10s %-15s %-15s %-20s %-30s %-10s %-10s %-10s%n",
                                        "Codigo", "Categoria", "Ubicacion", "Nombre", "Descripcion", "Costo", "Precio", "Stock");
                                System.out.println("---------------------------------------------------------------------------------------------------------------------------");

                                try {
                                    Articulos.reset_Reader();
                                    while (Articulos.leer() != null){

                                        if (Articulos.getCategoria().equalsIgnoreCase("Libros")){
                                            System.out.printf("%-10s %-15s %-15s %-20s %-30s %-10s %-10s %-10s%n",
                                                    Articulos.getCodigo(), Articulos.getCategoria(), Articulos.getUbicacion(),Articulos.getNombre(),
                                                    Articulos.getDescripcion(), Articulos.getCosto(), Articulos.getPrecio(), Articulos.getStock());
                                        }
                                    }

                                }catch (Exception e){
                                    System.out.println(e);
                                }

                                break;

                            case 0:
                                System.out.println("Volviendo al menú principal...");
                                break;

                            default:
                                System.out.println("Intenta digitar el número de la opción preferida del menú de categorias...");
                        }

                    }while(opcion_sub != 0);



                    break;

                case 2:         //      <------ REGISTRO DE ARTICULOS ------>

                    System.out.println("\nOpcion de registrar articulos seleccionadas\n");

                    while (true){       // Bucle controlador de errores
                        System.out.println("¿Cuantos articulos desea registrar?\n" +
                                "Si quiere ir al menu principal, digite el numero: 0");
                        try {
                            cantidadArticulos = scanner.nextInt();         // Entrada solicitada al usuario
                        } catch (Exception e) {
                            System.out.println("Error... Intente digitar un numero. CodErr: " + e);
                            scanner.next();  // Limpia la entrada incorrecta del scanner
                            continue;        // Vuelve a preguntar
                        }

                        if (cantidadArticulos >= 0) {
                            break;  // Continúa con el resto del código si es un número positivo
                        } else {
                            System.out.println("Debe de ingresar un numero positivo.");
                        }
                    }

                    // validamos si el usuario escogio salir al menu principal...
                    if (cantidadArticulos == 0) {
                        System.out.println("Volviendo al menú principal...");
                        break;  // Sale del método o del switch para regresar al menú principal
                    }

                    System.out.println("\nA continuacion usted debera escribir y escoger en orden establecido los datos del articulo");

                    // Bucle para registrar N cantidad de productos
                    for (int i = 1 ; i <= cantidadArticulos; i++) {
                                    // ABRIMOS EL ARCHIVO PARA REGISTRAR LOS ARTICULOS
                        try {
                            RegistArt = new Resgistrar_Articulos("Articulos.txt");
                        }catch (Exception e){
                            System.out.println(e);
                        }

                                                        //  CATEGORIA

                        while (true) {
                            System.out.println("Categorías disponibles: Electrónica, Ropa, Hogar, Ferretería, Libros.");
                            System.out.print("\nArticulo No." + i + " Categoría: ");

                            try {
                                categoria = scanner.next();  // Leer entrada de usuario
                            } catch (Exception e) {
                                System.out.println("Error... Intente digitar una categoría válida. CodErr: " + e);
                                continue;
                            }

                            if (RegistArt.validar_categoria(categoria)) {       // LLamamos al metodo para validar la categoria
                                scanner.nextLine(); // Limpiar el buffer después de nextLine()
                                break;  // Salir del bucle while si la categoría es válida
                            } else {
                                System.out.println("La categoría: \"" + categoria + "\" no existe. Por favor, ingrese una de las opciones mostradas.");
                            }
                        }

                                                        //  UBICACION
                        while (true) {
                            System.out.println("\nDigite el numero de la bodega en la que se encuentra el producto\n" +
                                    "contamos con la Bodega 1, 2 y 3\n");
                            System.out.print("\nArticulo No." + i + " Bodega No. : ");

                            try {
                                ubicacion = scanner.nextInt();  // Leer entrada de usuario
                            } catch (InputMismatchException e) {
                                System.out.println("Error... Intente digitar un numero de bodega válida. CodErr: " + e);
                                scanner.nextLine(); // Limpiar el buffer después de nextInt()
                            }


                            if (RegistArt.validar_bodega(ubicacion)) {       // LLamamos al metodo para validar la bodega
                                scanner.nextLine(); // Limpiar el buffer después de nextInt()
                                break;  // Salir del bucle while si la ubicacion de la bodega es válida
                            } else {
                                System.out.println("La bodega No." + ubicacion + " no existe. Por favor, ingrese una de las opciones mostradas.\n");
                            }
                        }

                                                        //  NOMBRE

                        while (true) {
                            System.out.println("\nDigite el nombre del articulo a registrar");
                            System.out.print("\nArticulo No." + i + " Nombre: ");

                            try {
                                nombre = scanner.nextLine();  // Leer entrada de usuario
                            } catch (Exception e) {
                                System.out.println("Error... Intente digitar un nombre válido. CodErr: " + e);
                                scanner.nextLine(); // Limpiar el buffer después de nextInt()
                            }

                            if (nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {  // Condición para que solo se permitan letras
                                scanner.nextLine(); // Limpiar el buffer después de nextline()
                                break;  // Si el nombre es válido, salimos del bucle while
                            } else {
                                System.out.println("Nombre inválido. Solo se permiten letras. Inténtalo de nuevo.");
                            }
                        }

                                                        //  DESCRIPCION

                        while (true) {
                            System.out.println("\nDigite la descripción del artículo a registrar");
                            System.out.print("\nArtículo No." + i + " Descripción: ");

                            try {
                                descripcion = scanner.nextLine();  // Leer entrada de usuario
                            } catch (Exception e) {
                                System.out.println("Error... Intente digitar una descripción válida. CodErr: " + e);
                                scanner.nextLine(); // Limpiar el buffer después de nextInt()
                                continue;
                            }

                            // Validación: que la descripción no contenga punto y coma
                            if (descripcion.contains(";")) {
                                System.out.println("La descripción no puede contener el carácter ';'. Por favor, ingrese una descripción válida.");
                            } else if (descripcion.length() > 0 && descripcion.length() <= 255) {  // Validación de longitud
                                scanner.nextLine(); // Limpiar el buffer después de nextLine()
                                break;  // Si la descripción es válida, salir del bucle
                            } else {
                                System.out.println("Descripción inválida. Debe contener entre 1 y 255 caracteres.");
                            }
                        }

                                                        //  COSTO

                        while (true) {
                            System.out.println("\nDigite el costo del artículo (use un número decimal)");
                            System.out.print("\nArtículo No." + i + " Costo: ");

                            try {
                                costo = scanner.nextFloat();  // Leer entrada de usuario
                                if (costo >= 0) {
                                    scanner.nextLine(); // Limpiar el buffer después de nextFloat()
                                    break;  // Salir si el costo es válido
                                }
                                else System.out.println("Costo inválido. Debe ser un número positivo.");
                            } catch (InputMismatchException e) {
                                System.out.println("Error... Intente ingresar un número decimal. CodErr: " + e);
                                scanner.nextLine();  // Limpiar el buffer después de nextFloat()
                            }
                        }

                                                        // PRECIO

                        while (true) {
                            System.out.println("\nDigite el precio del artículo (use un número decimal)");
                            System.out.print("\nArtículo No." + i + " Precio: ");

                            try {
                                precio = scanner.nextFloat(); // Leer entrada de usuario
                                if (precio >= costo) {
                                    scanner.nextLine(); // Limpiar el buffer después de nextFloat()
                                    break; // Salir si el precio es válido
                                }
                                else System.out.println("Precio inválido. Debe ser mayor o igual al costo.");
                            } catch (InputMismatchException e) {
                                System.out.println("Error... Intente ingresar un número decimal. CodErr: " + e);
                                scanner.nextLine(); // Limpiar entrada no válida
                            }
                        }

                                                        // STOCK

                        while (true) {
                            System.out.println("\nDigite el stock del artículo (cantidad disponible)");
                            System.out.print("\nArtículo No." + i + " Stock: ");

                            try {
                                stock = scanner.nextInt();  // Leer entrada de usuario
                                if (stock >= 0) {
                                    scanner.nextLine(); // Limpiar el buffer después de nextInt()
                                    break;  // Salir si el stock es válido
                                }
                                else System.out.println("Stock inválido. Debe ser un número entero positivo.");
                            } catch (InputMismatchException e) {
                                System.out.println("Error... Intente ingresar un número entero. CodErr: " + e);
                                scanner.nextLine();  // Limpiar el buffer después de nextInt()
                            }
                        }

                                               //  REGISTRANDO EL ARTICULO

                                // LLamamos al metodo Asignar() para dale valor a los atributos de la clase para
                                // posteriormente registrarlos en el archivo llamado Articulos.txt
                        RegistArt.Asignar(categoria, ubicacion, nombre, descripcion, costo, precio, stock);

                        // Se mandan a registrar el articulos junto sus datos en el archivo
                        try{
                            RegistArt.Registrar_Articulo();
                            System.out.println("\t\t\n\nARTICULO REGISTRADO CON EXITO!\n");
                            System.out.println("\nArtículo registrado:");
                            System.out.printf("%-10s %-15s %-15s %-20s %-30s %-10s %-10s %-10s%n", "Codigo", "Categoria", "Ubicacion", "Nombre", "Descripcion", "Costo", "Precio", "Stock");
                            System.out.println("---------------------------------------------------------------------------------------------------------------------------");
                            System.out.printf("%-10s %-15s %-15s %-20s %-30s %-10.2f %-10.2f %-10d%n",
                                    RegistArt.getCodigo(), RegistArt.getCategoria(), RegistArt.getUbicacion(), RegistArt.getNombre(),
                                    RegistArt.getDescripcion(), RegistArt.getCosto(), RegistArt.getPrecio(), RegistArt.getStock());
                            System.out.println("");

                            RegistArt.cerrar();

                        } catch (Exception e) {
                            System.out.println("Error en la seguridad del archivo, verifique que pueda ser modificado... " + e);
                        }

                    }

                    break;   // Fin del caso2 del switch de registrar articulos

                case 3:         // Caso de Busqueda de articulo

                    System.out.println("Ha seleccionado la seccion de Busqueda de articulos");

                    System.out.println("\n\n asd");

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