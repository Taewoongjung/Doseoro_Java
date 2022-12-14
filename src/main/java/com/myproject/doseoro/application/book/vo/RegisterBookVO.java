package com.myproject.doseoro.application.book.vo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.Getter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@Getter
@ToString
public class RegisterBookVO {

    private String id;
    private String title;
    private String price;
    private String author;
    private String publisher;
    private List<String> checkCategory;
    private List<String> checkState;
    private List<String> images;
    private String dealRoot;
    private String sold;
    private String about;
    private String postmessage;
    private String ownerId;
    private String ownerEmail;

    public RegisterBookVO(
        final String id,
        final String postmessage,
        final String title,
        final String price,
        final String author,
        final String publisher,
        final List<String> checkCategory,
        final List<String> checkState,
        final List<String> images,
        final String dealRoot,
        final String sold,
        final String about,
        final String ownerId,
        final String ownerEmail
    ) {
        this.id = id;
        this.postmessage = postmessage;
        this.title = title;
        this.price = price;
        this.author = author;
        this.publisher = publisher;
        this.checkCategory = checkCategory;
        this.checkState = checkState;
        this.images = images;
        this.dealRoot = dealRoot;
        this.sold = sold;
        this.about = about;
        this.ownerId = ownerId;
        this.ownerEmail = ownerEmail;
    }

    public void imbueImages(List<String> images) {
        this.images = images;
    }

    public void imbueId() {
        String uuid = UUID.randomUUID().toString();
        this.id = uuid;
    }

    public void imbueOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }


    public void multipleImageFileHandle(List<MultipartFile> multipartFile, RegisterBookVO vo)
        throws IOException {
        String path = "/Users/jeongtaeung/Desktop/CODES/doseoro/src/main/resources/static/uploads/imgs/";
        File file = new File(path);

        List<String> imageFileList = new ArrayList<>();

        if (multipartFile.size() > 0 && !multipartFile.get(0).getOriginalFilename().equals("")) {
            for (MultipartFile imgFile : multipartFile) {
                String originalFileName = imgFile.getOriginalFilename(); //???????????? ?????????
                String extension = originalFileName.substring(
                    originalFileName.lastIndexOf(".")); //?????? ?????????
                String savedFileName = UUID.randomUUID() + extension; //????????? ?????? ???

                imageFileList.add(savedFileName);

                FileOutputStream fos = new FileOutputStream(file + savedFileName);
                InputStream is = imgFile.getInputStream();
                {
                    // file??? ?????? inputStream??? ????????????.

                    int readCount = 0;
                    byte[] buffer = new byte[1024];
                    // ????????? ?????? ?????? ????????? buffer??? ????????????
                    // ( ?????? 1024, 2048, 4096, 8192 ??? ?????? ?????? ???????????? ????????? ????????? ?????? ?????? ???????????????.)

                    while ((readCount = is.read(buffer)) != -1) {
                        //  ???????????? ????????? fileInputStream??? ????????? ?????? (1024byte) ?????? ??????

                        fos.write(buffer, 0, readCount);
                        // ????????? ????????? fileOutputStream ????????? ??????????????? ????????????
                    }

                }
            }
        }
        vo.imbueImages(imageFileList);
    }
}
