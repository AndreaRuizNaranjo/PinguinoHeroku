/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crunchify.jsp.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author andre
 */
public class Conexion 
{
  public static Connection getConnection() throws SQLException{
    try {
 
        Class.forName("org.postgresql.Driver");
         Connection conexion = DriverManager.getConnection(
            "jdbc:postgresql://ec2-54-243-228-140.compute-1.amazonaws.com:5432/deijnju2cfjg6o?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory",
            "rdzcnnseiuamqg", "192e5a948cb9a58406e43b4b2ff43570906f41784fadbc3eb3843472ab7bc7c2");
 
        if(conexion != null)
        {
                System.out.println("Conexion Exitosa");
                return conexion;
        }
 
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
      return null;
}
}
