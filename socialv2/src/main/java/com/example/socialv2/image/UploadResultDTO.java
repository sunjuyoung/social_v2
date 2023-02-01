package com.example.socialv2.image;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UploadResultDTO implements Serializable {

    private String uuid;

    private String fileName;

    private boolean img;

    public String getLink(){
        return uuid+"_"+fileName;

    }
}
