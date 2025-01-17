package com.example2.example2.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example2.example2.service.FileService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class FileController {

    private final FileService fileService;

    @PostMapping("/upload")
    public ResponseEntity<?> UploadFile(@RequestParam MultipartFile file){
        try {
            Boolean isFileUploaded = fileService.uploadFile(file);
            if(isFileUploaded){
                return new ResponseEntity<>("File Uploaded Sucessfully",HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
       
        return new ResponseEntity<>("File Upload Failed",HttpStatus.INTERNAL_SERVER_ERROR);
    }



}
