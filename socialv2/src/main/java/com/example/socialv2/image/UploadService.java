package com.example.socialv2.image;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Log4j2
@Service
@Transactional
@RequiredArgsConstructor
public class UploadService {

    @Value("${com.example.socialapp.path}")
    private String uploadPath;

    public UploadResultDTO uploadFile(String name,MultipartFile files) {
        if(files != null){
            String originalName = files.getOriginalFilename();
            String path = uploadPath+"/"+name;
            File folder = new File(path);
            if(!folder.exists()){
                folder.mkdirs();
            }

            String uuid = UUID.randomUUID().toString();

            Path savePath = Paths.get(path, uuid+"_"+ originalName);

            boolean image = false;

            try {
                files.transferTo(savePath);

                //이미지 파일의 종류라면
                if(Files.probeContentType(savePath).startsWith("image")){
                    image = true;

                }

            } catch ( IOException e) {
                e.printStackTrace();
            }

            UploadResultDTO uploadResultDTO = UploadResultDTO.builder()
                    .uuid(uuid)
                    .fileName(originalName)
                    .img(image).build();

            return uploadResultDTO;
        }//end if

        return null;

    }
}
