public class Pedidos {
    private String codigo;
    private String nombreArticulo;
    private int cantidad;
    private String fechaPedido;
    private double totalPagar;

    // Constructor para inicializar los atributos
    public Pedidos(String codigoArticulo, String nombreArticulo, int cantidad, String fechaPedido, double totalPagar) {
        this.codigo = codigoArticulo;
        this.nombreArticulo = nombreArticulo;
        this.cantidad = cantidad;
        this.fechaPedido = fechaPedido;
        this.totalPagar = totalPagar;
    }

    // Métodos getter para obtener los valores de los atributos
    public String getCodigo() {
        return codigo;
    }

    public String getNombreArticulo() {
        return nombreArticulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getFechaPedido() {
        return fechaPedido;
    }

    public double getTotalPagar() {
        return totalPagar;
    }

}