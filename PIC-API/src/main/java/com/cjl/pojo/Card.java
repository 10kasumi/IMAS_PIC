package com.cjl.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@Data
@ToString
@TableName("card")
public class Card {
    @TableId(value = "card_id", type = IdType.AUTO)
    @Id
    private Integer cardId;
    private Integer idolId;
    private String cardName;
    //存储 1级 和 满级的 mental vo da vi
    private String lv;
    private String picPath;
    private String rareRank;
    private String skillDescription;
    private Integer height;
    private Integer width;
}
