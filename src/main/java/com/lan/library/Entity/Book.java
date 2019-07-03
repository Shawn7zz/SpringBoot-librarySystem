package com.lan.library.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.*;

/**
 * @author Xiang Lan
 * Created on 2019-06-25 21:58
 */
@Entity(name = "book")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Transient
    private String[] authors;

    @Column(name = "description")
    private String description;

    @Column(name = "publish_date")
    private String publishDate;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "categories")
    private String category;

    @Transient
    private String[] categories;

    @ManyToMany(mappedBy = "books", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<User> users = new HashSet<>();

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", publishDate='" + publishDate + '\'' +
                ", publisher='" + publisher + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
