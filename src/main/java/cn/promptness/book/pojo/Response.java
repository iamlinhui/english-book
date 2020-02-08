package cn.promptness.book.pojo;

import lombok.Data;

/**
 * @author lynn
 */
@Data
public class Response<T> {

    private Integer code;

    private String msg;

    private T data;
}
