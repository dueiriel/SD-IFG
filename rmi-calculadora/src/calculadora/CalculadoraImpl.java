// /src/calculadora/CalculadoraImpl.java

package calculadora;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class CalculadoraImpl extends UnicastRemoteObject implements Calculadora {

    public CalculadoraImpl() throws RemoteException {
        super();
    }

    @Override
    public double somar(double a, double b) throws RemoteException {
        System.out.println("Cliente solicitou uma soma de " + a + " e " + b);
        return a + b;
    }

    @Override
    public double subtrair(double a, double b) throws RemoteException {
        System.out.println("Cliente solicitou uma subtração de " + a + " e " + b);
        return a - b;
    }

    @Override
    public double multiplicar(double a, double b) throws RemoteException {
        System.out.println("Cliente solicitou uma multiplicação de " + a + " e " + b);
        return a * b;
    }

    @Override
    public double dividir(double a, double b) throws RemoteException {
        System.out.println("Cliente solicitou uma divisão de " + a + " por " + b);
        return a / b;
    }
}