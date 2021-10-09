package com.orangbus.video.empty;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * jokes
 * @author 
 */
@Data
public class Jokes implements Serializable {
    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 分类ID
     */
    private Integer cateId;

    /**
     * 默认1：正常，2：关闭
     */
    private Byte status;

    /**
     * 作者
     */
    private String author;

    /**
     * 文章来源
     */
    private String formUrl;

    /**
     * 网站名称
     */
    private String siteName;

    /**
     * 发布时间
     */
    private String pushTime;

    /**
     * 内容
     */
    private String content;

    /**
     * 浏览统计
     */
    private Integer visit;

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