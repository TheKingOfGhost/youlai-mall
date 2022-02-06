package com.youlai.mall.pms.controller.app;

import com.youlai.common.result.Result;
import com.youlai.mall.pms.pojo.dto.SkuInfoDTO;
import com.youlai.mall.pms.pojo.dto.app.LockStockDTO;
import com.youlai.mall.pms.service.IPmsSkuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品库存单元控制器 (Stock Keeping Unit)
 */
@Api(tags = "「移动端」商品库存")
@RestController("appSkuController")
@RequestMapping("/app-api/v1/sku")
@RequiredArgsConstructor
public class SkuController {

    private final IPmsSkuService skuService;

    @ApiOperation(value = "获取商品库存详情")
    @GetMapping("/{skuId}")
    public Result<AppSkuDetailVO> getSkuDetail(@PathVariable Long skuId) {
        AppSkuDetailVO sku = skuService.getSkuById(skuId);
        return Result.success(sku);
    }

    @ApiOperation(value = "获取商品库存信息")
    @GetMapping("/{skuId}")
    public Result<SkuInfoDTO> getSkuInfo(
          @ApiParam("商品库存单元ID") @PathVariable Long skuId
    ) {
        SkuInfoDTO skuInfo = skuService.getSkuInfo(skuId);
        return Result.success(skuInfo);
    }


    @ApiOperation("获取商品库存数量")
    @GetMapping("/{skuId}/stock_num")
    public Result<Integer> getStockNum(
           @ApiParam("商品库存单元ID") @PathVariable Long skuId
    ) {
        Integer stockNum = skuService.getStockNum(skuId);
        return Result.success(stockNum);
    }

    @ApiOperation(value = "锁定库存")
    @PutMapping("/_lock")
    public Result lockStock(@RequestBody List<LockStockDTO> list) {
        return skuService.lockStock(list);
    }

    @ApiOperation(value = "解锁库存")
    @PutMapping("/_unlock")
    public Result<Boolean> unlockStock(String orderToken) {
        boolean result = skuService.unlockStock(orderToken);
        return Result.judge(result);
    }

    @ApiOperation(value = "扣减库存")
    @PutMapping("/_deduct")
    public Result<Boolean> deductStock(String orderToken) {
        boolean result = skuService.deductStock(orderToken);
        return Result.judge(result);
    }
}
