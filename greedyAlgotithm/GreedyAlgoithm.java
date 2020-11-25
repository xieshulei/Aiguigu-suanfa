package greedyAlgotithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class GreedyAlgoithm {

    public static void main(String[] args) {
        HashMap<String, HashSet<String>> broadcasts = new HashMap<String, HashSet<String>>();
        HashSet<String> hashSet1 = new HashSet<String>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");
        HashSet<String> hashSet2 = new HashSet<String>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");
        HashSet<String> hashSet3 = new HashSet<String>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");
        HashSet<String> hashSet4 = new HashSet<String>();
        hashSet4.add("上海");
        hashSet4.add("天津");
        HashSet<String> hashSet5 = new HashSet<String>();
        hashSet5.add("杭州");
        hashSet5.add("大连");


        broadcasts.put("K1",hashSet1);
        broadcasts.put("K2",hashSet2);
        broadcasts.put("K3",hashSet3);
        broadcasts.put("K4",hashSet4);
        broadcasts.put("K5",hashSet5);

        HashSet<String> allAreas = new HashSet<String>();
        // 存放所有的地区
        allAreas.add("北京");
        allAreas.add("上海");
        allAreas.add("天津");
        allAreas.add("广州");
        allAreas.add("深圳");
        allAreas.add("杭州");
        allAreas.add("成都");
        allAreas.add("大连");

        ArrayList<String> selects = new ArrayList<String>();

        // 定义一个集合，在遍历过程中电台覆盖的地区
        HashSet<String> tempSet = new HashSet<String>();
        HashSet hashSettemp = new HashSet();

        // 定义一个maxkey 保存在一次遍历过程中可以覆盖最大的非覆盖地区电台的key
        String maxKey = null;
        while (allAreas.size() != 0){  // 声明一个集合，但不赋值，指向一个新建、未初始化的集合对象。则该集合长度为0，但是不为空。
            maxKey = null;
            for (String key: broadcasts.keySet()){
                tempSet.clear();
                hashSettemp = null;
                tempSet.addAll(broadcasts.get(key));
                tempSet.retainAll(allAreas);

                hashSettemp = broadcasts.get(maxKey);
                if (hashSettemp != null){
                    hashSettemp.retainAll(allAreas);
                }

                if (tempSet.size()>0 && (maxKey == null || hashSettemp.size() < tempSet.size())){
                    maxKey = key;
                }
            }
            if (maxKey != null){
                System.out.println("------------------");
                selects.add(maxKey);
                allAreas.removeAll(broadcasts.get(maxKey));
                System.out.println(allAreas);
            }
        }
        System.out.println(selects);
    }
}
