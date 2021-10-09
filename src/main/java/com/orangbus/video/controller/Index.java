package com.orangbus.video.controller;
import com.orangbus.video.common.ApiResponse;
import com.orangbus.video.dao.JokesDao;
import com.orangbus.video.dao.VideosDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Controller
public class Index {
    @Autowired
    private JokesDao jokesDao;

    @Autowired
    private VideosDao videosDao;

    /**
     * 首页
     * @return
     */
    @GetMapping("/")
    public String index(HttpServletRequest request, Model model){
        Integer jokeCount = jokesDao.selectCount(null);
        Integer videoCount = videosDao.selectCount(null);
        model.addAttribute("host","http://"+request.getServerName()+":"+request.getServerPort());
        model.addAttribute("joke_count",jokeCount);
        model.addAttribute("video_count",videoCount);
        model.addAttribute("message","简易Api接口");
        model.addAttribute("title","首页");
        model.addAttribute("qq","http://google.com");
        return "index";
    }

    @GetMapping("/joke")
    public String joke(HttpServletRequest request, Model model){
        model.addAttribute("host","http://"+request.getServerName()+":"+request.getServerPort());
        return "joke/index";
    }

    @GetMapping("/video")
    public String video(HttpServletRequest request, Model model){
        model.addAttribute("title","视频");
        model.addAttribute("host","http://"+request.getServerName()+":"+request.getServerPort());
        return "video/index";
    }

    @GetMapping("/channel")
    public String channel(HttpServletRequest request, Model model){
        model.addAttribute("title","电视直播");
        model.addAttribute("host","http://"+request.getServerName()+":"+request.getServerPort());
        return "channel/index";
    }

    /**
     * 接口文档
     */
    @GetMapping("/doc")
    public String readme(){
        return "doc";
    }
}
