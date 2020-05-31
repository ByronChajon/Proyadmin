
package entidadesproyecto;

public class Detalle {
    
    private int detalle;
    private Venta venta;
    private int unidades;
    private Mercaderia codigoproducto;
    private double subtotal;

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public int getDetalle() {
        return detalle;
    }

    public void setDetalle(int detalle) {
        this.detalle = detalle;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public Mercaderia getCodigoproducto() {
        return codigoproducto;
    }

    public void setCodigoproducto(Mercaderia codigoproducto) {
        this.codigoproducto = codigoproducto;
    }
    
    
}
