package com.example.batch.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 订单入账
 *
 * @author zhw
 * @date 2020/8/12 14:18
 */
@Builder
@ToString
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "enter_account_order_record")
public class EnterAccountOrderRecord {

    @Id
    protected String id;
    /**
     * 订单ID
     */
    private String orderId;
    /**
     * 连锁
     */
    private String custId;
    /**
     * 门店
     */
    private String compId;
    /**
     * 0 支付订单  1 退款订单
     */
    private Integer type;
    /**
     * 原订单ID type = 1 时候 这个为付款订单ID
     */
    private String originalOrderId;
    /**
     * 订单类型
     */
    private Integer orderType;
    /**
     * 订单类型名称
     */
    private String orderTypeName;
    /**
     * 订单归属门店
     */
    private String orderCompId;
    /**
     * 员工ID
     */
    private String empId;
    /**
     * 员工姓名
     */
    private String empName;
    /**
     * 会员ID
     */
    private String memberId;
    /**
     * 会员姓名
     */
    private String memberName;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 订单金额
     */
    private BigDecimal amount;
    /**
     * 实际支付金额
     */
    private BigDecimal payAmount;
    /**
     * 抵扣金额
     */
    private BigDecimal discountAmount;
    /**
     * 抵扣积分
     */
    private BigDecimal discountIntegral;
    /**
     * 优惠券
     */
    private String couponId;
    /**
     * 消耗积分卡号
     */
    private String integralCardNo;
    /**
     * 入账状态
     * 0 未入账 1 已入账 2 入账失败 3 已退款
     */
    private Integer status;
    /**
     * 处理中标识
     * handle 处理中
     */
    private String handleTag;
    /**
     * 团ID
     */
    private String groupSaleId;
    /**
     * 性别  --1--男 0--女
     */
    private Integer gender;
    /**
     * 失败原因
     */
    private String failReason;
    /**
     * 入账操作人
     */
    private String operator;
    /**
     * 入账平台
     */
    private String platform;
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
     * gn 卖卡
     * gz 充值
     * gx 收银
     */
    private String billType;
    /**
     * 卡类别
     */
    private String cardType;
    /**
     * 券记录IDs
     */
    private List<String> voucherRecordIds;
}
