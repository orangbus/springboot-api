package com.orangbus.video.controller;

import com.orangbus.video.common.ApiResponse;
import com.orangbus.video.dao.ChannelsDao;
import com.orangbus.video.empty.Channels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Channel {

    @Autowired
    private ChannelsDao channels;

    @GetMapping("/channel")
    public ApiResponse index(){
        List<Channels> channelsList = this.channels.selectList(null);
        return ApiResponse.success(channelsList);
    }
}
