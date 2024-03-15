package tcp.exemplo_1;

import java.net.ServerSocket;
import java.io.IOException;
import java.net.Socket;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Date;

public class Servidor{
    int porta = 1234;
    Date d = new Date();
    public Servidor(){
        try{
            ServerSocket ss = new ServerSocket(porta);
            System.out.println("Aguardando...");
            Socket s = ss.accept();
            OutputStream os = s.getOutputStream();
            os.write(d.toString().getBytes());
            os.close();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
    public static void main(String args[]){
        Servidor s = new Servidor();
    }
}
