package com.orangbus.video.empty;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * videos
 * @author 
 */
@Data
public class Videos implements Serializable {
    private Long id;

    /**
     * 可用状态，默认1，可用，2：不可用
     */
    private Integer status;

    /**
     * 来源
     */
    private String siteName;

    /**
     * 标题
     */
    private String title;

    /**
     * 分类ID
     */
    private Integer cateId;

    /**
     * 分类名称
     */
    private String typeName;

    /**
     * 视频ID
     */
    private String vodId;

    /**
     * 图片
     */
    private String pic;

    /**
     * 地区
     */
    private String area;

    /**
     * 语言
     */
    private String lang;

    /**
     * 年份
     */
    private String year;

    /**
     * 介绍
     */
    private String content;

    /**
     * 下载链接
     */
    private String downloadUrl;

    /**
     * 下载链接属性
     */
    private String downloadUrlTag;

    /**
     * 播放链接
     */
    private String playUrl;

    /**
     * 播放类型
     */
    private String playUrlTag;

    /**
     * 播放统计
     */
    private Integer playCount;

    /**
     * 浏览统计
     */
    private Integer visitCount;

    /**
     * 错误统计次数
     */
    private Integer errorCount;

    /**
     * 喜欢
     */
    private Integer likes;

    /**
     * 不喜欢
     */
    private Integer unlikes;

    /**
     * 反馈处理级别，默认0：不处理，1：一级紧急，以此类推上去
     */
    private Byte level;

    private Date createdAt;

    private Date updatedAt;

    private static final long serialVersionUID = 1L;
}