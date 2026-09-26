/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  org.springframework.stereotype.Service
 *  org.springframework.transaction.annotation.Transactional
 *  org.springframework.transaction.support.TransactionSynchronizationManager
 */
package com.example.Replications.Service;

import com.example.Replications.Data.Post;
import com.example.Replications.Repository.PostRepository;
import java.util.List;
import lombok.Generated;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Service
public class PostService {
    private final PostRepository repository;

    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly=true)
    public Post getPost(Long id) {
        return (Post)this.repository.findById(id).orElseThrow();
    }

    @Transactional(readOnly=true)
    public List<Post> getAll() {
        System.out.println("TX active = " + TransactionSynchronizationManager.isActualTransactionActive());
        System.out.println("TX readOnly = " + TransactionSynchronizationManager.isCurrentTransactionReadOnly());
        return this.repository.findAll();
    }

    @Transactional
    public Post create(Post post) {
        return (Post)this.repository.save(post);
    }

    @Generated
    public PostRepository getRepository() {
        return this.repository;
    }
}
