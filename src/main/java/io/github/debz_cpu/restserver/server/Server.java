package io.github.debz_cpu.restserver.server;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;


public class Server {
    public  void start() throws IOException {
        // Step 1: Create the server on port 10001 with a backlog of 10 ( which means up to 10 waiting connections)
        HttpServer server = HttpServer.create(new InetSocketAddress(10001), 10);

        // 2.
        // Route every request whose path starts with "/hello" to this handler (prefix match)
        server.createContext("/hello", exchange -> {

            // 3. Response for /hello requests
            String response = "Hello Wörld from the lambda handler €!";

            // Variables for the parameters
            int statusCode=200;
            // Charset to help integrate European characters 2 byte for them eg:ö and symbols like € take 3 bytes
            byte[] responseBytes =response.getBytes(StandardCharsets.UTF_8);
            //SendResponse expects long for length
            long responseLength = responseBytes.length;

            //4. Send status + exact body length in BYTES first; a wrong length makes the JDK abort the response
            exchange.sendResponseHeaders(statusCode,responseLength);


            //getResponseBody() hands you the stream that leads to the client,try closes the stream automatically, catch reacts to and error and prints out an error message
            try (OutputStream os = exchange.getResponseBody()) {
                 os.write(responseBytes);
            }catch (IOException e){
                System.err.println("Reason: "+e.getMessage());
                e.printStackTrace();
            }
        });
        // Step 5: Start the server
        server.start();
        System.out.println("Server successfully running on http://localhost:10001/hello");
    }

}
