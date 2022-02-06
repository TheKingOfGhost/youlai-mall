package com.youlai.mall.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.youlai.common.result.Result;
import com.youlai.mall.pms.pojo.dto.SkuInfoDTO;
import com.youlai.mall.pms.pojo.entity.PmsSku;
import com.youlai.mall.pms.pojo.dto.app.LockStockDTO;

import java.util.List;

/**
 * 商品库存单元接口
 *
 * @author haoxr
 * @date 2022/2/5 17:11
 */
public interface IPmsSkuService extends IService<PmsSku> {

    /**
     * 获取商品的库存数量
     *
     * @param skuId
     * @return
     */
    Integer getStockNum(Long skuId);

    /**
     * 获取商品库存信息
     *
     * @param skuId
     * @return
     */
    SkuInfoDTO getSkuInfo(Long skuId);


    /**
     * 锁定库存
     */
    Result lockStock(List<LockStockDTO> list);

    /**
     * 锁定库存
     */
   // Boolean lockStockTcc(List<LockStockDTO> list);

    /**
     * 解锁库存
     */
    boolean unlockStock(String orderToken);

    /**
     * 扣减库存
     */
    boolean deductStock(String orderToken);



}
