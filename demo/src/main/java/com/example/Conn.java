package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn {
    

    public Connection get(){
        Connection conn;
        String url = "jdbc:mysql://localhost/edukar_gestao?user=root&password=";
        try {
        conn = DriverManager.getConnection(url);
        return conn;
        }
        catch(SQLException excecao) {
            throw new RuntimeException(excecao);
        }
    }
}
