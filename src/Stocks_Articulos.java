import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Stocks_Articulos {
    /* el proposito de esta clase es mostrar por categoria todos los productos
        Codigo, nombre y Stock

        o bien mostrar todos los articulos con su codigo, nombre y Stock,
        señalar las unidades que posean menos de 10 en stock y mostrar un total

    */

    private String codigo;
    private String categoria;
    private String nombre;
    private int stock;

    private String linea;

    private String Nombre_Archivo;
    private FileReader fr;
    private BufferedReader br;

    public Stocks_Articulos(String nombreArch) throws Exception{

        try {
            this.Nombre_Archivo = nombreArch;
            Logica_articulos LA = new Logica_articulos("Articulos.txt");

            fr = new FileReader(nombreArch);
            br = new BufferedReader(fr);

        }catch(FileNotFoundException e) {throw e;}

    }

    public String busqueda_Stock() throws Exception{

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
        nombre = campos[3];
        stock = Integer.parseInt(campos[7]);

        return linea;

    }

    public void reabrir_Archivo() throws Exception {
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

    public String getCodigo() {
        return codigo;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public int getStock() {
        return stock;
    }
}
