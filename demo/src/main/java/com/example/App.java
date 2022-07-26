package com.example;
import java.awt.EventQueue;

import com.example.DAO.CursoDAO;

public class App {
    
    public static void main(String[] args) {
        
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {

                    TableCursos lc = new TableCursos("Cursos",new CursoDAO());

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


        
    }
    
}
