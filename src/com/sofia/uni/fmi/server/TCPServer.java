package com.sofia.uni.fmi.server;

import com.sofia.uni.fmi.threads.RequestHandler;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by vankata on 23.12.14.
 */
public class TCPServer {
     private final int port = 10514;
     private final String hostName = "localhost";
     private final int numberOfRequests = 10000;

    public void startServer(){
            try{
                ServerSocket serverSocket = new ServerSocket(port, numberOfRequests, InetAddress.getByName(hostName));
                while(true){
                    final Socket activeSocket = serverSocket.accept();
                    new RequestHandler(activeSocket).start();

                }
            }catch (IOException e){

            }

    }

}