package com.orangbus.video.empty;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * joke_cates
 * @author 
 */
@Data
public class JokeCates implements Serializable{
    private Long id;

    /**
     * 分类名称
     */
    private String name;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 来源名称
     */
    private String fromName;

    private Date createdAt;

    private Date updatedAt;

    private static final long serialVersionUID = 1L;
}