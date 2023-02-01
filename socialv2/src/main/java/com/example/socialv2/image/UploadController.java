package com.example.socialv2.image;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Log4j2
@RequiredArgsConstructor
public class UploadController {

    private final UploadService uploadService;

    @PostMapping(value = "/upload/{name}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> upload(@PathVariable("name")String name, @RequestParam("file") MultipartFile file) {
        UploadResultDTO uploadResultDTO = uploadService.uploadFile(name,file);
        return ResponseEntity.ok().body(uploadResultDTO.getLink());
    }
}
