package com.example.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.lang.reflect.*;

import com.example.Conn;
import com.example.Curso;

public class CursoDAO implements GenericDao{


    private List<Curso> dados;

    public CursoDAO(){

        dados = this.get();
    }

    @Override
    public int getColunsQtn(){
        return  dados.size()+1;
    }

    @Override
    public String getColunsNome(int column){

        Object obj = dados.get(0);

        Class  c = obj.getClass();
        //System.out.println(c.toString());
		for (Field f: c.getDeclaredFields() ) {
            if (f.isAnnotationPresent(ColunaAnnotation.class)  ) {
                ColunaAnnotation a = (ColunaAnnotation)f.getAnnotation(ColunaAnnotation.class);
                if (a.pos() == column) {
                   // System.out.println(a.nome());
                    return a.nome();
                }
            }
        }
        return null;
    }

    @Override
    public void create(Curso curso){
        try {

         Conn con = new Conn();
            Connection conn = con.get();
                    String sql = "INSERT INTO cursos( `nome`, `cargaHoraria`, `coordenador`,"
                    +" `departamento`, `turno`, `modalidade`) VALUES(?,?,?,?,?,?)";
                        PreparedStatement stmt = conn.prepareStatement(sql);
                        stmt.setString(1, curso.getNome());
                        stmt.setInt(2, curso.getCarga_horaria());
                        stmt.setString(3, curso.getCoordenador());
                        stmt.setString(4, curso.getDepartamento());
                        stmt.setString(5, curso.getTurno());
                        stmt.setString(6, curso.getModalidade());
                    stmt.execute();
                    stmt.close();
            conn.close();

            }
            catch(SQLException excecao) {
            throw new RuntimeException(excecao);
            }
    }

    @Override
    public List<Curso> get(){
        try {

            List<Curso> Curso_a = new ArrayList<Curso>();
    
            Conn c = new Conn();
            Connection conn = c.get();
        
        String sql = "select * from cursos";
        PreparedStatement stmt = conn.prepareStatement(sql);
    
        ResultSet rs = stmt.executeQuery();
    
        while (rs.next()) {
            Curso curso_t = new Curso();

            curso_t.setNome(rs.getString("nome"));
            curso_t.setCarga_horaria(rs.getInt("cargaHoraria"));
            curso_t.setCoordenador(rs.getString("coordenador"));
            curso_t.setDepartamento(rs.getString("departamento"));
            curso_t.setTurno(rs.getString("turno"));
            curso_t.setModalidade(rs.getString("modalidade"));
            Curso_a.add(curso_t);
        }
    
        stmt.close();
        conn.close();

        return Curso_a;
        }
        catch(SQLException excecao) {
        throw new RuntimeException(excecao);
        }
   
     }
    
}
