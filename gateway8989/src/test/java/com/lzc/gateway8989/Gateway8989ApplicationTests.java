package com.lzc.gateway8989;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.ZonedDateTime;


class Gateway8989ApplicationTests {

    public static void main(String[] args) {
        ZonedDateTime time =  ZonedDateTime.now();
        System.out.println(time);
    }

}
