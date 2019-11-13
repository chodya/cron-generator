package com.douya.cron.generator;

import java.util.*;
import java.util.stream.Collectors;

/**
 * cron各项生成器
 */
public abstract class BaseGenerator {

    /**
     * 通配符 '*'， 代表所有值
     *     e.g. 时字段为*，代表每小时都触发
     * @return
     */
    public String all(){
        return "*";
    }

    /**
     * 通配符 '-'， 代表一个区间
     *     e.g. 时字段设置2-5，代表2，3，4，5点钟时都触发
     * @param s 区间开始值
     * @param e 区间结束值
     * @return
     */
    public String interval(int s, int e){
        return String.valueOf(s)
                .concat("-")
                .concat(String.valueOf(e));
    }

    /**
     * 通配符 '/', 代表递增值
     *     e.g. 时字段设置0/2，代表每两个小时触发，时字段设置 2/5，代表从2时开始每隔5小时触发一次
     * @param init 初始值，从该值开始递增
     * @param incr 递增值
     * @return
     */
    public String beginAt(int init, int incr){
        return String.valueOf(init)
                .concat("/")
                .concat(String.valueOf(incr));
    }

    /**
     * 通配符 ',', 代表多个值
     *     e.g. 时字段设置2,3,5，代表2，3，5点都会触发
     * @param mult 指定多个值
     * @return
     */
    public String specified(int ... mult){
        return specified(new ArrayList(Arrays.asList(mult)));
    }

    public String specified(List<Integer> mult){
        return mult.stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(","));
    }

}
