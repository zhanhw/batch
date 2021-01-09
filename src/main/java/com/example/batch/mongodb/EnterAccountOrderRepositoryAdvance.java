package com.example.batch.mongodb;


import com.example.batch.model.EnterAccountOrderRecord;

import java.util.List;

/**
 * 订单入账
 *
 * @author zhw
 * @date 2020/8/12 17:29
 */
public interface EnterAccountOrderRepositoryAdvance {

    /**
     * 根据custId查询
     *
     * @param custId
     * @return
     */
    List<EnterAccountOrderRecord> findByCustId(String custId);

}
