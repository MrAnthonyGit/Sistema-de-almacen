
import java.io.*;

public class Logica_articulos {
    /*
    *   CLASE DE ARTICULOS, AQUI ESTARAN LOS ATRIBUTOS PRIVADOS Y METODOS QUE SE USARAN EN LA CLASE MAIN
    * */

    private String codigo;
    private String categoria;
    private String ubicacion;
    private String nombre;
    private String descripcion;
    private float costo;
    private float precio;
    private int stock;

    private String linea = "";


    private String Nombre_Archivo;
    private FileReader fr;
    private FileWriter fw;
    private BufferedReader br;

    // El metodo constructor inicializa el archivo almacenando su nombre e instanciando los objetos del FileReader y BufferedReader


    public Logica_articulos(String nombreArch) throws Exception{

        try {
            this.Nombre_Archivo = nombreArch;

            fr = new FileReader(nombreArch);
            br = new BufferedReader(fr);

        }catch(FileNotFoundException e) {throw e;}

    }
    /*
    *   leer() consiste en almacenar los datos del articulos desde el archivo .txt
    *   linea por linea dependiendo de cuantas veces se llame, ya que este salta de linea a penas termina un renglon
    *   gracias al bufferedReader y si metodo readLine().
    * */

    public String leer() throws Exception {

        final String separa = ";";

        try {
            linea = br.readLine();
        } catch (IOException ex) {
            throw ex;
        }

        if (linea != null) {
            String[] campos = linea.split(separa);      // separamos los campos escritos del archivo por medio de una coma ( , )
            if (campos.length == 7) {           // Condicion para porder almacenar los campos en los atributos de la clase.
                codigo = campos[0];
                categoria = campos[1];
                ubicacion = campos[2];
                nombre = campos[3];
                descripcion = campos[4];
                costo = Float.parseFloat(campos[5]);
                precio = Float.parseFloat(campos[6]);
                stock = Integer.parseInt(campos[7]);
            } else {
                throw new Exception("Solo estamos considerando 8 campos para un articulo");
            }
        }else {
            System.out.println("no hay elemento del articulos en el .txt");
        }
        return linea;

    }

    public String Mostrar_Articulos_Electronica() throws Exception {
        leer();

        if (linea == null) {
            throw new Exception("No hay mas articulos disponibles");
        }
        if (categoria.equalsIgnoreCase("Electronica")) {

        }
        return null;
    }



    public void cerrar() throws Exception {
        try {
            br.close();
        }catch (IOException y){throw y;}
    }

    // Todos los metodos getters para consultar los atributos provenientes de Articulos.txt

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

    public String getNombre_Archivo() {
        return Nombre_Archivo;
    }

}
