package cn.promptness.book.pojo.content;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

/**
 * @author lynn
 */
@Data
public class ContentPicturePart {


    private String id;

    @JSONField(name = "create_time",format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    private String pid;

    private String top;
    private String left;
    private String width;
    private String height;
    private String chinese;
    private String english;

    @JSONField(name = "spoken_type")
    private String spokenType;
    private String audio;
    private String order;
    private String audio2;
    private String audiooss;




}
