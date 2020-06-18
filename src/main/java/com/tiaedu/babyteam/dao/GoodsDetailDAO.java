package com.tiaedu.babyteam.dao;

import com.tiaedu.babyteam.entity.GoodsDetail;

import java.util.List;

public interface GoodsDetailDAO {
    public List<GoodsDetail> findByGoodsId(Long goodsId);
}
