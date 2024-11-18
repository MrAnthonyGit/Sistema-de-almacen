import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Busqueda_Articulos {
    private String codigo;
    private String categoria;
    private String ubicacion;
    private String nombre;
    private String descripcion;
    private float costo;
    private float precio;
    private int stock;

    private String linea = "";

    private Logica_articulos logica_articulos;

    private String Nombre_Archivo;
    private FileReader fr;
    private BufferedReader br;

    // El metodo constructor inicializa el archivo almacenando su nombre e
    // instanciando los objetos del FileReader y BufferedReader

    public Busqueda_Articulos(String nombreArch) throws Exception{

        try {
            this.Nombre_Archivo = nombreArch;
            this.logica_articulos = new Logica_articulos(nombreArch); // Asignación a la variable de instancia

            fr = new FileReader(nombreArch);
            br = new BufferedReader(fr);

        }catch(FileNotFoundException e) {throw e;}

    }

    public boolean busqueda(String Codigo_Nombre_Descrpcion) throws Exception{
        reabrir_Archivo();
        while((linea = br.readLine()) != null){         // PENDIENTE CORREGIR PUNTERO

            if (linea.trim().isEmpty()) {       //Validamos si hay lineas vacias
                continue;           // Ignorar líneas vacías
            }

            String[] Datos = linea.split(";");

            codigo = Datos[0];
            nombre = Datos[3];
            descripcion = Datos[4];

            if (codigo.equalsIgnoreCase(Codigo_Nombre_Descrpcion) ||
                    nombre.equalsIgnoreCase(Codigo_Nombre_Descrpcion) ||
                    descripcion.equalsIgnoreCase(Codigo_Nombre_Descrpcion)) {
                leer_Linea(linea);
                return true;
            }
        }
        return false;
    }

    public void leer_Linea(String linea){
        String[] data = linea.split(";");
        categoria = data[1];
        ubicacion = data[2];
        costo = Float.parseFloat(data[5]);
        precio = Float.parseFloat(data[6]);
        stock = Integer.parseInt(data[7]);
    }

    public void reabrir_Archivo() throws Exception {
        try {
            fr = new FileReader(Nombre_Archivo);  // Reabre el archivo
            br = new BufferedReader(fr);
        } catch (FileNotFoundException e) {
            throw new Exception("No se puede volver a encontrar el archivo.");
        }
    }

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
