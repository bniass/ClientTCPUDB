/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienttcp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * @author niass028652
 */
public class ClientThreadLecture extends Thread{
    private Socket client;
    public ClientThreadLecture(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(client.getInputStream()));
            while (true){
                String msg = in.readLine();
                if(msg == null){
                    break;
                }
                System.out.println(msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
}
