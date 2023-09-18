package arcoeflecha;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Arco {
    public Arco(){
        
        try{
        //10.25.1.31
        Socket s = new Socket("localhost", 2000);
        OutputStream os = s.getOutputStream();
        
        String str = "meu_nome:100:70";
        os.write(str.getBytes());
        s.close();
        
        }catch(UnknownHostException uhe){
            uhe.printStackTrace();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new Arco();
    }
}
