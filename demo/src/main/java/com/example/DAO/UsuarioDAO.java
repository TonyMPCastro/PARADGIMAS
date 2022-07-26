package com.example.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.Conn;
import com.example.Usuario;

public class UsuarioDAO {

 public void setUsers(Usuario u){
    try {

    Conn c = new Conn();
    Connection conn = c.get();
        String sql = "INSERT INTO usuarios(nome,email,senha,tipouser) VALUES(?,?,MD5(?),?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, "sergio Costa");
        stmt.setString(2, "sergio@ufma.br");
        stmt.setString(3, "123456");
        stmt.setString(4, "1");
        stmt.execute();
        stmt.close();
    conn.close();
        
    System.out.println("inserido");
    }
    catch(SQLException excecao) {
    throw new RuntimeException(excecao);
    }
 }

 
 public void login(String Email, String Senha){
    try {

        Conn c = new Conn();
        Connection conn = c.get();
    
    String sql = "select * from usuarios where email = ? and senha = MD5(?);";

    PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, Email);
            stmt.setString(2, Senha);
    ResultSet rs = stmt.executeQuery();

    while (rs.next()) {
        System.out.println("Logado");
    }

    stmt.close();
    conn.close();
    }
    catch(SQLException excecao) {
    throw new RuntimeException(excecao);
    }
 }
    
}
