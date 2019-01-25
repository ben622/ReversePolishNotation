package com.ben.java.rpn.calc;

import com.ben.java.rpn.util.Stack;

/**
 * @author zhangchuan622@gmail.com
 * @version 1.0
 * @create 2019/1/25
 * @desc ���ʽת��, ��׺���ʽ->��׺���ʽ
 */
public class ExpreFormatConvert {
    private StringBuilder expression = new StringBuilder();

    //�����ջ
    private Stack<Operator> operatorStack = new Stack<>();

    /**
     * ���ʽת��<br/>
     * ����������������ջ������ƥ���ջ��ջ�����ȼ��ͳ�ջ
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
                //������������) ��ջ�в��ҳ������ڵ�����������
                if (operator == Operator.BRACKET_END) {
                    Operator temp = operatorStack.pop();
                    while (temp != Operator.BRACKET_START) {
                        //��������
                        this.expression.append(temp.getOperator());
                        temp = operatorStack.pop();
                    }
                    continue;
                }
                if (operator == Operator.BRACKET_START) {
                    //�������ջ
                    operatorStack.push(operator);
                    continue;
                }


                if (operatorStack.indexOf(Operator.BRACKET_START) >= 0) {
                    //�������ջ
                    operatorStack.push(operator);
                    continue;
                }

                //��֤ջ������������ȼ�
                verifyPriority();

                //�������ջ
                operatorStack.push(operator);
            } else {
                //�������
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
                    //ջ����������ȼ���ջ���µ���������ȼ��� ��ջ
                    this.expression.append(o1.getOperator());
                    this.expression.append(o2.getOperator());
                    //��ջ
                    operatorStack.pop();
                    operatorStack.pop();
                }
            }
        }
    }


    /**
     * �ж���������ȼ�
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
