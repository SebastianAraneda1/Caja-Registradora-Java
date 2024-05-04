package cl.leno.cajaregistradora.leno.test;

/**
 *
 * @author sebas
 */
public class Referencias {

    public static void main(String[] args) {

        Persona persona = new Persona();
        persona.nombre = "Sebastian";
        persona.edad = 22;

        //Aqui haces una referencia en memoria para el primer objeto que has
        //creado de persona, por lo que lo reemplazas con otros datos en vez
        //de crear un objeto totalmente distinto.
        Persona persona2 = persona;
        try {
            persona2 = persona.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        persona2.nombre = "Daniel";
        persona2.edad = 32;

        //Aqui si creas un objeto nuevo, porque no referencias a ningun objeto
        //creado anteriormente.
        Persona persona3 = new Persona();
        persona3.nombre = "Fabian";
        persona3.edad = 31;

        System.out.println(persona.nombre
                + "\n" + persona2.nombre
                + "\n" + persona3.nombre);

    }
}
