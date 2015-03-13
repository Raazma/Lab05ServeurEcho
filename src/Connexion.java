/**
 * Created by Razma on 2015-02-22.
 */
import  java.io.*;
import java.net.*;

public class Connexion implements Runnable {

  public  Socket socket = null;
  public BufferedReader reader;
  public PrintWriter writer;
  
    public Connexion(Socket lesocket)
    {
        socket = lesocket;
    }

    public void run()
    {     
         String ligne = new String();
          //BufferedReader reader;
         //  PrintWriter writer;

        try {
          reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
          writer  = new PrintWriter( new OutputStreamWriter(socket.getOutputStream()));
           
            do
            {
                ligne = reader.readLine();
                writer.println(ligne);               
                writer.flush();
                
            }while (!ligne.trim().isEmpty());
            
        }
        catch (IOException e)
        {
         
        }     
        catch(NullPointerException e)
            {
             System.out.println("Client donnecte");
            }        
        finally
        {
             try
            {
            reader.close();
            writer.close();
            socket.close();
            }
            catch(IOException e)
            {
            
            }
            
            
        }
        
          System.out.println("Client donnecte");
    
    }
  
}
