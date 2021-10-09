package com.orangbus.video;

import com.orangbus.video.dao.JokesDao;
import com.orangbus.video.empty.Jokes;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

@SpringBootTest
class VideoApplicationTests {

//    @Autowired
//    private JokesDao jokesDao;

    @Test
    void contextLoads() {
    }

//    @Test
//    public void joke(){
//        Jokes jokes = jokesDao.selectById(1);
//        System.out.println(jokes);
//    }

    @Test
    public void randomTest(){
        Random random = new Random();
        int id = random.nextInt(10) +1;
        System.out.println(id);
    }

}
