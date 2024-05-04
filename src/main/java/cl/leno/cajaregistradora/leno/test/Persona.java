package cl.leno.cajaregistradora.leno.test;

/**
 *
 * @author sebas
 */
public class Persona implements Cloneable{

    public String nombre;
    public int edad;
    
    //Siempre que implementes estre metodo lanza esta excepción para controlar
    //algún posible error.
    public Persona clone()throws CloneNotSupportedException{
        return (Persona) super.clone();
    }
}
