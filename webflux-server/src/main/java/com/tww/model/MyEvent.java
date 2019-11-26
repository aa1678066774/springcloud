package com.tww.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @program: root
 * @description:
 * @author: weiweiTang
 * @create: 2019-11-25 15:46
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "event") // 1
public class MyEvent {
    @Id
    private Long id;    // 2
    private String message;
}
