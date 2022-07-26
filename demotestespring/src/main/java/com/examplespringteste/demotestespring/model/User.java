package com.examplespringteste.demotestespring.model;



public class User {
    private Long id;
    private String name;
    


    public User() {
       
    }
    public User(Long id1,String nome) {
        id = id1;
        name = nome;
    }

 
    /**
     * @return Long return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

}
