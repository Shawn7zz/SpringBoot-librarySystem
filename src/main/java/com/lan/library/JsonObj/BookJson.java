package com.lan.library.JsonObj;

import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Xiang Lan
 * Created on 2019-07-02 14:52
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookJson {

    private List<Items> items;
}
