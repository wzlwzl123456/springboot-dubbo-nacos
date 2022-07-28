package com.weng.consumer.controller;

import com.alibaba.fastjson.JSONObject;
import com.weng.pojo.Books;
import com.weng.serivce.BookService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

//用@Controller配合视图解析器返回到指定的页面
@RestController//相当于@Controller和@ResponseBody合在一起,返回的是return里面的内容，无法返回到指定的页面
@RequestMapping("/book")
@CrossOrigin(originPatterns = "*", allowedHeaders = "*", methods = {}, allowCredentials = "true")//处理跨域请求
public class BookController {

    //@DubboReference用来引用@DubboService暴露的服务
    //配置check=false，解决提供者、消费者启动顺序问题
    @DubboReference(check = false)
    private BookService bookService;

    //获得当前页查询数据及条数
    @PostMapping(value = "/fuzzyQueryBook", produces = "text/html;charset=utf-8")
    public String fuzzyQueryBookList(@RequestParam(value = "curr", defaultValue = "1") Integer curr,
                                     @RequestParam(value = "limit", defaultValue = "5") Integer limit,
                                     @RequestParam(value = "name") String name) {
        int counts = this.bookService.getCounts(name);
        List<Books> booksList = this.bookService.fuzzyQuery(name, curr, limit);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("count", counts);
        jsonObject.put("data", booksList);
        return jsonObject.toJSONString();
    }

    @PostMapping(value = "/addBook", produces = "text/html;charset=utf-8")
    public String addBook(Books book) {
        System.out.println(book.toString());
        this.bookService.addBook(book);
        return "新增书完成";
    }

    @PostMapping(value = "/deleteBook", produces = "text/html;charset=utf-8")
    public String deleteBook(String idList) {
        String[] delId = idList.split(",");
        String sucRes = "成功删除：";
        String faiRes = "失败删除：";
        List<Books> booksList = this.bookService.queryAllBook();
        List<Integer> bookIdList = booksList.stream().map(Books::getBookID).collect(Collectors.toList());
        for (int i = 0; i < delId.length; i++) {
            if (bookIdList.contains(Integer.parseInt(delId[i]))) {
                this.bookService.deleteBookById(Integer.parseInt(delId[i]));
                sucRes = sucRes + delId[i] + ",";
            } else {
                faiRes = faiRes + delId[i] + ",";
            }
        }
        return sucRes + faiRes;
    }

    @PostMapping(value = "/updateBook", produces = "text/html;charset=utf-8")
    public String updateBook(Books book) {
        List<Books> booksList = this.bookService.queryAllBook();
        List<Integer> bookIdList = booksList.stream().map(Books::getBookID).collect(Collectors.toList());
        if (bookIdList.contains(book.getBookID())) {
            this.bookService.updateBook(book);
            return "更新完成";
        } else {
            return "这本书不存在";
        }
    }
}