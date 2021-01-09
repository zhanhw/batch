package com.example.batch.model;

import lombok.*;

import java.util.Date;

/**
 * 订单入账结果
 *
 * @author zhw
 * @date 2020/8/12 15:42
 */
@Builder
@ToString
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@NoArgsConstructor
@AllArgsConstructor
public class EnterAccountResult {

    /**
     * 订单ID
     */
    private String orderId;
    /**
     * 入账状态
     * 1 已入账 2 入账失败
     */
    private Integer status;
    /**
     * 失败原因
     */
    private String failReason;
    /**
     * 返回时间
     */
    private Date returnDate;
    /**
     * 卡号
     */
    private String cardNo;
    /**
     * 平台单号
     */
    private String billNo;
    /**
     * 类型
     *  gn 卖卡
     *  gz 充值
     */
    private String billType;

}
