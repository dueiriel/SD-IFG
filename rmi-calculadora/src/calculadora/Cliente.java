// /src/calculadora/Cliente.java

package calculadora;

import java.rmi.Naming;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) throws Exception {

        // Use "localhost" se o servidor estiver na mesma máquina
        // ou o IP do servidor se estiver em outra máquina.
        String remoteHostName = "localhost";
        String connectLocation = "rmi://" + remoteHostName + "/CalculadoraService";

        Calculadora calculadora = (Calculadora) Naming.lookup(connectLocation);

        Scanner scanner = new Scanner(System.in);
        String operacao;

        while (true) {
            System.out.println("\nDigite a operação (soma, subtracao, multiplicacao, divisao) ou 'sair' para terminar:");
            operacao = scanner.nextLine();

            if (operacao.equalsIgnoreCase("sair")) {
                break;
            }

            System.out.print("Digite o primeiro número: ");
            double a = Double.parseDouble(scanner.nextLine());

            System.out.print("Digite o segundo número: ");
            double b = Double.parseDouble(scanner.nextLine());

            double resultado = 0;

            if (operacao.equalsIgnoreCase("soma")) {
                resultado = calculadora.somar(a, b);
            } else if (operacao.equalsIgnoreCase("subtracao")) {
                resultado = calculadora.subtrair(a, b);
            } else if (operacao.equalsIgnoreCase("multiplicacao")) {
                resultado = calculadora.multiplicar(a, b);
            } else if (operacao.equalsIgnoreCase("divisao")) {
                resultado = calculadora.dividir(a, b);
            } else {
                System.out.println("Operação inválida.");
                continue;
            }

            System.out.println("Resultado: " + resultado);
        }

        System.out.println("Cliente encerrado.");
        scanner.close();
    }
}