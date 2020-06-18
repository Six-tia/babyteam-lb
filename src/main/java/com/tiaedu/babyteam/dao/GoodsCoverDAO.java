package com.tiaedu.babyteam.dao;

import com.tiaedu.babyteam.entity.GoodsCover;

import java.util.List;

public interface GoodsCoverDAO {
    public List<GoodsCover> findByGoodsId(Long goodsId);
}
