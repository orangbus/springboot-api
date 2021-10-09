package com.orangbus.video.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.orangbus.video.common.ApiResponse;
import com.orangbus.video.common.ApiResponsePage;
import com.orangbus.video.dao.JokeCatesDao;
import com.orangbus.video.dao.JokesDao;
import com.orangbus.video.empty.JokeCates;
import com.orangbus.video.empty.Jokes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api") //统一前缀
public class Joke {
    @Autowired
    private JokesDao jokesDao;
    @Autowired
    private JokeCatesDao jokeCates;

    /**
     * 段子列表
     * @return
     */
    @GetMapping("joke")
    public ApiResponsePage joke(
            @RequestParam(name = "page",defaultValue = "1") int page,
            @RequestParam(name = "limit",defaultValue = "15") int limit,
            @RequestParam(name="cate_id",defaultValue = "0") int cateId
    ){
        QueryWrapper<Jokes> jokesQueryWrapper = new QueryWrapper<>();
        if (cateId > 0){
            jokesQueryWrapper.eq("cate_id",cateId);
        }
        IPage<Jokes> ipage = new Page<>(page, limit);
        IPage<Jokes> jokesList = jokesDao.selectPage(ipage, jokesQueryWrapper);
        return ApiResponsePage.success(jokesList.getRecords(),(int)jokesList.getTotal());
    }

    /**
     * 段子详情
     * @return
     */
    @GetMapping("joke/detail")
    public ApiResponse jokeDetail(@RequestParam int id){
        Jokes joke = jokesDao.selectById(id);
        return ApiResponse.success(joke);
    }

    /**
     * 分类列表
     * @return
     */
    @GetMapping("joke/cate")
    public ApiResponse jokeCate(){
        List<JokeCates> jokeCatesList = jokeCates.selectList(null);
        return ApiResponse.success(jokeCatesList);
    }
}
