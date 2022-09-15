package com.myproject.doseoro.global.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@MappedTypes({Object.class})
public class JsonTypeHandler extends BaseTypeHandler<List<String>> {

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, List<String> s, JdbcType jdbcType) throws
            SQLException {
        preparedStatement.setObject(i, new Gson().toJson(s));

    }

    @Override
    public List<String> getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return convertToList(resultSet.getString(s));
    }

    @Override
    public List<String> getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return convertToList(resultSet.getString(i));
    }

    @Override
    public List<String> getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return convertToList(callableStatement.getString(i));
    }

    private List<String> convertToList(String myJsonDataListAsString) {
        try {
            return new ObjectMapper().readValue(myJsonDataListAsString, new TypeReference<List<String>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}

// .NoClassDefFoundError: com/google/gson/Gson] 오류가 나기 때문에 jar 파일을 라이브러리로 추가하면 될듯