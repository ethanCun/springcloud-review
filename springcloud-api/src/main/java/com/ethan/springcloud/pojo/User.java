package com.ethan.springcloud.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true) //链式写法
//注意需要序列化 rpc或者http传输的对象都需要序列化
public class User implements Serializable {

    //设置 -》 inspection -> 勾选serialization issues: Serializable class
    // without serialVersionUID -》apply -》选择class名称 -》alt+enter选择生成
    private static final long serialVersionUID = 8624391022644989777L;

    private Integer id;
    private String name;
    private String age;

    //表示是存在哪个数据库的字段, 因为同一个信息可能存在不同的数据库
    private String dbSource;

}
