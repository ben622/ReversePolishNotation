package com.ben.java.rpn;

import com.ben.java.rpn.calc.CalcFormatConvert;
import com.ben.java.rpn.calc.ExpreFormatConvert;
import com.ben.java.rpn.util.Iterator;
import com.ben.java.rpn.util.Stack;

import java.util.Arrays;

public class Test {
    public static void main(String args[]) {
        Stack<String> activitys = new Stack<>();
        activitys.push("activity1");
        activitys.push("activity2");
        activitys.push("activity3");
        activitys.push("activity4");
        System.out.println(Arrays.toString(activitys.toArray()));
        System.out.println("------------pop------------");
        String pop = activitys.pop();
        System.out.println("pop:" + pop);
        System.out.println("----------pop after--------");
        System.out.println(Arrays.toString(activitys.toArray()));
        System.out.println("-----------push------------");
        activitys.push("activity5");
        activitys.push("activity6");
        activitys.push("activity7");
        activitys.push("activity8");
        System.out.println(Arrays.toString(activitys.toArray()));

        String exp = "9+(3-1)*3+10/2";
        System.out.println(exp);
        ExpreFormatConvert expreFormatConvert = new ExpreFormatConvert();
        String convert = expreFormatConvert.convert(exp);
        System.out.println(convert);


        CalcFormatConvert calcFormatConvert = new CalcFormatConvert();
        int res = calcFormatConvert.convert(convert);
        System.out.println("result:"+res);

    }

}
