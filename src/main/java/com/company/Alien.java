package com.company;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Alien {
    private Integer id;
    private String name;
    private Integer point;

    public Alien() {
        this.id = 0;
        this.name = "";
        this.point = 0;
    }

    public Alien(Integer id, String name, Integer point) {
        super();
        this.id = id;
        this.name = name;
        this.point = point;
    }

    public Alien(Alien alien) {
        this.id = alien.id;
        this.name = alien.name;
        this.point = alien.point;
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

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", point=" + point +
                '}';
    }
}
