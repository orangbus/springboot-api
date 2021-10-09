package com.orangbus.video.empty;

import java.io.Serializable;
import java.util.Date;
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

    private Date createdAt;

    private Date updatedAt;

    private static final long serialVersionUID = 1L;
}