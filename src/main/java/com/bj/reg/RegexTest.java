package com.bj.reg;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author 会游泳的蚂蚁
 * @Description: 正则表达式测试https://www.cnblogs.com/ggjucheng/p/3423731.html
 * @Date 2021/12/15 11:34
 */
public class RegexTest {

    public static void main(String[] args) {
        @SuppressWarnings("AlibabaAvoidPatternCompileInMethod")
        //简单工厂方法创建一个正则表达式,
        Pattern pattern = Pattern.compile("\\d+");

        //返回正则表达式的字符串形式
        System.out.println(pattern.pattern());

        //用于分隔字符串
        String[] str = pattern.split("我QQ是:456456我的电话是:0532214我的邮箱是:aaa@aaa.com");
        for (String s : str) {
            System.out.println(s);
        }

        // 适合用于只匹配一次,且匹配全部字符串
        Pattern.matches("\\d+", "2223");
        Pattern.matches("\\d+", "2223aa");
        Pattern.matches("\\d+", "22bb23");


        //想得到更强更便捷的正则匹配操作,那就需要将Pattern与Matcher一起合作,Matcher类提供了对正则表达式的分组支持,以及对正则表达式的多次匹配支持.
        Matcher matcher = pattern.matcher("2234");
        Matcher matcher2 = pattern.matcher("2234aa");


        //对整个字符串进行匹配,只有整个字符串都匹配了才返回true
        System.out.println(matcher.matches());
        System.out.println(matcher2.matches());

        Matcher matcher3 = pattern.matcher("aa2234");

        // 对前面的字符串进行匹配,只有匹配到的字符串在最前面才返回true
        System.out.println(matcher2.lookingAt());
        System.out.println(matcher3.lookingAt());

        // 对字符串进行匹配,匹配到的字符串可以在任何位置.
        System.out.println(matcher.find());
        System.out.println(matcher2.find());
        System.out.println(matcher3.find());

        @SuppressWarnings("AlibabaAvoidPatternCompileInMethod")
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher("aaa2223bb");
        m.find();
        //返回匹配到的子字符串在字符串中的索引位置.
        System.out.println(m.start());
        // 返回匹配到的子字符串的最后一个字符在字符串中的索引位置.(有歧义)
        System.out.println(m.end());
        // group()返回匹配到的子字符串
        System.out.println(m.group());

        @SuppressWarnings("AlibabaAvoidPatternCompileInMethod")
        Pattern p1 = Pattern.compile("\\d+\\w+");
        Matcher m1 = p1.matcher("2223bb");
        System.out.println(m1.matches());
        System.out.println(m1.start());
        System.out.println(m1.end());
        System.out.println(m1.group());

        //start(int i),end(int i),group(int i)专用于分组操作,Mathcer类还有一个groupCount()用于返回有多少组.
        @SuppressWarnings("AlibabaAvoidPatternCompileInMethod")
        Pattern p2 = Pattern.compile("([a-z]+)(\\d+)");
        Matcher m2 = p2.matcher("aaa2223bb");
        System.out.println(m2.find());
        System.out.println(m2.groupCount());
        System.out.println(m2.group());
        //返回aaa,返回第一组匹配到的子字符串
        System.out.println(m2.group(1));
        System.out.println(m2.group(2));
    }
}
