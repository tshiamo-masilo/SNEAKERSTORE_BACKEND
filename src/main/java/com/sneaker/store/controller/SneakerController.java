package com.sneaker.store.controller;


import com.sneaker.store.model.Sneaker;
import com.sneaker.store.repository.BookRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("books")
@RequiredArgsConstructor
@AllArgsConstructor
public class SneakerController {

    private byte[] imageBytes;

    private BookRepository bookRepository;

    @GetMapping("/get")
    public List<Sneaker> getBooks(){
        return bookRepository.findAll();
    }

    @PostMapping("/upload")
    public void uploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
        this.imageBytes = file.getBytes();
    }

    @PostMapping("/add")
    public void createBook(@RequestBody Sneaker sneaker) throws IOException{
        sneaker.setPicByte(this.imageBytes);
        bookRepository.save(sneaker);
        this.imageBytes = null;
    }

}
