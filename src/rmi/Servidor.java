package rmi;

import java.rmi.Naming;

public class Servidor{
        public static void main(String args[]){
                try{
                        Calculadora stub = new CalculadoraRemota();
                        Naming.rebind("rmi://localhost:5000/calculadora", stub);
                }catch(Exception e){}
        }
}
