package com.tiaedu.babyteam.dao;

import com.tiaedu.babyteam.entity.Goods;

import java.util.List;

public interface GoodsDAO {
    public Goods findById(Long goodsId);
    public List<Goods> findAll();
    public List<Goods> findLast5M();
}
