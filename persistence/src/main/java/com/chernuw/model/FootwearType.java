package com.chernuw.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "footweartype")
public class FootwearType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "footwearType")
    private List<Footwear> footwears;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Footwear> getFootwears() {
        return footwears;
    }

    public void setFootwears(List<Footwear> footwears) {
        this.footwears = footwears;
    }
}
