/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  jakarta.persistence.Entity
 *  jakarta.persistence.GeneratedValue
 *  jakarta.persistence.GenerationType
 *  jakarta.persistence.Id
 *  jakarta.persistence.Table
 *  lombok.Generated
 */
package com.example.Replications.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Generated;

@Entity
@Table(name="posts")
public class Post {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String title;
    private String body;

    @Generated
    public long getId() {
        return this.id;
    }

    @Generated
    public String getTitle() {
        return this.title;
    }

    @Generated
    public String getBody() {
        return this.body;
    }

    @Generated
    public void setId(long id) {
        this.id = id;
    }

    @Generated
    public void setTitle(String title) {
        this.title = title;
    }

    @Generated
    public void setBody(String body) {
        this.body = body;
    }
}
