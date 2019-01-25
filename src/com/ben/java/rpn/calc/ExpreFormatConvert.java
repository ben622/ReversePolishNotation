package com.ben.java.rpn.calc;

import com.ben.java.rpn.util.Stack;

/**
 * @author zhangchuan622@gmail.com
 * @version 1.0
 * @create 2019/1/25
 * @desc 表达式转换, 中缀表达式->后缀表达式
 */
public class ExpreFormatConvert {
    private StringBuilder expression = new StringBuilder();

    //运算符栈
    private Stack<Operator> operatorStack = new Stack<>();

    /**
     * 表达式转换<br/>
     * 数字输出，运算符进栈，括号匹配出栈，栈顶优先级低出栈
     *
     * @param expression
     * @return
     */
    public String convert(String expression) {
        if (expression == null || "".equals(expression)) {
            throw new IllegalArgumentException();
        }
        this.expression.setLength(0);

        for (String o : expression.split("")) {
            Operator operator = Operator.fromOperatorFlag(o);
            if (operator != null) {
                //如果这运算符是) 从栈中查找出括号内的运算符并输出
                if (operator == Operator.BRACKET_END) {
                    Operator temp = operatorStack.pop();
                    while (temp != Operator.BRACKET_START) {
                        //运算符输出
                        this.expression.append(temp.getOperator());
                        temp = operatorStack.pop();
                    }
                    continue;
                }
                if (operator == Operator.BRACKET_START) {
                    //运算符入栈
                    operatorStack.push(operator);
                    continue;
                }


                if (operatorStack.indexOf(Operator.BRACKET_START) >= 0) {
                    //运算符入栈
                    operatorStack.push(operator);
                    continue;
                }

                //验证栈顶的运算符优先级
                verifyPriority();

                //运算符入栈
                operatorStack.push(operator);
            } else {
                //数字输出
                this.expression.append(o);
            }
        }
        verifyPriority();
        return this.expression.toString();
    }

    private void verifyPriority() {
        if (!operatorStack.isEmpty()) {
            Operator o1 = operatorStack.peek();
            int index = operatorStack.indexOf(o1) - 1;
            if (index >= 0) {
                Operator o2 = operatorStack.get(index);
                if (isGt(o1, o2)) {
                    //栈顶运算符优先级比栈顶下的运算符优先级高 出栈
                    this.expression.append(o1.getOperator());
                    this.expression.append(o2.getOperator());
                    //出栈
                    operatorStack.pop();
                    operatorStack.pop();
                }
            }
        }
    }


    /**
     * 判断运算符优先级
     *
     * @param o1
     * @param o2
     * @return
     */
    private boolean isGt(Operator o1, Operator o2) {
        if (o1 == Operator.ADDITION || o1 == Operator.SUBTRACTION) {
            return false;
        }
        if ((o1 == Operator.MULTIPLICATION || o1 == Operator.DIVISION)
                && (o2 == Operator.MULTIPLICATION || o2 == Operator.MULTIPLICATION)) {
            return false;
        }
        return true;
    }

}
