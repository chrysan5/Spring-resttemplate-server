package com.sparta.springresttemplateserver.service;

import com.sparta.springresttemplateserver.dto.ItemResponseDto;
import com.sparta.springresttemplateserver.dto.UserRequestDto;
import com.sparta.springresttemplateserver.entity.Item;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ItemService {

    private final List<Item> itemList = Arrays.asList(
            new Item("Mac", 3_888_000),
            new Item("iPad", 1_230_000),
            new Item("iPhone", 1_550_000),
            new Item("Watch", 450_000),
            new Item("AirPods", 350_000)
    );

    public Item getCallObject(String query) {
        for (Item item : itemList) {
            if(item.getTitle().equals(query)) { //받아온 query랑 위의 itemList랑 비교해서 같으면 리턴함
                return item;
            }
        }
        return null;
    }

    public ItemResponseDto getCallList() {
        ItemResponseDto responseDto = new ItemResponseDto();
        for (Item item : itemList) {
            responseDto.setItems(item);
        }
        return responseDto;
    }

    public Item postCall(String query, UserRequestDto userRequestDto) {
        //UserRequestDto 제대로 넘어왔는지 확인용으로 찍는것임
        System.out.println("userRequestDto.getUsername() = " + userRequestDto.getUsername());
        System.out.println("userRequestDto.getPassword() = " + userRequestDto.getPassword());

        return getCallObject(query);
    }

    public ItemResponseDto exchangeCall(String token, UserRequestDto requestDto) {
        System.out.println("token = " + token);
        System.out.println("requestDto.getUsername() = " + requestDto.getUsername());
        System.out.println("requestDto.getPassword() = " + requestDto.getPassword());

        return getCallList();
    }
}