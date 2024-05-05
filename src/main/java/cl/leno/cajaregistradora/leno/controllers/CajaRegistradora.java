package cl.leno.cajaregistradora.leno.controllers;

import cl.leno.cajaregistradora.leno.objects.Arroz;
import cl.leno.cajaregistradora.leno.objects.Carne;
import cl.leno.cajaregistradora.leno.objects.Papa;
import cl.leno.cajaregistradora.leno.objects.Producto;
import cl.leno.cajaregistradora.leno.storage.DataBase;
import cl.leno.cajaregistradora.leno.views.Vista;
import java.util.List;

/**
 *
 * @author sebas
 */
public class CajaRegistradora {
    private DataBase database;
    
    public CajaRegistradora() {
        database = new DataBase();
    }
    
    //Inicia todo el proceso de la caja
    public void registrador(){
        int opcion;
        
        do{
            Vista.showHeaderPrincipal();
            Vista.showMenuPrincipal();
            Vista.showGetOpcion();
            opcion = Vista.getOpcion();
            switch(opcion){
                case 1:
                    comprar();
                    break;
                case 2:
                    vender();
                    break;
                case 3:
                    mostrarStock();
                    break;
                case 4:
                    mostrarCompras();
                    break;
                case 5:
                    mostrarVentas();
                    break;
                case 6:
                    System.out.println("Hasta pronto!!");
                    System.exit(0);
                    break;
                default:
                    Vista.opcionInvalida();
            }
            
        }while(opcion >= 1 || opcion <= 6);
        
    }
    
    private void comprar(){
        Vista.showCompraHeader();
        int opcion;
        
        do {
            Vista.showGetOpcion();
            opcion = Vista.getOpcion();
            if(opcion >= 1 && opcion <= 3){
                comprarProducto(opcion);
            } else if(opcion == 4){
                Vista.volver("Compras");
            }else{
                Vista.opcionInvalida();
                return;
            }
        } while (opcion < 1 || opcion > 4);
    }
    
    private void comprarProducto(int opcion){
        Producto producto = null;
        switch(opcion){
            case 1:
                producto = new Papa("Papa Frita");
                break;
            case 2:
                producto = new Arroz("Miraflores");
                break;
            case 3:
                producto = new Carne("Lomo");
                break;
            default:
                Vista.opcionInvalida();
        }
        Vista.showGetCantidad();
        int cantidad = Vista.getCantidad();
        
        Vista.showGetPrecio();
        double precio = Vista.getPrecio();
        
        producto.setCantidad(cantidad);
        producto.setPrecio(precio);
        
        database.comprar(producto);
        
    }
    
    private void mostrarStock(){
        Vista.showInventarioHeader();
        Vista.mostrarItemsStock(database.getAll());
        Vista.showAnyKey();
        Vista.getOpcion();
    }
    
    private void vender(){
        Vista.showVentaHeader();
        int opcion;
        do {
            Vista.showGetOpcion();
            opcion = Vista.getOpcion();
            if(opcion >= 1 && opcion <= 3){
                venderProducto(opcion);
            } else if(opcion == 4){
                Vista.volver("Ventas");
            }else{
                Vista.opcionInvalida();
                return;
            }
        } while (opcion < 1 || opcion > 4);
    }   
 
        
    private void venderProducto(int opcion){
        Producto producto = null;
        if(opcion < 1 || opcion > 3){
            Vista.opcionInvalida();
            return;
        }
        
        producto = database.getByIndex(opcion - 1);
        
        Vista.showGetCantidad();
        int cantidad = Vista.getCantidad();
        
        if(producto.getCantidad() < cantidad ){
            System.out.println("La cantidad no es valida");
            return;
        }
        producto.setCantidad(cantidad);
        database.vender(producto);
        
    }

    private void mostrarCompras(){
        List<Producto> listado = database.getCompras();
        Vista.showListaComprasHeader();
        Vista.mostrarCompras(listado);
        Vista.showAnyKey();
        Vista.getOpcion();
    }
    
    private void mostrarVentas(){
        List<Producto> listado = database.getVentas();
        Vista.showListaVentasHeader();
        Vista.mostrarVentas(listado);
        Vista.showAnyKey();
        Vista.getOpcion();
    }
}