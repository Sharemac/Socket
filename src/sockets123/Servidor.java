
package sockets123;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Servidor {

    public static void main(String[] args) throws IOException {
        try{
       ServerSocket serverSocket = new ServerSocket(8000);
        
        Socket cliente = serverSocket.accept();
        
        InputStream flujoEntrada = cliente.getInputStream();
        OutputStream flujoSalida = cliente.getOutputStream();
        
        BufferedReader lectura = new BufferedReader(new InputStreamReader(flujoEntrada));
        PrintWriter escritura = new PrintWriter(flujoSalida, true);
        
        BufferedReader lecturaUsuario = new BufferedReader(new InputStreamReader(System.in));
        
        String mensajeLeido = " ";
        while(true){
            mensajeLeido = lectura.readLine();
            System.out.println(mensajeLeido);
            System.out.println("Respuesta\n ");
            mensajeLeido = lecturaUsuario.readLine();
            escritura.println( mensajeLeido);
        }
        }catch (IOException ex){
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
            