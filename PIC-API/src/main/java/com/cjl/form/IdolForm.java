package com.cjl.form;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class IdolForm {
    private String name;
    private Integer age;
    private Integer height;
    private String figure;
    private String hobby;
    private String slogan;
    private Integer CompanyId;
    private MultipartFile multipartFile;
}
