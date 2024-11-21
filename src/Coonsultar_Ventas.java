import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Coonsultar_Ventas {

    private String codigo;
    private String nombre;
    private String categoria;
    private int vendidos;
    private double precio;

    private String Nombre_Archivo = "Ventas.txt";
    private FileReader fr;
    private BufferedReader br;

    public Coonsultar_Ventas() throws Exception{
        try {
            fr = new FileReader(Nombre_Archivo);
            br = new BufferedReader(fr);

        }catch(FileNotFoundException e) {throw e;}

    }

}
