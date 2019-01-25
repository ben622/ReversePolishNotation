package com.ben.java.rpn.calc;

/**
 * @author zhangchuan622@gmail.com
 * @version 1.0
 * @create 2019/1/25
 */
public class CalcFormatConvert {

    public int convert(String expression) {
        int result = 0;

        String[] split = expression.split("");
        for (int i = 0; i < split.length; i++) {
            if (Operator.fromOperatorFlag(split[i]) != null) {
                //0 1 2   2>>i
                //2(i-1),2(i-2)
                if (i - 2 < 0) {

                }

                int a1 = Integer.parseInt(split[i - 1]);
                int a2 = Integer.parseInt(split[i - 2]);
                switch (split[i]) {
                    case "+":
                        result += a1 + a2;
                        break;
                    case "-":
                        result += a2 - a1;
                        break;
                    case "*":
                        result += a1 * a2;
                        break;
                    case "/":
                        result += a2 / a1;
                        break;
                }

                String newexpre = expression.replace(split[i - 2] + split[i - 1] + split[i], String.valueOf(result));
                return convert(newexpre);
            }
        }
        return result;
    }
}
