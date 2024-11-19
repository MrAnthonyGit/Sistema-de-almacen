
import java.io.*;
import java.util.Random;

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

                                // si no hay más líneas por leer retornamos
        if (linea == null) {
            return null;
        }

        String[] campos = linea.split(separa);  // Separamos los campos por punto y coma (;)

                            // Verificación de la cantidad de campos
        if (campos.length != 8) {
            throw new Exception("Solo estamos considerando 8 campos para un articulo");
        }

                                // Asignación de valores a los atributos
        codigo = campos[0];
        categoria = campos[1];
        ubicacion = campos[2];
        nombre = campos[3];
        descripcion = campos[4];
        costo = Float.parseFloat(campos[5]);
        precio = Float.parseFloat(campos[6]);
        stock = Integer.parseInt(campos[7]);

        return linea;
    }

    // Este metodo junto con otros dos metodos mas se relacionan
    // para generar un codigo en la clase Registrar_Articulo para el articulo registrado
    public String generar_Codigo_Unico() throws IOException {
        String codigo;
        boolean esUnico;

        do {
            codigo = "ABC" + generar_Numero_Aleatorio(100, 999); // Genera el código de la forma "ABC123"
            esUnico = verificar_Codigo_Unico(codigo);
        } while (!esUnico);

        return codigo;
    }

    // Genera un número aleatorio en el rango especificado
    public int generar_Numero_Aleatorio(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }


    // Verifica si existe el codigo generado con los que ya estan registrados.
    private boolean verificar_Codigo_Unico(String codigo) throws IOException {
        try {
            reset_Reader();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        String linea;

        while ((linea = br.readLine()) != null) {
            String[] campos = linea.split(";");
            if (campos[0].equals(codigo)) {         // Aqui valida si el código está en la primera posición
                return false;
            }
        }

        return true;
    }

        // Reser_Reader() re-abre el archivo para volver a leer el archivo
    public void reset_Reader() throws Exception {
        try {
            fr = new FileReader(Nombre_Archivo);  // Reabre el archivo
            br = new BufferedReader(fr);
        } catch (FileNotFoundException e) {
            throw new Exception("No se puede volver a encontrar el archivo.");
        }
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
