/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.data.jpa.repository.JpaRepository
 */
package com.example.Replications.Repository;

import com.example.Replications.Data.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository
extends JpaRepository<Post, Long> {
}
