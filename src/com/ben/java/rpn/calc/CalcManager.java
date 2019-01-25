package com.ben.java.rpn.calc;

/**
 * @author zhangchuan622@gmail.com
 * @version 1.0
 * @create 2019/1/25
 */
public class CalcManager {

    public static int calc(String expression) {
        ExpreFormatConvert format = new ExpreFormatConvert();
        String convert = format.convert(expression);

        return 0;
    }

}
