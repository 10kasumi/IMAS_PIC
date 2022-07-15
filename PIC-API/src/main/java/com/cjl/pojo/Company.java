package com.cjl.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@Data
@ToString
@TableName("company")
public class Company {
    @Id
    @TableId(value = "company_id", type = IdType.AUTO)
    private Integer companyId;
    private String companyName;
    private String description;
    private String[] urls;
    private String picPath;
}
