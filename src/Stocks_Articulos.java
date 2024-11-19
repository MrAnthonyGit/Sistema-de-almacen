import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

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

    public boolean busqueda(String Codigo_Nombre_Descrpcion) throws Exception{
        reabrir_Archivo();
        while((linea = br.readLine()) != null){         // PENDIENTE CORREGIR PUNTERO

            if (linea.trim().isEmpty()) {       //Validamos si hay lineas vacias
                continue;           // Ignorar líneas vacías
            }

            String[] Datos = linea.split(";");

            codigo = Datos[0];
            nombre = Datos[3];
            categoria = Datos[4];

            if (codigo.equalsIgnoreCase(Codigo_Nombre_Descrpcion) ||
                    nombre.equalsIgnoreCase(Codigo_Nombre_Descrpcion) ||
                    descripcion.equalsIgnoreCase(Codigo_Nombre_Descrpcion)) {
                leer_Linea(linea);
                return true;
            }
        }
        return false;
    }

    public void reabrir_Archivo() throws Exception {
        try {
            fr = new FileReader(Nombre_Archivo);  // Reabre el archivo
            br = new BufferedReader(fr);
        } catch (FileNotFoundException e) {
            throw new Exception("No se puede volver a encontrar el archivo.");
        }
    }


}
