package com.asree.stock_spring_boot.controllers;

import com.asree.stock_spring_boot.configs.Enviroments;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("api/upload")
public class UploadImageController {
    private final String dirFile = new Enviroments().getBaseDir();

    @PostMapping("image")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        try{
            if(file.isEmpty()){
                return ResponseEntity.badRequest().body("No file uploaded");
            }
            Path path = Paths.get(dirFile + file.getOriginalFilename());
            Files.createDirectories(path.getParent());

            Files.write(path, file.getBytes());

            return ResponseEntity.ok(path.toString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
