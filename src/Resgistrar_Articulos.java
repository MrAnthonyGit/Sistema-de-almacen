import java.io.*;

public class Resgistrar_Articulos {

    /*
     *   CLASE PARA REGISTRAR ARTICULOS, AQUI ESTARAN LOS ATRIBUTOS PRIVADOS Y
     *      METODOS QUE SE USARAN EN LA CLASE MAIN
     * */

    private Logica_articulos logica_articulos;    // Invocamos la clase Logica_Articulos para utilizar un metodo de esa clase

    private String codigo;
    private String categoria;
    private String ubicacion = "bodega";
    private String nombre;
    private String descripcion;
    private float costo;
    private float precio;
    private int stock;

    private String Nombre_Archivo;
    private FileWriter fw;
    private PrintWriter pr;

    private String[] categorias = {"Electronica","Ropa","Hogar","Ferreteria","Libros"};
    private int[] ubicaciones = {1, 2, 3};

    public Resgistrar_Articulos(String nombreArch) throws Exception{
        try {
            this.Nombre_Archivo = nombreArch;

            // Inicializas logica_articulos correctamente para que sea accesible en toda la clase
            this.logica_articulos = new Logica_articulos(nombreArch); // Asignación a la variable de instancia

            fw = new FileWriter(nombreArch, true);
            pr = new PrintWriter(fw);

        } catch (FileNotFoundException e) {
            throw new Exception("Mensaje para el usuario:  El archivo no existe en la ruta indicada" +
                    "\nMensaje para el programador:  " + e);
        }
    }

    public void Asignar(String categoria, int ubicacion, String nombre, String descripcion, float costo, float precio, int stock){
        this.categoria = categoria;
        this.ubicacion += ubicacion;  // utilizamos += para fucionar la palabra "bodega" con el numero que se le mandara como parametro a ubicacion
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costo = costo;
        this.precio = precio;
        this.stock = stock;
    }


    public void Registrar_Articulo() throws Exception{

        this.codigo = logica_articulos.generar_Codigo_Unico();        // llamamos el metodo de generar codigo que sea unico entre todos los articulos

        try {
            // Aqui se mandan a escribir en el archivo.txt el articulo con sus datos
            pr.println("\n" + codigo + ";"
                        + categoria + ";"
                        + ubicacion + ";"
                        + nombre + ";"
                        + descripcion + ";"
                        + costo + ";"
                        + precio + ";"
                        + stock);
            }catch (SecurityException e){       // la clase printWriter conlleva exepciones como el de la seguridad del archivo
                throw e;
            }

    }

    public boolean validar_categoria(String categoria){

        for (String cat : categorias) {
            if (categoria.equalsIgnoreCase(cat)) {
                return true;
            }
        }

        return false;
    }

    public boolean validar_bodega(int ubicacion){

        for (int bod : ubicaciones) {
            if (ubicacion == bod) {
                return true;
            }
        }

        return false;
    }

    public void cerrar() throws Exception {
        try {
            fw.close();
            pr.close();
        }catch (IOException e) {throw e;}
    }

    // METODOS GETTERS PARA OBTENER LA INFORMACION DE LOS ATRIBUTOS

    public String getCodigo() {
        return codigo;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public float getCosto() {
        return costo;
    }

    public float getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

}
