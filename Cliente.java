import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 5000);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        Scanner scanner = new Scanner(System.in);
        String userInput;

        while (true) {
            userInput = scanner.nextLine();
            out.println(userInput);
            if ("sair".equalsIgnoreCase(userInput)) {
                break;
            }
            System.out.println("Servidor: " + in.readLine());
        }
        socket.close();
        scanner.close();
    }
}