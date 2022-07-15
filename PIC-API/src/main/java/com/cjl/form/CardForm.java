package com.cjl.form;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class CardForm {
    private Integer idolId;
    private String cardName;
    //存储等级的数据
    private Integer[][] lv;
    private MultipartFile multipartFile;
    private String rareRank;
    private String skillDescription;
}
