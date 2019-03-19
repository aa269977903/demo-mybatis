package com.cest;

import java.util.regex.Pattern;

/**
 * Created by cestlavie on 2019/3/18.
 */
public class Test {


    public static final String MSG = "gender";

    public static void main(String[] args) {


        Pattern dictPattern= Pattern.compile("\"" + MSG +".*?,");

        System.out.println(11);
        //Matcher dictMatcher=dictPattern.matcher(returnJsonResult);
    }
}
