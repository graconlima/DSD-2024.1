package internet;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class ExInetAddress {
    public static void main(String args[]){
        
        try{
            InetAddress ia = InetAddress.getByName("losangeles.ifrn.edu.br");
            byte[] b = ia.getAddress();
            
            System.out.println("End: "+
                    b[0]+"."
                    +b[1]+"."
                    +b[2]+"."
                    +b[3]);
            
            System.out.println("End: "+ InetAddress.getByAddress(b).getHostName());
            
            
            /*System.out.println("End: "+
                    ((int)b[0]&0xFF)+"."
                    +((int)b[1]&0xFF)+"."
                    +((int)b[2]&0xFF)+"."
                    +((int)b[3]&0xFF));*/
        }catch(UnknownHostException uhe){
            uhe.printStackTrace();
        }
    }
}
