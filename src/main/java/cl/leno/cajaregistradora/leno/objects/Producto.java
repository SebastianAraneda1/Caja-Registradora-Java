package cl.leno.cajaregistradora.leno.objects;

/**
 *
 * @author sebas
 */
public abstract class Producto {

    private String nombre;
    private int cantidad;
    private double precio;

    public Producto() {}
    
    public Producto(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        if (cantidad < 0){
            System.out.println("No puede asignar cantidad negativa");
            return;
        }
        
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if (precio < 0){
            System.out.println("No puede colocar precio negativo");
            return;
        }
        this.precio = precio;
    }

    @Override
    public String toString(){
        return this.nombre + " - " + this.cantidad + " - " + this.precio;
    }
}