package com.tiaedu.babyteam.service;

import com.tiaedu.babyteam.dao.*;
import com.tiaedu.babyteam.entity.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsService {
    @Resource
    private GoodsDAO goodsDAO;
    @Resource
    private GoodsCoverDAO goodsCoverDAO;
    @Resource
    private GoodsDetailDAO goodsDetailDAO;
    @Resource
    private GoodsParamDAO goodsParamDAO;
    @Resource
    private EvaluateDAO evaluateDAO;
    //view -> controller -> service -> dao
    public Goods getGoods(Long goodsId) {
        return goodsDAO.findById(goodsId);
    }

    public List<GoodsCover> findCovers(Long goodsId){
        return goodsCoverDAO.findByGoodsId(goodsId);
    }

    public List<GoodsDetail> findDetails(Long goodsId){
        return  goodsDetailDAO.findByGoodsId(goodsId);
    }

    public List<GoodsParam> findParams(Long goodsId){
        List list =  goodsParamDAO.findByGoodsId(goodsId);
        return list;
    }
    public List<Goods> findAllGoods(){
        return goodsDAO.findAll();
    }

    public List<Goods> findLast5M(){
        return goodsDAO.findLast5M();
    }

    public List<Evaluate> findEvaluates(Long goodsId){
        return evaluateDAO.findByGoodsId(goodsId);
    }

}
