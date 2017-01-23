/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yasin.vertxservergroup;

import io.vertx.core.Vertx;

/**
 *
 * @author yasin93
 */
public class Main {
    
      public static void main(String[] args) throws InterruptedException{
      Vertx vertx = Vertx.vertx();
        
      
      vertx.deployVerticle(new VertxServer());
      System.out.println("Vertx chat server runs on port 9002 .....");
    
  }
}
