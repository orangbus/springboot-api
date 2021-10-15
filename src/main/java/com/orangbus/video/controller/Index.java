package com.orangbus.video.controller;

import com.orangbus.video.dao.ChannelsDao;
import com.orangbus.video.dao.JokesDao;
import com.orangbus.video.dao.VideosDao;
import com.orangbus.video.empty.Channels;
import com.orangbus.video.empty.Jokes;
import com.orangbus.video.exception.NotFondException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

@Controller
public class Index {
    @Autowired
    private JokesDao jokesDao;

    @Autowired
    private VideosDao videosDao;

    @Autowired
    private ChannelsDao channels;

    @GetMapping("/test")
    public String Test(){
        int i = 9/0;
        String user = null;
        if (user == null){
            throw new NotFondException("用户不能为空！");
        }
        return "error/500";
    }

    private HashMap about() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("qq群", "https://jq.qq.com/?_wv=1027&k=0skWPaUx");
        hashMap.put("github", "http://github.com/orangbus");
        hashMap.put("博客", "https://doc.orangbus.cn");
        hashMap.put("电报群", "https://t.me/joinchat/FOho4eXM_9gXnd0y");
        return hashMap;
    }

    private String getHost(){

        return "http://java.orangbus.cn";
    }

    /**
     * 首页
     *
     * @return
     */
    @GetMapping("/")
    public String index(HttpServletRequest request, Model model) {
        Integer jokeCount = jokesDao.selectCount(null);
        Integer videoCount = videosDao.selectCount(null);
        Integer channelsCount = channels.selectCount(null);
//        model.addAttribute("host", "http://" + request.getServerName() + ":" + request.getServerPort());
        model.addAttribute("host", getHost());
        model.addAttribute("joke_count", jokeCount);
        model.addAttribute("video_count", videoCount);
        model.addAttribute("channel_count", channelsCount);
        model.addAttribute("message", "简易Api接口");
        model.addAttribute("title", "首页");
        model.addAttribute("navList", about());
        return "index";
    }

    @GetMapping("/joke")
    public String joke(HttpServletRequest request, Model model) {
        Random random = new Random();
        Integer count = jokesDao.selectCount(null);
        int randomId = random.nextInt(count) + 1;
        Jokes joke = jokesDao.selectById(randomId);
        model.addAttribute("data", joke);
        model.addAttribute("host", getHost());
//        model.addAttribute("host", "http://" + request.getServerName() + ":" + request.getServerPort());
        model.addAttribute("navList", about());
        return "joke/index";
    }

    @GetMapping("/video")
    public String video(HttpServletRequest request, Model model) {
        model.addAttribute("title", "视频");
//        model.addAttribute("host", "http://" + request.getServerName() + ":" + request.getServerPort());
        model.addAttribute("host", getHost());
        model.addAttribute("navList", about());
        return "video/index";
    }

    @GetMapping("/channel")
    public String channel(HttpServletRequest request, Model model) {
        List<Channels> channels = this.channels.selectList(null);
        model.addAttribute("title", "电视直播");
//        model.addAttribute("host", "http://" + request.getServerName() + ":" + request.getServerPort());
        model.addAttribute("host", getHost());
        model.addAttribute("lists", channels);
        model.addAttribute("navList", about());
        return "channel/index";
    }

    /**
     * 电视播放
     */
    @GetMapping("channel/player")
    public String channelPlayer(@RequestParam int id, Model model) {
        Channels channels = this.channels.selectById(id);
        model.addAttribute("data", channels);
        model.addAttribute("title", "电视直播");
        model.addAttribute("navList", about());
        return "channel/player";
    }

    /**
     * m3u8解析播放
     */
    @GetMapping("/m3u8")
    public String M3u8(Model model) {
        model.addAttribute("title", "M3u8播放器");
        model.addAttribute("navList", about());
        return "channel/m3u8";
    }

    /**
     * 接口文档
     */
    @GetMapping("/doc")
    public String readme() {
        return "doc";
    }

    @GetMapping("/name")
    public String Name(Model model) {
        model.addAttribute("title", "M3u8播放器");
        model.addAttribute("navList", about());
        return "channel/m3u8";
    }
}
