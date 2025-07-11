// /src/calculadora/Servidor.java

package calculadora;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.Naming;

public class Servidor {
    public static void main(String[] args) throws Exception {
        CalculadoraImpl calc = new CalculadoraImpl();

        Registry registry = LocateRegistry.createRegistry(1099);

        Naming.rebind("CalculadoraService", calc);

        System.out.println("Servidor da Calculadora está pronto.");
    }
}