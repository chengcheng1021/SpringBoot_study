package com.cc1021.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
// 在企业中，我们所有的 pojo 都会序列化！
public class User {

    private String name;
    private Integer age;
}
