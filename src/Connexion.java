/**
 * Created by Razma on 2015-02-22.
 */
import  java.io.*;
import java.net.*;

public class Connexion implements Runnable {

  public  Socket socket = null;
    public Connexion(Socket lesocket)
    {
        socket = lesocket;
    }

    public void run()
    {
        String ligne = new String();
         
        

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter( new OutputStreamWriter(socket.getOutputStream()));
            ligne = reader.readLine();
            while (!ligne.isEmpty())
            {
               ligne = reader.readLine();
                writer.println(ligne);
                
                writer.flush();
            }
            writer.close();
            socket.close();
        }
        catch (IOException e)
        {
            System.out.print("je plante a connection");
        }

    }

}
