package com.example.server.entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Random;
import java.util.List;

@Entity
@Table(name="vote")
public class Vote {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id")
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="link")
    private String link;
    @Column(name="status")
    private boolean status;
    @OneToMany (cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy="idVote")
    private List<Category> list;

    public Vote() {}


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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Category> getList() {
        return list;
    }

    public void setList(List<Category> list) {
        this.list = list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vote vote = (Vote) o;
        return id == vote.id &&
                status == vote.status &&
                Objects.equals(name, vote.name) &&
                Objects.equals(link, vote.link) &&
                Objects.equals(list, vote.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, link, status, list);
    }

    @Override
    public String toString() {
        return "Vote{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", link='" + link + '\'' +
                ", status=" + status +
                ", list=" + list +
                '}';
    }
}
