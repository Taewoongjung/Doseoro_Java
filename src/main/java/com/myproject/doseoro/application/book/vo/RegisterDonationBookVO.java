package com.myproject.doseoro.application.book.vo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

@Getter
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

    public RegisterDonationBookVO(String id, String postmessage, String title, String author,
        String publisher, List<String> checkCategory, List<String> checkState, List<String> images,
        String dealRoot, String sold, String about, String ownerId, String ownerEmail,
        int flagForDonationBook) {
        this.id = id;
        this.postmessage = postmessage;
        this.title = title;
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
        this.flagForDonationBook = 1;
    }

    @Override
    public String toString() {
        return "RegisterBookVO{" +
            "id='" + id + '\'' +
            ", postmessage='" + postmessage + '\'' +
            ", title='" + title + '\'' +
            ", author='" + author + '\'' +
            ", publisher='" + publisher + '\'' +
            ", checkCategory=" + checkCategory +
            ", checkState=" + checkState +
            ", images=" + images +
            ", dealRoot='" + dealRoot + '\'' +
            ", sold='" + sold + '\'' +
            ", about='" + about + '\'' +
            ", ownerId='" + ownerId + '\'' +
            ", ownerEmail='" + ownerEmail + '\'' +
            ", flagForDonationBook='" + flagForDonationBook + '\'' +
            '}';
    }

    public void imbueImages(List<String> images) {
        this.images = images;
    }

    public void imbueId(String id) {
        this.id = id;
    }

    public void imbueOwnerId(String ownerId) {
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
                String originalFileName = imgFile.getOriginalFilename(); //오리지날 파일명
                String extension = originalFileName.substring(
                    originalFileName.lastIndexOf(".")); //파일 확장자
                String savedFileName = UUID.randomUUID() + extension; //저장될 파일 명

                imageFileList.add(savedFileName);

                FileOutputStream fos = new FileOutputStream(file + savedFileName);
                InputStream is = imgFile.getInputStream();
                {
                    // file로 부터 inputStream을 가져온다.

                    int readCount = 0;
                    byte[] buffer = new byte[1024];
                    // 파일을 읽을 크기 만큼의 buffer를 생성하고
                    // ( 보통 1024, 2048, 4096, 8192 와 같이 배수 형식으로 버퍼의 크기를 잡는 것이 일반적이다.)

                    while ((readCount = is.read(buffer)) != -1) {
                        //  파일에서 가져온 fileInputStream을 설정한 크기 (1024byte) 만큼 읽고

                        fos.write(buffer, 0, readCount);
                        // 위에서 생성한 fileOutputStream 객체에 출력하기를 반복한다
                    }

                }
            }
        }
        vo.imbueImages(imageFileList);
    }
}
