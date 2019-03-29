package com.example.server.entity;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name="category")
public class Category {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id")
    private int id;


    @Column(name="id_vote")
    int idVote;

    @Column(name="name")
    private String name;

    @Column(name="count")
    private int count;

    public Category (){};

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdVote() {
        return idVote;
    }

    public void setIdVote(int idVote) {
        this.idVote = idVote;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return id == category.id &&
                idVote == category.idVote &&
                count == category.count &&
                Objects.equals(name, category.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idVote, name, count);
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", idVote=" + idVote +
                ", name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}
