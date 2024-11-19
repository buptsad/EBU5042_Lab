import java.net.*;
import java.io.*;
public class ASCIIClient {
    public static void main(String[] args) throws IOException{
        InetAddress address = InetAddress.getByName(null);
        System.out.println("addr = " + address);
        Socket socket = new Socket(address, ASCIIServer.PORT);
        try{
            System.out.println("socket = "+socket);
            BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader( socket.getInputStream())
            );
            PrintWriter printWriter = new PrintWriter(
                new OutputStreamWriter(socket.getOutputStream()),true
            );
            for (int i=97;i<=122;i++){
                printWriter.println(i);
                System.out.println("Sent: "
                + i + " Received: " + bufferedReader.readLine());
            }
            printWriter.println("-1");
        }finally{
            socket.close();
        }
    }
}
