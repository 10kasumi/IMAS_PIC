package com.cjl.form;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class CompanyForm {
    private String name;
    private String description;
    private String urls;
    private MultipartFile multipartFile;
}
