package com.example.batch.model;

import lombok.*;


/**
 * 含有策略注解的方法信息
 *
 * @author aw
 * @date 2021/1/13 17:27
 */
@Builder
@ToString
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@NoArgsConstructor
@AllArgsConstructor
public class MessageStrategyInfo {
    private String classname;
    private String methodName;
    private Class<?>[] parameterTypes;
}
