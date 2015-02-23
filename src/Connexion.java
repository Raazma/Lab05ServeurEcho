/**
 * Created by Razma on 2015-02-22.
 */
import  java.io.*;
import java.net.*;

public class Connexion extends Terminateur implements Runnable {

  public  Socket socket = null;
    public Connexion(Socket lesocket)
    {
        socket = lesocket;
    }

    public void run()
    {
        String ligne = new String();

        Terminateur term = new Terminateur();
        Thread t = new Thread(term);
        t.start();

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter( new OutputStreamWriter(socket.getOutputStream()));

            while (t.isAlive())
            {
                writer.println(str);
                System.out.println( reader.readLine());
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
