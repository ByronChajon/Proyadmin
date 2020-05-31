
package entidadesproyecto;

public class Detalleo {
    private int detalle;
    private int unidades;
    private Mercaderiao codigoproducto;  
    private double subtotal;

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

    public Mercaderiao getCodigoproducto() {
        return codigoproducto;
    }

    public void setCodigoproducto(Mercaderiao codigoproducto) {
        this.codigoproducto = codigoproducto;
    }
  
}
