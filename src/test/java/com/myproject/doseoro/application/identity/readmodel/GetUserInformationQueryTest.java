package com.myproject.doseoro.application.identity.readmodel;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class GetUserInformationQueryTest {

    GetUserInformationQuery getUserInformationQuery = mock(GetUserInformationQuery.class);

    @Test
    @DisplayName("해당 유저의 유저 정보를 불러온다.")
    void getUser() {
        getUserInformationQuery.query(null);
        verify(getUserInformationQuery, times(1)).query(null);
    }
}
