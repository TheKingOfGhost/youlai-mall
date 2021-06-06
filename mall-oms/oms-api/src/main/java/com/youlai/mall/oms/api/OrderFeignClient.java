package com.youlai.mall.oms.api;

import com.youlai.common.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author haoxr
 * @description TODO
 * @createTime 2021/3/13 11:59
 */
@FeignClient("mall-oms")
public interface OrderFeignClient {
}
