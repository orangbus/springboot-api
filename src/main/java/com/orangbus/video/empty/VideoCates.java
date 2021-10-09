package com.orangbus.video.empty;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * video_cates
 * @author 
 */
@Data
public class VideoCates implements Serializable{
    private Long id;

    /**
     * 分类名称
     */
    private String name;

    /**
     * 原始分类ID
     */
    private String vid;

    /**
     * 来源名称
     */
    private String fromName;

    /**
     * 排序
     */
    private Integer sort;

    private Date createdAt;

    private Date updatedAt;

    private static final long serialVersionUID = 1L;
}