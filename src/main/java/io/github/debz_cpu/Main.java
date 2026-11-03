package io.github.debz_cpu;

import io.github.debz_cpu.restserver.server.Server;
import java.io.IOException;

public class Main  {
    public static void main(String[] args){
        Server MyServer = new Server();

        // Teacher's pattern: Wrapping the dangerous network call in a try/catch
        try {
             MyServer.start();
            System.out.println("Server started");
        }catch (IOException e) {
            System.err.println("Fatal: could not start the server!");
            System.err.println("Reason: "+e.getMessage());
            e.printStackTrace();
        }
    }
}
