package com.myproject.doseoro.application.identity.readmodel;

import com.myproject.doseoro.adaptor.global.util.session.AccessUserSessionManager;
import com.myproject.doseoro.application.abstraction.IdentityRepository;
import com.myproject.doseoro.application.identity.dto.GetUserInformationDtoResult;
import com.myproject.doseoro.application.identity.vo.IdentityMyPageVO;
import com.myproject.doseoro.identity.IdentityMyPageVOFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetUserInformationQueryTest {

    @InjectMocks
    GetUserInformationQuery getUserInformationQuery;

    @Mock
    private IdentityRepository identityRepository;

    @Mock
    private AccessUserSessionManager accessUserSessionManager;

    @Test
    @DisplayName("해당 유저의 유저 정보를 불러온다.")
    void getUser() {

        IdentityMyPageVO identity = IdentityMyPageVOFixture.identityMyPageVO;

        when(accessUserSessionManager.extractUser()).thenReturn("12312315256787");
        when(identityRepository.findUserById("12312315256787")).thenReturn(identity);

        GetUserInformationDtoResult actual = getUserInformationQuery.query(null);

        assertThat(actual).isNotNull();
        assertThat(actual.getUser().getId()).isEqualTo("12312315256787");
        assertThat(actual.getUser().getEmail()).isEqualTo("a@a.com");
        assertThat(actual.getUser().getName()).isEqualTo("홍길동");
        assertThat(actual.getUser().getNickName()).isEqualTo("길도이");
        assertThat(actual.getUser().getPhone()).isEqualTo("010-2111-7777");
        assertThat(actual.getUser().getLocation()).isEqualTo("경기도 용인시 보정동");
        assertThat(actual.getUser().getDong()).isEqualTo("보정동");
        assertThat(actual.getUser().getSi()).isEqualTo("용인시");
        assertThat(actual.getUser().getDou()).isEqualTo("경기도");
        assertThat(actual.getUser().getProvider()).isEqualTo("kakao");
        assertThat(actual.getUser().getSnsId()).isEqualTo("12321-11");
        assertThat(actual.getUser().getUpdatedAt()).isEqualTo("11-11-11");
    }
}
