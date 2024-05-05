package cl.leno.cajaregistradora.leno.test;

import cl.leno.cajaregistradora.leno.controllers.CajaRegistradora;
import cl.leno.cajaregistradora.leno.objects.Producto;
import cl.leno.cajaregistradora.leno.storage.DataBase;
import cl.leno.cajaregistradora.leno.views.Vista;

/**
 *
 * @author sebas
 */
public class Main {
    public static void main(String[] args) {
        /*DataBase db = new DataBase();
        Producto producto = db.getByIndex(0);
        
        System.out.println(producto);
        
        producto.setNombre("Sabanera");
        producto.setCantidad(10);
        producto.setPrecio(1000);
        
        Producto[] productos = db.getAll();
        for (Producto valor : productos) {
            System.out.println(valor);
        }*/
        
        /*Vista.showHeaderPrincipal();
        Vista.showMenuPrincipal();
        Vista.showGetOpcion();
        int opcion = Vista.getOpcion();
        
        System.out.println("La opción digitada es: " + opcion);*/
        
        CajaRegistradora registradora = new CajaRegistradora();
        registradora.registrador();
    }
}
