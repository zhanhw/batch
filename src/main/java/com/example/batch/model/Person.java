package com.example.batch.model;

import lombok.*;

/**
 * 人信息
 *
 * @author aw
 * @date 2021/1/8 16:09
 */
@Builder
@ToString
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    private String name;

    private int age;

    private String nation;

    private String address;

}
