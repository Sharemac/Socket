/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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


public class Cliente {

    public static void main(String[] args) throws IOException {
        try{
            Socket cliente = new Socket("localhost", 8000);
            
         InputStream flujoEntrada = cliente.getInputStream();
        OutputStream flujoSalida = cliente.getOutputStream();
        
        BufferedReader lectura = new BufferedReader(new InputStreamReader(flujoEntrada));
        PrintWriter escritura = new PrintWriter(flujoSalida, true);
        
        BufferedReader lecturaUsuario = new BufferedReader(new InputStreamReader(System.in));
       
        String mensajeLeido="";
        String mensajeUsuario="";
        
        while(true){
            System.out.println("Que mns desea enviar");
            mensajeUsuario = lecturaUsuario.readLine();
            escritura.println(mensajeUsuario);
            mensajeLeido = lectura.readLine();
            System.out.println("Me contestaron\n" + mensajeLeido);
        }
        }catch(IOException ex){
             Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}