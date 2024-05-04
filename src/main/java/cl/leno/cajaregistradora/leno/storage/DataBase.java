package cl.leno.cajaregistradora.leno.storage;

import cl.leno.cajaregistradora.leno.objects.Arroz;
import cl.leno.cajaregistradora.leno.objects.Carne;
import cl.leno.cajaregistradora.leno.objects.Papa;
import cl.leno.cajaregistradora.leno.objects.Producto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sebas
 */
public class DataBase {

    private Producto[] productos;
    private List<Producto> compras;
    private List<Producto> ventas;

    public DataBase() {
        productos = new Producto[3];
        Producto papa = new Papa("Papa Frita");
        Producto arroz = new Arroz("Miraflores");
        Producto carne = new Carne("Lomo");

        productos[0] = papa;
        productos[1] = arroz;
        productos[2] = carne;

        compras = new ArrayList<>();
        ventas = new ArrayList<>();
    }

    public Producto getByIndex(int i) {
        if (i < 0 || i > 2) {
            System.out.println("Índice no válido");
            return null;
        }
        Producto resultado = null;
        try{
            resultado = productos[i].clone();
        }catch(CloneNotSupportedException cnse){
            System.out.println(cnse);
        }
        
        return resultado;
    }

    public Producto[] getAll() {
        Producto[] resultado = new Producto[3];
        try {
            resultado[0] = productos[0].clone();
            resultado[1] = productos[1].clone();
            resultado[2] = productos[2].clone();
        } catch (CloneNotSupportedException cnse) {
            System.out.println(cnse);
        }
        return resultado;
    }

    public void comprar(Producto producto){
        Producto temporal;
        switch(producto.getClass().getSimpleName()){
            case "Papa":
                temporal = productos[0];
                break;
            case "Arroz":
                temporal = productos[1];
                break;
            case "Carne":
                temporal = productos[2];
                break;
            default:
                System.out.println("No valido");
                return;
        }
        
        //El producto que se tiene temporalmente, le aumentara su cantidad
        temporal.setCantidad(temporal.getCantidad() + producto.getCantidad());
        temporal.setPrecio(producto.getPrecio());
        compras.add(producto);
    }

    public void vender(Producto producto){
        Producto temporal;
        switch(producto.getClass().getSimpleName()){
            case "Papa":
                temporal = productos[0];
                break;
            case "Arroz":
                temporal = productos[1];
                break;
            case "Carne":
                temporal = productos[2];
                break;
            default:
                System.out.println("No valido");
                return;
        }

        //El producto que se tiene temporalmente, le aumentara su cantidad
        temporal.setCantidad(temporal.getCantidad() - producto.getCantidad());
        producto.setPrecio(temporal.getPrecio() * 1.25);
        ventas.add(producto);
    }
    
    public List<Producto> getCompras(){
        return compras;
    }
    
    public List<Producto> getVentas(){
        return ventas;
    }
}
