package com.company;

import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        char [] chars = s.toCharArray();
        Arrays.sort(chars);
        List<char[]> list=  new ArrayList<>();
        list = Arrays.asList(chars);
       Collections.reverse(list);
        for(int  i = 0;i<list.size() ; i++){
            answer = answer+list.get(i);
        }

        return         Arrays.toString(chars);
    }
}