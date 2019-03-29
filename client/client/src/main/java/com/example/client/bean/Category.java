package com.example.client.bean;

import java.util.Objects;

public class Category {

    int id;
    int idVote;
    Vote Vote;
    String name;
    int count;

    public Category() {
    }

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

    public com.example.client.bean.Vote getVote() {
        return Vote;
    }

    public void setVote(com.example.client.bean.Vote vote) {
        Vote = vote;
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
                Objects.equals(Vote, category.Vote) &&
                Objects.equals(name, category.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idVote, Vote, name, count);
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", idVote=" + idVote +
                ", Vote=" + Vote +
                ", name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}
