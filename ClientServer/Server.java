package com.example;

import java.io.*;
import java.net.*;

public class Server{
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private ServerSocket server;
    private Socket connection;

    //constructor
    public Server(){

    }

    //accept client request and return the lots
    public void returnLots() throws ClassNotFoundException{
        try{
            server = new ServerSocket(1234,100);
            while(true){
                try{
                    connection = server.accept();
                    setupStreams();
                    optimise();
                }catch (EOFException e){
                    e.printStackTrace();
                }finally{
                    output.close();
                    input.close();
                    connection.close();
                }
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    //setup the stream between server and client
    private void setupStreams() throws IOException{
        input = new ObjectInputStream(connection.getInputStream());
        output = new ObjectOutputStream(connection.getOutputStream());
        output.flush();

    }

    //call the optimiser top optimise the parking lots
    private void optimise() throws IOException, ClassNotFoundException{
        double[] requestInfo = (double[]) input.readObject();
        for (double a: requestInfo) {
            System.out.println(a);
        }
        //String[] result = optimiseLots(requestInfo);
        String[] result = new String[]{"lot1name", "lot1rate", "lot1lots", "lot2name", "lot2rate", "lot2lots", "lot3name", "lot3rate", "lot3lots"};
        output.writeObject(result);
        //output.flush();

    }
}
