package cn.promptness.book.pojo.content;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author lynn
 */
@Data
public class Content {


    private String id;

    @JSONField(name = "create_time",format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    private String gid;

    private String bid;

    private String uid;

    private String name;

    private String sort;

    /**
     * 课本图片
     */
    private String pic;


    @JSONField(name = "animation_url")
    private String animationUrl;

    @JSONField(name = "ting_url")
    private String tingUrl;

    @JSONField(name = "answer_url")
    private String answerUrl;

    @JSONField(name = "teaching_url")
    private String teachingUrl;

    @JSONField(name = "pic_name")
    private String picName;

    @JSONField(name = "pic_part")
    private List<ContentPicturePart> picPartList;


}
