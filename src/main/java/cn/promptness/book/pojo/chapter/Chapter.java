package cn.promptness.book.pojo.chapter;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 *
 * @author lynn
 * @date 2020/2/4 13:32
 * @since v1.0.0
 */
@Data
public class Chapter {

    private String id;

    @JSONField(name = "create_time",format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    private String bid;

    private String name;

    private String gid;

    private String sort;

    private List<ChapterClass> classes;

}
