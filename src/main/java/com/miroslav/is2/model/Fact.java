package com.miroslav.is2.model;

import org.springframework.stereotype.Controller;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "fact")
public class Fact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;


    @Column(name = "content", nullable = false, length = 255)
    @NotEmpty(message = "* Please, enter fun fact content!")
    @Lob
    private String content;

    @Column(name = "allowed")
    private boolean isAllowed;

    @ManyToOne(optional = true)
    @JoinColumn(name = "category_id", nullable = true)
    private Category category;


    @ManyToOne(optional = true)
    @JoinColumn(name = "user_id", nullable = true)
    private User createdBy;

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public boolean isAllowed() {
        return isAllowed;
    }

    public void setAllowed(boolean allowed) {
        isAllowed = allowed;
    }
}
