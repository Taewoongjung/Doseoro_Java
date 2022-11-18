package com.myproject.doseoro.adaptor.api;

import com.myproject.doseoro.adaptor.logger.Logging;
import com.myproject.doseoro.application.book.dto.GetAllBuyingBooksResult;
import com.myproject.doseoro.application.book.dto.GetAllDonationBooksResult;
import com.myproject.doseoro.application.book.dto.GetAllSaleBooksResult;
import com.myproject.doseoro.application.book.dto.GetLikedBooksByUserDtoResult;
import com.myproject.doseoro.application.book.handler.FindHomeDisplayingBooksCommandHandler;
import com.myproject.doseoro.application.book.readmodel.GetAllBuyingBooksQuery;
import com.myproject.doseoro.application.book.readmodel.GetAllDonationBooksQuery;
import com.myproject.doseoro.application.book.readmodel.GetAllSaleBooksQuery;
import com.myproject.doseoro.application.book.readmodel.GetHomeDisplayingBuyingBooksQuery;
import com.myproject.doseoro.application.book.readmodel.GetLikedBooksByUserQuery;
import com.myproject.doseoro.application.book.vo.HomeDisplayedBuyingBookVO;
import com.myproject.doseoro.application.book.vo.HomeDisplayedSaleBookVO;
import com.myproject.doseoro.application.identity.dto.GetUserInformationDtoResult;
import com.myproject.doseoro.application.identity.readmodel.GetUserInformationQuery;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class PageController {

    private final FindHomeDisplayingBooksCommandHandler findHomeDisplayingBooksCommandHandler;
    private final GetUserInformationQuery myPageQuery;
    private final GetAllSaleBooksQuery saleBoardQuery;
    private final GetAllDonationBooksQuery donationBooksQuery;
    private final GetLikedBooksByUserQuery getLikedBooksByUserQuery;
    private final GetAllSaleBooksQuery getAllSaleBooksQuery;
    private final GetAllDonationBooksQuery getAllDonationBooksQuery;
    private final GetAllBuyingBooksQuery getAllBuyingBooksQuery;
    private final GetHomeDisplayingBuyingBooksQuery getHomeDisplayingBuyingBooksQuery;


    Void voId = null;

    @Logging
    @RequestMapping(value = "/")
    public String home(Model model) {
        // 홈화면에서 최근 판매목록 5개 가져오기

        Void unused = null;
        List<HomeDisplayedSaleBookVO> allSaleBooks
            = findHomeDisplayingBooksCommandHandler.handle(unused);
        GetAllDonationBooksResult allDonationBooks = getAllDonationBooksQuery.query(unused);
        List<HomeDisplayedBuyingBookVO> allBuyingBooks
            = getHomeDisplayingBuyingBooksQuery.query(unused);
        
        model.addAttribute("saleBooks", allSaleBooks);
        model.addAttribute("donationBooks", allDonationBooks.getBookList());
        model.addAttribute("buyingBooks", allBuyingBooks);
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
        if (books != null) {
            model.addAttribute("books", books.getLikedBooks());
        }

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
    @RequestMapping(value = "/donationBoard")
    public String donationBoard(Model model) {

        GetAllDonationBooksResult bookList = donationBooksQuery.query(voId);
        model.addAttribute("books", bookList.getBookList());

        return "donationBoard";
    }

    @Logging
    @RequestMapping(value = "/buyingBoard")
    public String buyingBoard(Model model) {

        GetAllBuyingBooksResult bookList = getAllBuyingBooksQuery.query(voId);
        model.addAttribute("books", bookList.getBookList());

        return "buyingBoard";
    }

    @Logging
    @RequestMapping(value = "/registerBook")
    public String registerBook() {

        return "registerBook";
    }

    @Logging
    @RequestMapping(value = "/registerDonationBook")
    public String registerDonationBook() {

        return "registerDonation";
    }

    @Logging
    @RequestMapping(value = "/registerBuyingBook")
    public String registerBuyingBook() {

        return "registerBuying";
    }
}
