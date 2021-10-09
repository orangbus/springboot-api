package com.orangbus.video.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.orangbus.video.empty.JokeCates;

public interface JokeCatesDao extends BaseMapper<JokeCates> {
    int deleteByPrimaryKey(Long id);

    int insert(JokeCates record);

    int insertSelective(JokeCates record);

    JokeCates selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(JokeCates record);

    int updateByPrimaryKey(JokeCates record);
}