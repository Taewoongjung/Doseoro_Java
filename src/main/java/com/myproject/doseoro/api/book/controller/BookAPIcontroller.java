package com.myproject.doseoro.api.book.controller;

import com.myproject.doseoro.packages.book.dto.RegisterBookDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.*;

@Controller()
public class BookAPIcontroller {

    @PostMapping(value = "/book/register")
    public String registerBook(@RequestParam("img") List<MultipartFile> multipartFile, RegisterBookDTO dto) throws IOException {
        System.out.println("try book register");

        List<String> imageFileList = dto.multipleImageFileHandle(multipartFile);

        dto.setImages(imageFileList);


        System.out.println(dto);
        return "redirect:/saleBoard";
    }
}
