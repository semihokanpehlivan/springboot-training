package com.qbloomy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Semih Okan Pehlivan.
 */
@Entity
public class Question {

    @GeneratedValue
    @Id
    private long id;

    @Column(name = "header")
    private String header;

    @Column(name = "body")
    private String body;

    public Question(String header, String body) {
        this.header = header;
        this.body = body;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
