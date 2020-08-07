/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienttcp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author niass028652
 */
public class ClientThreadEcriture extends Thread{
    private Socket client;
    public ClientThreadEcriture(Socket client) {
       this.client = client;
    }

    @Override
    public void run() {
        try {
            PrintStream out = new PrintStream(client.getOutputStream(),true);
            Scanner sc = new Scanner(System.in);
            while (true){
                String msg = sc.nextLine();
                if(msg.equalsIgnoreCase("fin"))
                    break;
                out.println(msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
}

