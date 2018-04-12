package com.cetiti.dsp.dao;

import com.cetiti.dsp.entity.Goods;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface GoodsDao {

    List<Goods> queryAll();

    int reduceGoods(Long goodsId);

}
