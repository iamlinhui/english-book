package cn.promptness.book.pojo.chapter;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

@Data
public class ChapterClass {


    private String id;

    @JSONField(name = "create_time",format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    private String uid;
    private String num;

    private String name;

    @JSONField(name = "down_url")
    private String downUrl;
    private String qnum;
    private String qid;
    private String bid;

    private String sort;
}
