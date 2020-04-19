package com.zincwish.reactive.test;

import com.sun.management.OperatingSystemMXBean;

import java.lang.management.ManagementFactory;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Test {


    public static void main(String[] args) throws InterruptedException {

        var bean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        System.out.println(bean.getCpuLoad());


    }


    private void test() {
        var a = System.currentTimeMillis();

    }
}
