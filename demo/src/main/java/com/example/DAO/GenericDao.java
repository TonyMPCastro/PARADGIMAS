package com.example.DAO;
import java.util.List;
import com.example.Curso;
public interface GenericDao {

    List<Curso> get();
    void create (Curso obj);
    String getColunsNome(int column);
    int getColunsQtn();
}
