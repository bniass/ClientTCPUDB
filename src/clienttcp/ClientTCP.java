/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienttcp;

import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author niass028652
 */
public class ClientTCP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Socket client = null;

        try {
            // je suis joignable sur le port 5001
            client = new Socket("localhost",5001);
            new ClientThreadEcriture(client).start();
            new ClientThreadLecture(client).start();
            


        }catch (Exception e){
            if(client != null && !client.isClosed()){
                client.close();
            }
        }
    }
    
}
