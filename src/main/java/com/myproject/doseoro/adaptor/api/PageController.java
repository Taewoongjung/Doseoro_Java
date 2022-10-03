package com.myproject.doseoro.adaptor.api;

import com.myproject.doseoro.adaptor.logger.Logging;
import com.myproject.doseoro.application.book.handler.FindHomeDisplayingBooksCommandHandler;
import com.myproject.doseoro.application.book.readmodel.GetLikedBooksByUserQuery;
import com.myproject.doseoro.application.book.readmodel.GetAllSaleBooksQuery;
import com.myproject.doseoro.application.book.vo.HomeDisplayedBookVO;
import com.myproject.doseoro.application.identity.readmodel.GetUserInformationQuery;
import com.myproject.doseoro.application.book.dto.GetLikedBooksByUserDtoResult;
import com.myproject.doseoro.application.book.dto.GetAllSaleBooksResult;
import com.myproject.doseoro.application.identity.dto.GetUserInformationDtoResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PageController {

    private final FindHomeDisplayingBooksCommandHandler findHomeDisplayingBooksCommandHandler;
    private final GetUserInformationQuery myPageQuery;
    private final GetAllSaleBooksQuery saleBoardQuery;
    private final GetLikedBooksByUserQuery getLikedBooksByUserQuery;



    Void voId = null;

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

        GetUserInformationDtoResult result = myPageQuery.query(voId);

        model.addAttribute("user", result.getUser());

        return "myPage";
    }

    @Logging
    @RequestMapping(value = "/likedProductPage")
    public String likedProduct(Model model) {

        GetLikedBooksByUserDtoResult books = getLikedBooksByUserQuery.query(voId);
        model.addAttribute("books", books.getLikedBooks());

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

        GetAllSaleBooksResult bookList = saleBoardQuery.query(voId);
        model.addAttribute("books", bookList.getBookList());

        return "saleBoard";
    }

    @Logging
    @RequestMapping(value = "/registerBook")
    public String registerBook() {

        return "registerBook";
    }
}
