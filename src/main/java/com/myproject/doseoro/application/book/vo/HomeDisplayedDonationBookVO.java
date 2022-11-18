package com.myproject.doseoro.application.book.vo;

import java.util.List;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@Builder
@NoArgsConstructor
public class HomeDisplayedDonationBookVO {

    private String id;
    private String title;
    private String about;
    private List<String> images;

    public HomeDisplayedDonationBookVO(
        final String id,
        final String title,
        final String about,
        final List<String> images
    ) {
        this.id = id;
        this.title = title;
        this.about = about;
        this.images = images;
    }
}
