package com.lan.library.Service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lan.library.Dao.BookDao;
import com.lan.library.Dao.UserDao;
import com.lan.library.Entity.Book;
import com.lan.library.Entity.User;
import com.lan.library.JsonObj.BookJson;
import com.lan.library.JsonObj.Items;
import com.lan.library.JsonObj.VolumeInfo;
import com.lan.library.api.request.BookCriteria;
import com.lan.library.utils.StringUtils;
import io.swagger.models.auth.In;
import jdk.internal.org.objectweb.asm.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * @author Xiang Lan
 * Created on 2019-07-01 14:10
 */

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    UserDao userDao;

    @Autowired
    BookDao bookDao;


    @Override
    public List<Book> getAllBookList() {
        return null;
    }

    @Override
    public Boolean addBook(Book book) {
        return null;
    }

    @Override
    public Boolean borrowBook(Integer userId, Integer bookId) {
        User user = userDao.findUserById(userId);
        Book book = bookDao.findBookById(bookId);
        user.getBooks().add(book);
        User user1 = userDao.save(user);
        return Objects.nonNull(user1);
    }

    @Override
    public Book searchBook(BookCriteria bookCriteria) {

        String url = "https://www.googleapis.com/books/v1/volumes";
        UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("q", "isbn:" + bookCriteria.getISBN()).build();
        RestTemplate restTemplate = new RestTemplate();
        String book = restTemplate.getForObject(uriComponents.toString(), String.class);
        try {
//
//            ObjectMapper objectMapper = new ObjectMapper();
//            objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
//
//            BookJson bookJson = objectMapper.readValue(book, BookJson.class);
//            System.out.println(bookJson);
//
//            for (Items items : bookJson.getItems()) {
//                Book book1 = new Book();
//                book1.setName(items.getVolumeInfo().getTitle());
//                book1.setAuthor(items.getVolumeInfo().getAuthors()[0]);
//                book1.setDescription(items.getVolumeInfo().getDescription());
//                book1.setPublishDate(items.getVolumeInfo().getPublishedDate());
//                book1.setPublisher(items.getVolumeInfo().getPublisher());
//                bookDao.save(book1);
//            }

            JsonNode arrNode = new ObjectMapper().readTree(book).findPath("items");
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            Items[] items = objectMapper.readValue(arrNode.toString(), Items[].class);
//            VolumeInfo[] volumeInfos = objectMapper.readValue(arrNode.toString(),VolumeInfo[].class);
            for (Items items1 : items) {
                Book curBook = items1.getVolumeInfo();
                curBook.setAuthor(StringUtils.formatStringArray(curBook.getAuthors()));
                curBook.setCategory(StringUtils.formatStringArray(curBook.getCategories()));
                System.out.println(curBook);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


}
