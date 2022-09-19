package com.myproject.doseoro.packages.identity.vo;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class IdentityMyPageVO {
    private String id;
    private String email;
    private String name;
    private String nickName;
    private String phone;
    private String liked;
    private String location;
    private String dong;
    private String si;
    private String dou;
    private String provider;
    private String snsId;
    private String updatedAt;

    public IdentityMyPageVO(String id, String email, String name, String nickName, String phone, String liked, String location, String dong, String si, String dou, String provider, String snsId, String updatedAt) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.nickName = nickName;
        this.phone = phone;
        this.liked = liked;
        this.location = location;
        this.dong = dong;
        this.si = si;
        this.dou = dou;
        this.provider = provider;
        this.snsId = snsId;
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "MyPageIdentityVO{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", phone='" + phone + '\'' +
                ", liked='" + liked + '\'' +
                ", location='" + location + '\'' +
                ", dong='" + dong + '\'' +
                ", si='" + si + '\'' +
                ", dou='" + dou + '\'' +
                ", provider='" + provider + '\'' +
                ", snsId='" + snsId + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IdentityMyPageVO that = (IdentityMyPageVO) o;
        return Objects.equals(id, that.id) && Objects.equals(email, that.email) && Objects.equals(name, that.name) && Objects.equals(nickName, that.nickName) && Objects.equals(phone, that.phone) && Objects.equals(liked, that.liked) && Objects.equals(location, that.location) && Objects.equals(dong, that.dong) && Objects.equals(si, that.si) && Objects.equals(dou, that.dou) && Objects.equals(provider, that.provider) && Objects.equals(snsId, that.snsId) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, name, nickName, phone, liked, location, dong, si, dou, provider, snsId, updatedAt);
    }
}
