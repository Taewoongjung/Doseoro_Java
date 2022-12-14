package com.myproject.doseoro.application.book.vo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@ToString
@Getter
@Builder
public class RegisterDonationBookVO {

    private final String title;
    private final String author;
    private final String publisher;
    private final List<String> checkCategory;
    private final List<String> checkState;
    private final String dealRoot;
    private final String sold;
    private final String about;
    private String id;
    private String postmessage;
    private List<String> images;
    private String ownerId;
    private String ownerEmail;
    private int flagForDonationBook;

    public RegisterDonationBookVO(
        final String title,
        final String author,
        final String publisher,
        final List<String> checkCategory,
        final List<String> checkState,
        final String dealRoot,
        final String sold,
        final String about,
        final String id,
        final String postmessage,
        final List<String> images,
        final String ownerId,
        final String ownerEmail,
        final int flagForDonationBook
    ) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.checkCategory = checkCategory;
        this.checkState = checkState;
        this.dealRoot = dealRoot;
        this.sold = sold;
        this.about = about;
        this.id = id;
        this.postmessage = postmessage;
        this.images = images;
        this.ownerId = ownerId;
        this.ownerEmail = ownerEmail;
        this.flagForDonationBook = 1;
    }

    public void imbueImages(final List<String> images) {
        this.images = images;
    }

    public void imbueId() {
        String uuid = UUID.randomUUID().toString();
        this.id = uuid;
    }

    public void imbueOwnerId(final String ownerId) {
        this.ownerId = ownerId;
    }


    public void multipleImageFileHandle(List<MultipartFile> multipartFile,
        RegisterDonationBookVO vo)
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
