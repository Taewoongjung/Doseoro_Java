package com.myproject.doseoro.api;

import com.myproject.doseoro.packages.book.handler.FindHomeDisplayingBooksCommandHandler;
import com.myproject.doseoro.packages.book.vo.HomeDisplayedBookVO;
import com.myproject.doseoro.packages.identity.vo.IdentityMyPageVO;
import com.myproject.doseoro.packages.infra.mybatis.identity.IdentityMybatisService;
import com.myproject.doseoro.packages.infra.session.AccessUserSessionManager;
import lombok.RequiredArgsConstructor;
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

    @RequestMapping(value = "/")
    public String home(Model model) {
        // 홈화면에서 최근 판매목록 5개 가져오기
        System.out.println("home called");

        Void unused = null;
        List<HomeDisplayedBookVO> list = findHomeDisplayingBooksCommandHandler.handle(unused);

        model.addAttribute("books", list);
        return "home";
    }

    @RequestMapping(value = "/login")
    public String login() {
        System.out.println("login called");
        return "login";
    }

    @RequestMapping(value = "/mypage")
    public String myPage(Model model) {
        System.out.println("mypage called");
        String userId = accessUserSessionManager.extractUser();

        IdentityMyPageVO thisUser = identityRepository.findUserById(userId);

        model.addAttribute("user", thisUser);

        return "myPage";
    }

    @RequestMapping(value = "/likedProductPage")
    public String likedProduct() {
        System.out.println("likedProductPage called");

        return "likedProduct";
    }

    @RequestMapping(value = "/signup")
    public String signup() {
        System.out.println("signup called");
        return "signup";
    }

    @RequestMapping(value = "/saleBoard")
    public String sale() {
        System.out.println("saleBoard called");
        return "saleBoard";
    }

    @RequestMapping(value = "/registerBook")
    public String registerBook() {
        System.out.println("registerBook called");
        return "registerBook";
    }
}
