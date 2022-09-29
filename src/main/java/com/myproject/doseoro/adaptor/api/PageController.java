package com.myproject.doseoro.adaptor.api;

import com.myproject.doseoro.adaptor.logger.Logging;
import com.myproject.doseoro.application.book.handler.FindHomeDisplayingBooksCommandHandler;
import com.myproject.doseoro.application.identity.handler.MyPageQuery;
import com.myproject.doseoro.domain.book.vo.FindAllBooksVO;
import com.myproject.doseoro.domain.book.vo.HomeDisplayedBookVO;
import com.myproject.doseoro.adaptor.infra.mybatis.book.BookMybatisRepository;
import com.myproject.doseoro.domain.identity.dto.MyPageDtoResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PageController {

    private final FindHomeDisplayingBooksCommandHandler findHomeDisplayingBooksCommandHandler;
    private final BookMybatisRepository bookMybatisService;
    private final MyPageQuery myPageQuery;

    @Logging
    @RequestMapping(value = "/")
    public String home(Model model) {
        // 홈화면에서 최근 판매목록 5개 가져오기

        Void unused = null;
        List<HomeDisplayedBookVO> list = findHomeDisplayingBooksCommandHandler.handle(unused);

        model.addAttribute("books", list);
        return "home";
    }

    @Logging
    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    @Logging
    @RequestMapping(value = "/mypage")
    public String myPage(Model model) {

        Void voId = null;
        MyPageDtoResult result = myPageQuery.query(voId);

        model.addAttribute("user", result.getUser());

        return "myPage";
    }

    @Logging
    @RequestMapping(value = "/likedProductPage")
    public String likedProduct() {

        return "likedProduct";
    }

    @Logging
    @RequestMapping(value = "/signup")
    public String signup() {

        return "signup";
    }

    @Logging
    @RequestMapping(value = "/saleBoard")
    public String saleBoard(Model model) {

        List<FindAllBooksVO> bookList = bookMybatisService.findAllBooksForSaleBoard();
        System.out.println(bookList);
        model.addAttribute("books", bookList);

        return "saleBoard";
    }

    @Logging
    @RequestMapping(value = "/registerBook")
    public String registerBook() {

        return "registerBook";
    }
}
