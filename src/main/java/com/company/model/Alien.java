package com.company.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "aliens")
public class Alien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "point")
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

    /*
    * Burada herhangi bir kolonun başında
    * @Transient anotsayonu kullanılırsa,
    * yazılım tarafında kullanılıp vt ye yazılmayacak
    * anlamına gelmektedir.
    * */

    @Override
    public String toString() {
        return "Alien{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", point=" + point +
                '}';
    }
}
