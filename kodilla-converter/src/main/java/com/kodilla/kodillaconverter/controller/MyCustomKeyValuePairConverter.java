package com.kodilla.kodillaconverter.controller;

import com.kodilla.kodillaconverter.domain.MyCustomDto;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class MyCustomKeyValuePairConverter implements HttpMessageConverter<Object> {

    @Override
    public boolean canRead(Class<?> clazz, MediaType mediaType) {
        return clazz.getName().equals("com.kodilla.kodillaconverter.domain.MyCustomDto") &&
                mediaType.getSubtype().equals("plain") && mediaType.getType().equals("text");
    }

    @Override
    public boolean canWrite(Class<?> clazz, MediaType mediaType) {
        return clazz.getName().equals("com.kodilla.kodillaconverter.domain.MyCustomDto") &&
                mediaType.getSubtype().equals("plain") && mediaType.getType().equals("text");
    }

    @Override
    public List<MediaType> getSupportedMediaTypes() {
        return List.of(MediaType.ALL);
    }

    @Override
    public Object read(Class<?> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {

        StringBuilder builder = new StringBuilder();

        try (Reader reader = new BufferedReader(
                new InputStreamReader(inputMessage.getBody(), StandardCharsets.UTF_8))) {

            int c = 0;
            while ((c = reader.read()) != -1) {
                builder.append((char) c);
            }
        }
        String[] pairs = builder.toString().split(";");

        String fieldOne = null;
        String fieldTwo = null;
        String fieldThree = null;

        for (String pair : pairs) {
            String[] keyValue = pair.split("=");
            String key = keyValue[0].trim();
            String value = keyValue[1].trim();

            switch (key) {
                case "fieldOne":
                    fieldOne = value;
                    break;
                case "fieldTwo":
                    fieldTwo = value;
                    break;
                case "fieldThree":
                    fieldThree = value;
                    break;
            }
        }
        return new MyCustomDto(fieldOne, fieldTwo, fieldThree);
    }

    @Override
    public void write(Object o, MediaType contentType, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {

    }
}
