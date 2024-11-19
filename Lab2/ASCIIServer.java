import java.io.*;
import java.net.*;

public class ASCIIServer {
    public static final int PORT = 8080;
    public static void main(String[] args) throws IOException{
        ServerSocket serverSocket = new ServerSocket(ASCIIServer.PORT);
        System.out.println("Started: " + serverSocket);
        try{
            Socket socket = serverSocket.accept();
            try{
                System.out.println("accepted: "+socket);
                BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
                );
                PrintWriter printWriter = new PrintWriter(
                    new OutputStreamWriter(socket.getOutputStream()),true
                );
                while (true){
                    String string = bufferedReader.readLine();
                    if(string.equals("-1")) break;
                    char c = (char) Integer.parseInt(string);
                    System.out.println("Received: "+ string +" Sent: " + c);
                    printWriter.println(c);
                }
            }finally{
                System.out.println("closing");
                socket.close();
            }
        }finally{
            serverSocket.close();
        }
    }
}
