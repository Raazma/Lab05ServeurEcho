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
        PrintWriter writer = null;
        BufferedReader reader = null;
        boolean enService = true;
        String ligne = new String();
        try {

            serveur = new ServerSocket(port);



            while (enService) {

                Socket client = serveur.accept();


                //writer = new PrintWriter( new OutputStreamWriter(socket.getOutputStream()));
                reader = new BufferedReader( new InputStreamReader( socket.getInputStream()));
                System.out.println("Client connecte");
                Connexion connexion = new Connexion(client);
                Thread t = new Thread(connexion);
                t.start();
               // ligne = reader.readLine();
             //   writer.println(ligne);

                if(ligne.isEmpty())
                    enService = false;

                writer.flush();
            }
            writer.close();
            reader.close();
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
