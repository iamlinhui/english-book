package cn.promptness.book;

import cn.promptness.book.pojo.chapter.Chapter;
import cn.promptness.book.pojo.chapter.ChapterClass;
import cn.promptness.book.pojo.chapter.ResponseChapter;
import cn.promptness.book.pojo.content.Content;
import cn.promptness.book.pojo.content.ResponseContent;
import cn.promptness.book.pojo.electron.ElectronBook;
import cn.promptness.book.pojo.electron.ResponseElectronBook;
import cn.promptness.core.HttpClientUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

/**
 * @author lynn
 * @date 2020/2/4 13:02
 * @since v1.0.0
 */
public class BookApplication {

    private static final String BASE = "/Users/lynn/Downloads/";
    private static final String LINE = "/";

    public static void main(String[] args) throws Exception {

        getContent("七年级下册英语课本", "251");

        getContent("八年级上册英语课本", "241");

        getContent("八年级下册英语课本", "252");
        getTeacherBook("八年级下册英语教案", "349");

        getContent("九年级英语课本", "243");
        getTeacherBook("九年级英语教案", "347");
    }

    private static void getTeacherBook(String bookName, String bookId) throws Exception {
        HttpClientUtil httpClientUtil = new HttpClientUtil();

        ResponseElectronBook responseElectronBook = httpClientUtil.doGet(String.format("https://app.beisu100.com/mybook/Electronbook/Answerinfo?book_id=%s", bookId)).getContent(ResponseElectronBook.class);
        File file = new File(BASE + bookName);
        if (!file.exists()) {
            file.mkdirs();
        }

        for (ElectronBook electronBook : responseElectronBook.getData()) {
            String page = electronBook.getPage();
            httpClientUtil.doGet(electronBook.getImageUrl(), new FileOutputStream(new File(file.getPath() + LINE + page + ".jpg")));
        }
    }


    private static void getContent(String bookName, String bookId) throws Exception {
        HttpClientUtil httpClientUtil = new HttpClientUtil();
        ResponseChapter responseChapter = httpClientUtil.doGet(String.format("https://diandu.fz.beisu100.com/api/chapters?token=zheshidianduxiaochengxu&bid=%s", bookId)).getContent(ResponseChapter.class);
        for (Chapter chapter : responseChapter.getData()) {

            String chapterName = chapter.getName();

            List<ChapterClass> chapterClassList = chapter.getClasses();
            for (ChapterClass chapterClass : chapterClassList) {

                String chapterClassName = chapterClass.getName();

                File file = new File(BASE + bookName + LINE + chapterName + LINE + chapterClassName);
                if (!file.exists()) {
                    file.mkdirs();
                }

                String id = chapterClass.getId();
                ResponseContent responseContent = httpClientUtil.doGet(String.format("https://diandu.fz.beisu100.com/api/courseContent?token=zheshidianduxiaochengxu&cid=%s", id)).getContent(ResponseContent.class);

                for (Content content : responseContent.getData()) {
                    String fileName = content.getSort() + "-" + content.getPicName();
                    httpClientUtil.doGet(content.getPic(), new FileOutputStream(new File(file.getPath() + LINE + fileName)));
                }
            }
        }
    }
}
