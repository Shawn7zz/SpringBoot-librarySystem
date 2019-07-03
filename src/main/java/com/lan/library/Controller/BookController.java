package com.lan.library.Controller;

import com.lan.library.Service.BookServiceImpl;
import com.lan.library.api.request.BookOperationRequest;
import com.lan.library.api.response.UserOperationResponse;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Xiang Lan
 * Created on 2019-06-26 09:50
 */

@RestController
@RequestMapping("/api/book")
@Api(value = "book")
public class BookController {

    @Autowired
    BookServiceImpl bookService;

    @PostMapping("/add")

    public ResponseEntity<?> addBook() {

        return null;
    }


    @PostMapping("/borrow")
    public ResponseEntity<?> borrowBook(@RequestBody BookOperationRequest bookOperationRequest) {

        if(bookService.borrowBook(bookOperationRequest.getUserId(), bookOperationRequest.getBookId())){
            return new ResponseEntity<>(new UserOperationResponse(true,"You are all set"), HttpStatus.OK);
        }

        return null;
    }

    @PostMapping("/return")
    public ResponseEntity<?> returnBook() {

        return null;
    }

}
