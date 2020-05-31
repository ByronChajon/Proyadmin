
package entidadesproyecto;

public class Venta {
    
    private int venta;
    private Cliente cliente;
    private String fecha;
    private double total;
    private Mercaderia mercaderia;

    public Mercaderia getMercaderia() {
        return mercaderia;
    }

    public void setMercaderia(Mercaderia mercaderia) {
        this.mercaderia = mercaderia;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getVenta() {
        return venta;
    }

    public void setVenta(int venta) {
        this.venta = venta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
}
