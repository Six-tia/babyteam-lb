package com.tiaedu.babyteam.dao;

import com.tiaedu.babyteam.entity.GoodsParam;

import java.util.List;

public interface GoodsParamDAO {
    public List<GoodsParam> findByGoodsId(Long goodsId);
}
