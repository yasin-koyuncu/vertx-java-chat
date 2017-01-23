/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yasin.vertxservergroup;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServer;

/**
 *
 * @author yasin93
 */
public class VertxServer extends AbstractVerticle{
    /**
     * @param args the command line arguments
     */
      @Override
    public void start() throws Exception {
        HttpServer server = vertx.createHttpServer();
        
       
        server.websocketHandler(
                ws -> {

                    vertx.eventBus().consumer("anadress", message -> {
                        
                        System.out.println("rec: " + message.body());
                        ws.writeFinalTextFrame(message.body().toString());
                    });

                    ws.handler(buffer -> {
                        String data = buffer.getString(0, buffer.length());
                        System.out.println("Incoming " + data);

                        
                        vertx.eventBus().publish("anadress", data);
                    });

                }).listen(9002);

    }
    
}
