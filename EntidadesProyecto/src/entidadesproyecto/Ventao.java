
package entidadesproyecto;

public class Ventao {
    private int venta;
    private Clienteo cliente;
    private String fecha;
    private Detalleo detalle;
    private double total;

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Detalleo getDetalle() {
        return detalle;
    }

    public void setDetalle(Detalleo detalle) {
        this.detalle = detalle;
    }

    public int getVenta() {
        return venta;
    }

    public void setVenta(int venta) {
        this.venta = venta;
    }

    public Clienteo getCliente() {
        return cliente;
    }

    public void setCliente(Clienteo cliente) {
        this.cliente = cliente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
}
