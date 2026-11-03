package io.github.debz_cpu.restserver.server;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;




public class Server {
    public  void start() throws IOException {
        // Step 1: Create the server on port 10001 with a backlog of 10
        HttpServer server = HttpServer.create(new InetSocketAddress(10001), 10);

        // 2. Register route (Changed to lowercase "/hello" to match your print statement)
        server.createContext("/hello", exchange -> {

            // Send HTTP 200 OK and response length
            String response = "Hello World from the lamda handler!";
            exchange.sendResponseHeaders(200,response.getBytes().length);

            // Write the response and close streams
            try (OutputStream os = exchange.getResponseBody() ){
                os.write(response.getBytes());
            }catch (IOException e){
                System.err.println("Reason: "+e.getMessage());
                e.printStackTrace();
            }
        });
        // Step 3: Start the server
        server.start();
        System.out.println("Server succesfully running on http://localhost:10001/hello");
    }

}
