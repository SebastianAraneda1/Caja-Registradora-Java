package cl.leno.cajaregistradora.leno.views;

import cl.leno.cajaregistradora.leno.objects.Producto;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author sebas
 */
public class Vista {
    
    public static void showHeaderPrincipal(){
        System.out.println("\t\t*******************");
        System.out.println("\t\t*CAJA REGISTRADORA*");
        System.out.println("\t\t*******************");
    }
    
    public static void showMenuPrincipal(){
        System.out.println("1. Comprar");
        System.out.println("2. Vender");
        System.out.println("3. Inventario");
        System.out.println("4. Compras");
        System.out.println("5. Ventas");
        System.out.println("6. Salir");
    }
    
    public static void showGetOpcion(){
        System.out.print("Ingrese su opción: ");
    }
    
    public static void showGetCantidad(){
        System.out.print("Ingrese la cantidad: ");
    }
    
    public static void showGetPrecio(){
        System.out.print("Ingrese el precio: ");
    }
    
    public static int getOpcion(){
        Scanner tecla = new Scanner(System.in);
        return tecla.nextInt();
    }
    
    public static int getCantidad(){
        Scanner tecla = new Scanner(System.in);
        return tecla.nextInt();
    }
    
    public static double getPrecio(){
        Scanner tecla = new Scanner(System.in);
        return tecla.nextDouble();
    }
    
    public static void showCompraHeader(){
        System.out.println("\t\t*************************************");
        System.out.println("\t\t*          MENÚ DE COMPRAS          *");
        System.out.println("\t\t*************************************");
        showItemsMenu();
    }
    
    public static void showVentaHeader(){
        System.out.println("\t\t************************************");
        System.out.println("\t\t*          MENÚ DE VENTAS          *");
        System.out.println("\t\t************************************");
        showItemsMenu();
    }
    
    public static void showInventarioHeader(){
        System.out.println("\t\t****************************************************");
        System.out.println("\t\t*                    INVENTARIO                    *");
        System.out.println("\t\t****************************************************");		
        showItemsHeader();
    }
    
    public static void showListaComprasHeader(){
        System.out.println("\t\t*************************************");
        System.out.println("\t\t*              COMPRAS              *");
        System.out.println("\t\t*************************************");
        showItemsHeader();
    }
    
    public static void showItemsHeader(){
        System.out.println("\t\t----------------------------------------------------");				
        System.out.println("\t\t* PRODUCTO\t| Cantidad\t| Vr Unitario\t| Vr Total\t*");				
        System.out.println("\t\t****************************************************");			

    }
    
    public static void showListaVentasHeader(){
        System.out.println("\t\t**************************************");
        System.out.println("\t\t*               VENTAS               *");
        System.out.println("\t\t**************************************");				
        showItemsHeader();
    }

    public static void showItemsMenu(){
        System.out.println("1. Papa");
        System.out.println("2. Arroz");
        System.out.println("3. Carne");
        System.out.println("4. Volver");
    }
    
    public static void opcionInvalida(){
        System.out.println("La opción ingresada no es correcta");
    }
    
    public static void volver(String name){
        System.out.println("Saliendo del modulo " + name + "...");
    }
    
    public static void showAnyKey(){
        System.out.print("Ingrese un número para continuar");
    }
    
    public static void mostrarItemsStock(Producto[] productos){
        for (Producto producto : productos) {
            System.out.println("\t\t* "+producto.getNombre()+"\t| "
                    + ""+producto.getCantidad()+"\t\t| "
                            + ""+producto.getPrecio()+"\t\t\t| "
                                    + ""+producto.getCantidad()*producto.getPrecio()+"\t\t*");
        }
    }
    
    public static void mostrarCompras(List<Producto> listado){
        for (Producto producto : listado ) {
            System.out.println("\t\t* "+producto.getNombre()+"\t| "+producto.getCantidad()+"\t\t| "+producto.getPrecio()+"\t\t\t| "+producto.getCantidad()*producto.getPrecio()+"\t\t*");   
        }
    }
    
    public static void mostrarVentas(List<Producto> listado){
        for (Producto producto : listado ) {
            System.out.println("\t\t* "+producto.getNombre()+"\t| "+producto.getCantidad()+"\t\t| "+producto.getPrecio()+"\t\t\t| "+producto.getCantidad()*producto.getPrecio()*1.25+"\t\t*");   
        }
    }
}
