package com.example.client.bean;


import java.util.List;
import java.util.Objects;


public class Vote {

    private int id;
    private String name;
    private String link;
    private List<Category> list;
    private boolean status;

    public Vote() {
    }

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

    public List<Category> getList() {
        return list;
    }

    public void setList(List<Category> list) {
        this.list = list;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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
        return Objects.hash(id, name, link, list, status);
    }

    @Override
    public String toString() {
        return "Vote{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", link='" + link + '\'' +
                ", list=" + list +
                ", status=" + status +
                '}';
    }
}
