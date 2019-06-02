package com.polytech.polytoDo.business;

import javax.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "content")
    private String content;

    @Column(name = "done",columnDefinition = "default boolean false")
    private boolean done;

    @ManyToOne
    private User user;

    public Task() {
    }
/*
    public Task(String content, boolean done, User user) {
        this.content = content;
        this.done = done;
    }
*/
    public Task(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", done=" + done +
                ", user=" + user +
                '}';
    }
}
