import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Random;

public class Servidor {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(5000);
        List<String> respostas = List.of(
                "Interessante... continue.",
                "Essa é uma boa pergunta.",
                "Você sempre pensa assim?"
        );
        Random random = new Random();
        System.out.println("Servidor escutando na porta 5000, aguardando conexão");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Cliente conectado: " + clientSocket.getInetAddress().getHostAddress());
            new Thread(() -> {
                try {
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                    String mensagem;
                    while ((mensagem = in.readLine()) != null) {
                        if ("sair".equalsIgnoreCase(mensagem)) {
                            break;
                        }
                        out.println(respostas.get(random.nextInt(respostas.size())));
                    }
                    clientSocket.close();
                } catch (Exception e) {
                }
            }).start();
        }
    }
}