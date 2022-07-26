package com.example;

import com.example.DAO.ColunaAnnotation;

public class Curso {

    @ColunaAnnotation(nome = "Nome", pos = 0, tam = 10)
    private String nome;
    
    @ColunaAnnotation(nome = "Coordenador", pos = 1,tam = 120)
    private String coordenador;

    @ColunaAnnotation(nome = "Departamento", pos = 2,tam = 80)
    private String departamento;

    @ColunaAnnotation(nome = "Turno", pos = 3,tam = 120)
    private String turno;
    
    @ColunaAnnotation(nome = "Carga Horaria", pos = 4,tam = 80)
    private int carga_horaria;

    @ColunaAnnotation(nome = "Modalidade", pos = 5,tam = 80)
    private String modalidade;

public Curso() {

}

public Curso(String nome,  String coordenador, String departamento,int cargaHoraria, String turno,
            String modalidade) {
        this.nome = nome;
        this.carga_horaria =  cargaHoraria;
        this.coordenador = coordenador;
        this.departamento = departamento;
        this.turno = turno;
        this.modalidade = modalidade;
    }


    /**
     * @return String return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return String return the coordenador
     */
    public String getCoordenador() {
        return coordenador;
    }

    /**
     * @param coordenador the coordenador to set
     */
    public void setCoordenador(String coordenador) {
        this.coordenador = coordenador;
    }

    /**
     * @return String return the departamento
     */
    public String getDepartamento() {
        return departamento;
    }

    /**
     * @param departamento the departamento to set
     */
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    /**
     * @return String return the Turno
     */
    public String getTurno() {
        return turno;
    }

    /**
     * @param Turno the Turno to set
     */
    public void setTurno(String Turno) {
        this.turno = Turno;
    }

    /**
     * @return String return the carga_horaria
     */
    public int getCarga_horaria() {
        return carga_horaria;
    }

    /**
     * @param i the carga_horaria to set
     */
    public void setCarga_horaria(int i) {
        this.carga_horaria = i;
    }

    /**
     * @return String return the modalidade
     */
    public String getModalidade() {
        return modalidade;
    }

    /**
     * @param modalidade the modalidade to set
     */
    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

}
