package com.myproject.doseoro.adaptor.api.book.controller;

import com.myproject.doseoro.adaptor.logger.Logging;
import com.myproject.doseoro.application.book.dto.GetAllInformationOfBuyingBookByBookIdDto;
import com.myproject.doseoro.application.book.dto.GetAllInformationOfBuyingBookByBookIdDtoResult;
import com.myproject.doseoro.application.book.dto.GetAllInformationOfTheBookByBookIdDto;
import com.myproject.doseoro.application.book.dto.GetAllInformationOfTheBookByBookIdDtoResult;
import com.myproject.doseoro.application.book.handler.AddHitWhenBookClickedCommandHandler;
import com.myproject.doseoro.application.book.handler.HitLikeCommandHandler;
import com.myproject.doseoro.application.book.handler.HitReLikeCommandHandler;
import com.myproject.doseoro.application.book.handler.RegisterBookCommandHandler;
import com.myproject.doseoro.application.book.handler.RegisterBuyingBookCommandHandler;
import com.myproject.doseoro.application.book.handler.RegisterDonationBookCommandHandler;
import com.myproject.doseoro.application.book.readmodel.GetAllInformationOfBuyingBookByBookIdQuery;
import com.myproject.doseoro.application.book.readmodel.GetAllInformationOfTheBookByBookIdQuery;
import com.myproject.doseoro.application.book.readmodel.GetHomeDisplayingBooksQuery;
import com.myproject.doseoro.application.book.vo.BookHitVO;
import com.myproject.doseoro.application.book.vo.RegisterBookVO;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class BookAPIcontroller {

    private final RegisterBookCommandHandler registerBookCommandHandler;
    private final RegisterDonationBookCommandHandler registerDonationBookCommandHandler;
    private final RegisterBuyingBookCommandHandler registerBuyingBookCommandHandler;
    private final GetHomeDisplayingBooksQuery findHomeDisplayingBooksCommandHandler;
    private final HitLikeCommandHandler hitLikeCommandHandler;
    private final HitReLikeCommandHandler hitReLikeCommandHandler;
    private final GetAllInformationOfTheBookByBookIdQuery bookDetailPageQuery;

    private final GetAllInformationOfBuyingBookByBookIdQuery buyingBookDetailPageQuery;
    private final AddHitWhenBookClickedCommandHandler addHitWhenBookClickedCommandHandler;

    @Logging
    @PostMapping(value = "/book/books")
    public String registerBook(@RequestParam("img") List<MultipartFile> multipartFile,
        RegisterBookVO vo) {

        try {
            vo.multipleImageFileHandle(multipartFile, vo);
            registerBookCommandHandler.handle(vo);
        } catch (Exception e) { // BussinessException 로직 추가하기
            e.printStackTrace();
        }

        return "redirect:/saleBoard";
    }

    @Logging
    @PostMapping(value = "/book/donations")
    public String registerDonationBook(@RequestParam("img") List<MultipartFile> multipartFile,
        RegisterBookVO vo) {

        try {
            vo.multipleImageFileHandle(multipartFile, vo);
            registerDonationBookCommandHandler.handle(vo);
        } catch (Exception e) { // BussinessException 로직 추가하기
            e.printStackTrace();
        }

        return "redirect:/donationBoard";
    }

    @Logging
    @PostMapping(value = "/book/buy")
    public String registerBuyingBook(RegisterBookVO vo) {

        registerBuyingBookCommandHandler.handle(vo);

        return "redirect:/buyingBoard";
    }

    @Logging
    @GetMapping(value = "/{bookId}")
    public ModelAndView bookDetailPage(ModelAndView model, @PathVariable String bookId) {

        try {
            GetAllInformationOfTheBookByBookIdDtoResult result = bookDetailPageQuery.query(
                new GetAllInformationOfTheBookByBookIdDto(bookId));
            addHitWhenBookClickedCommandHandler.handle(bookId);

            model.setViewName("saleDetail");
            model.addObject("user", result.getBook().getUserNickName());
            model.addObject("title", result.getBook().getPostMessage());
            model.addObject("book", result.getBook());
            model.addObject("countLike", result.getCountLikedInTheBook().size());
            if (result.getIsLikeExisted() != null) {
                model.addObject("isLiked", true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }

    @Logging
    @GetMapping(value = "/buy/{bookId}")
    public ModelAndView buyingBookDetailPage(ModelAndView model, @PathVariable String bookId) {

        try {
            GetAllInformationOfBuyingBookByBookIdDtoResult result = buyingBookDetailPageQuery.query(
                new GetAllInformationOfBuyingBookByBookIdDto(bookId));
            addHitWhenBookClickedCommandHandler.handle(bookId);

            model.setViewName("buyingBookDetail");
            model.addObject("user", result.getUser());
            model.addObject("title", result.getBook().getPostMessage());
            model.addObject("book", result.getBook());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }

    @Logging
    @PostMapping(value = "/like")
    public String hitLike(BookHitVO vo) {
        BookHitVO alreadyLiked = hitReLikeCommandHandler.handle(vo);
        if (alreadyLiked.getId() != null || vo.getId() != null) {
            return "redirect:/" + vo.getBookId();
        }

        // hitLikeCommandHandler 핸들러에서 id 값을 넣어 주니까
        // id 값이 있으면(null 이 아니면) 다시 row 를 생성할 필요가 없으니 null 리턴

        hitLikeCommandHandler.handle(vo);

        return "redirect:/" + vo.getBookId();
    }
}
