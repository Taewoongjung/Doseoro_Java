package com.myproject.doseoro.api;

import com.myproject.doseoro.packages.book.handler.FindHomeDisplayingBooksCommandHandler;
import com.myproject.doseoro.packages.book.vo.FindAllBooksVO;
import com.myproject.doseoro.packages.book.vo.HomeDisplayedBookVO;
import com.myproject.doseoro.packages.identity.vo.IdentityMyPageVO;
import com.myproject.doseoro.packages.infra.mybatis.book.BookMybatisService;
import com.myproject.doseoro.packages.infra.mybatis.identity.IdentityMybatisService;
import com.myproject.doseoro.packages.infra.session.AccessUserSessionManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PageController {

    private final FindHomeDisplayingBooksCommandHandler findHomeDisplayingBooksCommandHandler;
    private final AccessUserSessionManager accessUserSessionManager;
    private final IdentityMybatisService identityRepository;
    private final BookMybatisService bookMybatisService;

    @RequestMapping(value = "/")
    public String home(Model model) {
        // 홈화면에서 최근 판매목록 5개 가져오기

        Void unused = null;
        List<HomeDisplayedBookVO> list = findHomeDisplayingBooksCommandHandler.handle(unused);

        model.addAttribute("books", list);
        return "home";
    }

    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/mypage")
    public String myPage(Model model) {

        String userId = accessUserSessionManager.extractUser();

        IdentityMyPageVO thisUser = identityRepository.findUserById(userId);

        model.addAttribute("user", thisUser);

        return "myPage";
    }

    @RequestMapping(value = "/likedProductPage")
    public String likedProduct() {

        return "likedProduct";
    }

    @RequestMapping(value = "/signup")
    public String signup() {

        return "signup";
    }

    @RequestMapping(value = "/saleBoard")
    public String saleBoard(Model model) {

        List<FindAllBooksVO> bookList = bookMybatisService.findAllBooksForSaleBoard();
        System.out.println(bookList);
        model.addAttribute("books", bookList);

        return "saleBoard";
    }

    @RequestMapping(value = "/registerBook")
    public String registerBook() {

        return "registerBook";
    }
}
