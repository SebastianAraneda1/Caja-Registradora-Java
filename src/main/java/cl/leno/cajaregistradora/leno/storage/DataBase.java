package cl.leno.cajaregistradora.leno.storage;

import cl.leno.cajaregistradora.leno.objects.Arroz;
import cl.leno.cajaregistradora.leno.objects.Carne;
import cl.leno.cajaregistradora.leno.objects.Papa;
import cl.leno.cajaregistradora.leno.objects.Producto;

/**
 *
 * @author sebas
 */
public class DataBase {

    private Producto[] productos;

    public DataBase() {
        productos = new Producto[3];
        Producto papa = new Papa("Papa Frita");
        Producto arroz = new Arroz("Miraflores");
        Producto carne = new Carne("Lomo");

        productos[0] = papa;
        productos[1] = arroz;
        productos[2] = carne;

    }

    public Producto getByIndex(int i) {
        if (i < 0 || i > 2) {
            System.out.println("Índice no válido");
            return null;
        }

        return productos[i];
    }

    public Producto[] getAll() {
        return productos;
    }

}
