package com.example2.example2.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example2.example2.service.FileService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FileServiceImpl implements FileService {

    @Value("${file.upload.path}")
    private String uploadPath;

    @Override
    public Boolean uploadFile(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();

        // Ensure the upload directory exists
        File targetDirectory = new File(uploadPath);
        if (!targetDirectory.exists()) {
            boolean created = targetDirectory.mkdirs();
            if (!created) {
                throw new IOException("Failed to create the upload directory at: " + uploadPath);
            }
        }

        // Create the full file path
        Path storePath = Paths.get(uploadPath, fileName);

        // Check if the file already exists
        if (Files.exists(storePath)) {
            throw new IOException("File already exists at: " + storePath.toString());
        }

        // Copy the file to the target location
        long bytesCopied = Files.copy(file.getInputStream(), storePath);
        log.warn("File uploaded successfully. Size: {} bytes", bytesCopied);

        // Return success if bytes were copied
        return bytesCopied > 0;
    }

}
