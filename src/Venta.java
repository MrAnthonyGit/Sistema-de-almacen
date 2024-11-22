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

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getCantidadVendida() {
        return cantidadVendida;
    }

    public double getMontoTotal() {
        return montoTotal;
    }
}
