package cn.promptness.book.pojo.electron;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @author lynn
 */
@Data
public class ElectronBook {

    private String id;

    @JSONField(name = "book_id")
    private String bookId;

    private String page;


    @JSONField(name = "imageurl")
    private String imageUrl;


}
