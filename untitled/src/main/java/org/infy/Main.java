package org.infy;

import java.util.HashMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        //System.out.printf("Hello and welcome!");

        String s="aabcc";
        char[] arr =s.toCharArray();
        HashMap<Character,Integer> map=new HashMap<>();

//        for(int i=0;i<arr.length;i++){
//            if(map.containsKey(arr[i])){
//                int j=map.get(arr[i]);
//                map.put(arr[i],j+1);
//            }else{
//                map.put(arr[i],1);
//            }
//        }
        for(arr:int i) {
            (map.containsKey(arr[i]))->{
                int j=map.get(arr[i]);
                map.put(arr[i],j+1);
            }
        }
        System.out.println(map);
    }
}
e id , name ,
1 , anant , null
2, kumar, 1
salary
d id;

select * max(salary) in dep

Select * from employee where e.name="Kumar"