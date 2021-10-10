package com.orangbus.video.empty;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * channels
 * @author 
 */
@Data
public class Channels implements Serializable{
    private Long id;

    private String name;

    private String pcUrl;

    private String mUrl;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date createdAt;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date updatedAt;

    private static final long serialVersionUID = 1L;
}