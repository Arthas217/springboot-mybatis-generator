package com.bj.reg;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author 会游泳的蚂蚁
 * @Description: 正则表达式语法学习
 * https://www.liaoxuefeng.com/wiki/1016959663602400/1017639890281664
 * @Date 2021/12/15 12:38
 */
public class RegexTest2 {

    public static void main(String[] args) {
        //如果直接给出字符，就是精确匹配。用\d可以匹配一个数字，\w可以匹配一个字母或数字
        @SuppressWarnings("AlibabaAvoidPatternCompileInMethod")
        Pattern compile = Pattern.compile("00\\d");
        System.out.println(compile.pattern());
        Matcher matcher = compile.matcher("001");
        System.out.println(matcher.matches());


        // 用.可以匹配任意字符
        @SuppressWarnings("AlibabaAvoidPatternCompileInMethod")
        Pattern compile1 = Pattern.compile("py.");

        // 用*表示任意个字符（包括0个）
        // 用+表示至少一个字符
        // 用?表示0个或1个字符
        // 用{n}表示n个字符
        // 用{n,m}表示n-m个字符
        // \d{3}表示匹配3个数字
        // \s可以匹配一个空格（也包括Tab等空白符），所以\s+表示至少有一个空格，例如匹配' '，'  '等；
        // \d{3,8}表示3-8个数字，例如'1234567'
        @SuppressWarnings("AlibabaAvoidPatternCompileInMethod")
        Pattern compile2 = Pattern.compile("\\d{3}\\s+\\d{3,8}");
        @SuppressWarnings("AlibabaAvoidPatternCompileInMethod")
        Pattern compile3 = Pattern.compile("\\d{3}\\-\\d{3,8}");
        Matcher matcher1 = compile2.matcher("010  12345");
        Matcher matcher3 = compile3.matcher("010-12345");
        System.out.println(matcher1.matches());
        System.out.println(matcher3.matches());

        @SuppressWarnings("AlibabaAvoidPatternCompileInMethod")
        Pattern compile4 = Pattern.compile("\\d{3}\\s+\\-\\s+\\d{3,8}");
        Matcher matcher4 = compile4.matcher("010 - 12345");
        System.out.println(matcher4.matches());



    }
}
