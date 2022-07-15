package com.cjl.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@Data
@ToString
@TableName("idol")
public class Idol {
    @Id
    @TableId(value = "idol_id", type = IdType.AUTO)
    private Integer idolId;
    private String idolName;
    private Integer age;
    private Integer height;
    private String figure;
    private String hobby;
    private String slogan;
    private Integer companyId;
    private String picPath;
}

