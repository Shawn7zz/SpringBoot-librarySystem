package com.lan.library.JsonObj;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Xiang Lan
 * Created on 2019-07-02 15:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VolumeInfo {

    private String title;

    private String[] authors;

    private String publisher;

    private String publishedDate;

    private String description;
}
