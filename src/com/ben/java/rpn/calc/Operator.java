package com.ben.java.rpn.calc;

/**
 * @author zhangchuan622@gmail.com
 * @version 1.0
 * @create 2019/1/25
 * @desc ÔËËã·û
 */
public enum  Operator {
    ADDITION("+"),
    SUBTRACTION("-"),
    MULTIPLICATION("*"),
    DIVISION("/"),
    BRACKET_START("("),
    BRACKET_END(")");

    private String operator;
    Operator(String operator) {
        this.operator = operator;
    }

    public static Operator fromOperatorFlag(String operator) {
        for (Operator value : Operator.values()) {
            if (value.getOperator().equals(operator)) {
                return value;
            }
        }
        return null;
    }

    public String getOperator() {
        return operator;
    }
}
