package com.example.user.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Noob
 * @date 2021/12/13 - 20:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonResult<E> implements Serializable {
    private Integer state;
    private String message;
    private E data;

}
