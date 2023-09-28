package arcoeflecha;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Arco {
    public Arco(){
        
        try{
        //10.25.2.30
        Socket s = new Socket("localhost", 2000);
        OutputStream os = s.getOutputStream();
        
        String str = "meu_nome:3:70";
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
