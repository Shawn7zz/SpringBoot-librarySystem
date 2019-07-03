package com.lan.library.Entity;

import com.lan.library.Dao.BookDao;
import com.lan.library.Dao.UserDao;
import com.lan.library.Service.BookServiceImpl;
import com.lan.library.Service.UserService;
import com.lan.library.api.request.BookCriteria;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Xiang Lan
 * Created on 2019-06-26 17:31
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {


    @Autowired
    BookDao bookDao;

    @Autowired
    UserDao userDao;

    @Autowired
    BookServiceImpl bookService;

    @org.junit.Test
    public void test2(){
        BookCriteria bookCriteria = new BookCriteria();
        bookCriteria.setISBN("9787544242516");
        bookService.searchBook(bookCriteria);
    }
}
