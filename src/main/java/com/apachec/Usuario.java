package com.apachec;

public class Usuario {

    private Integer id;

    private String name;

    public Usuario() {
    }
    public Usuario(Integer id, String nombre) {
        this.id = id;
        this.name=nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
