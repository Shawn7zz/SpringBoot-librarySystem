//package com.lan.library.Entity;
//
//import lombok.*;
//
//import javax.persistence.*;
//
///**
// * @author Xiang Lan
// * Created on 2019-06-25 22:46
// */
//
//@Entity(name = "book_user")
//@Data
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//public class UserBook {
//
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//
//    @ManyToOne
//    @JoinColumn(name = "userId")
//    private User user;
//
//    @ManyToOne
//    @JoinColumn(name = "bookId")
//    private Book book;
//}
