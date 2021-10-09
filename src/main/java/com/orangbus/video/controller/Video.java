package com.orangbus.video.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.orangbus.video.common.ApiResponse;
import com.orangbus.video.common.ApiResponsePage;
import com.orangbus.video.dao.VideoCatesDao;
import com.orangbus.video.dao.VideosDao;
import com.orangbus.video.empty.VideoCates;
import com.orangbus.video.empty.Videos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api") //统一前缀
public class Video {
    @Autowired
    private VideosDao videosDao;
    @Autowired
    private VideoCatesDao videosCates;

    /**
     * 视频列表
     * @return
     */
    @GetMapping("video")
    public ApiResponsePage video(
            @RequestParam(name = "cate_id",defaultValue = "0") int cateId,
            @RequestParam(name = "page",defaultValue = "1") int page,
            @RequestParam(name = "limit",defaultValue = "15") int limit
    ){
        QueryWrapper<Videos> wrapper = new QueryWrapper<>();
        if (cateId != 0){
            wrapper.eq("cate_id",cateId);
        }
        IPage<Videos> ipage = new Page<>(page, limit);
        IPage<Videos> videoLists = videosDao.selectPage(ipage, wrapper);
        return ApiResponsePage.success(videoLists.getRecords(), (int) videoLists.getTotal());
    }

    /**
     * 视频详情
     * @return
     */
    @GetMapping("video/detail")
    public ApiResponse videoDetail(@RequestParam int id){
        Object video = videosDao.selectById(id);
        return ApiResponse.success(video);
    }

    /**
     * 视频分类
     * @return
     */
    @GetMapping("video/cate")
    public ApiResponse videoCate(){
        List<VideoCates> videoCatesList = videosCates.selectList(null);
        return ApiResponse.success(videoCatesList);
    }
}
