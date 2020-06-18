package com.tiaedu.babyteam.dao;

import com.tiaedu.babyteam.entity.Evaluate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EvaluateDAO {
    public List<Evaluate> findByGoodsId(@Param("goodsId") Long goodsId);
}
