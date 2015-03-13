/**
 * Created by Razma on 2015-02-22.
 */
import  java.io.*;
import java.net.*;

public class ServeurEcho {

    public void LancerServer(int port)
    {
        Socket client = null;
        ServerSocket serveur = null;
        String ligne = "";
        
        try {
             Thread schwarzi = new Thread(new Terminateur());
             schwarzi.start();
             serveur = new ServerSocket(port);
             serveur.setSoTimeout(500);
             while (schwarzi.isAlive()) {
               
                try {
               client = serveur.accept();
                Connexion connexion = new Connexion(client);
                Thread t = new Thread(connexion);
                t.setDaemon(true);
                t.start();  
                System.out.println("Client connecte");
                
                }
                catch (SocketTimeoutException  e)
                {
                  
                }
               catch(NullPointerException e)
               {
          
               }
           
           
          
          
            }
        
             client.close();
             serveur.close();
             System.out.println("Im out of here Fuckers!!");
           
        }
        catch (IOException e)
        {
            //System.out.println(e);
            
        }      
         
    }

    public static void main(String args[] )
    {
         
        ServeurEcho leServeur = new ServeurEcho();
        leServeur.LancerServer(7);
       
        
    }

}
