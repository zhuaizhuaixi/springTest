package com.zzx;

import java.util.*;

/**
 * Created by 拽拽鑫 on 2017/9/3.
 */
public class test {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(1);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        Set<Integer> set =new HashSet(list) ;
//        for(int i:set){
//            System.out.println(i);
//        }
        Iterator iterator = set.iterator();
        while(iterator.hasNext())
            System.out.println(iterator.next());
    }
}
