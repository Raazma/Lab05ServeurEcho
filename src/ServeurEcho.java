/**
 * Created by Razma on 2015-02-22.
 */
import  java.io.*;
import java.net.*;

public class ServeurEcho {

    public void LancerServer(int port)
    {
        Socket socket = null;
        ServerSocket serveur = null;
        boolean enService = true;
        String ligne = "";
        
        try {

            serveur = new ServerSocket(port);

            while (enService) {

                Socket client = serveur.accept();
                System.out.println("Client connecte");


                Connexion connexion = new Connexion(client);
                Thread t = new Thread(connexion);
                t.start();

              if(!t.isAlive())
                  enService = false;



            }

            socket.close();
            serveur.close();
        }
        catch (IOException e)
        {
            System.out.println(e);
        }

    }

    public static void main(String args[] )
    {
        ServeurEcho leServeur = new ServeurEcho();
        leServeur.LancerServer(7);
    }

}
