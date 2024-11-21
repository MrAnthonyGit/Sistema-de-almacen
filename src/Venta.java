public class Venta {
        String codigo;
        String nombre;
        String categoria;
        int cantidadVendida;
        double montoTotal;

        public Venta(String codigo, String nombre, String categoria, int cantidadVendida, double montoTotal) {
            this.codigo = codigo;
            this.nombre = nombre;
            this.categoria = categoria;
            this.cantidadVendida = cantidadVendida;
            this.montoTotal = montoTotal;
        }
    }
