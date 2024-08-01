package com.redis.controller;

import com.redis.entity.Book;
import com.redis.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "测试redis接口")
@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @ApiOperation(value = "保存图书", notes = "保存一本新的图书")
    @PostMapping
    public String saveBook(@RequestBody Book book) {
        bookService.saveBook(book);
        return "Book saved successfully";
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "获取图书", notes = "根据ID获取图书信息")
    public Book getBook(@PathVariable String id) {
        return bookService.getBook(id);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除图书", notes = "根据ID删除图书")
    public String deleteBook(@ApiParam(name = "图书id") @PathVariable String id) {
        bookService.deleteBook(id);
        return "Book deleted successfully";
    }
}
