package demo;

import java.util.HashMap;
import java.util.Map;

/*
通过350题复习Java MAP的知识。
Map接口中键和值一一映射. 可以通过键来获取值。
 给定一个键和一个值，你可以将该值存储在一个Map对象. 之后，你可以通过键来访问对应的值。
 当访问的值不存在的时候，方法就会抛出一个NoSuchElementException异常.
 当对象的类型和Map里元素类型不兼容的时候，就会抛出一个 ClassCastException异常。
 当在不允许使用Null对象的Map中使用Null对象，会抛出一个NullPointerException 异常。
 当尝试修改一个只读的Map时，会抛出一个UnsupportedOperationException异常。
 */
public class TryMap {
    //学习Map接口提供的各种方法
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        //put(key,value) 将指定的value与指定的key关联，可以用来新增和修改
        map.put("lily",1);
        map.put("Tom",2);
        map.put("Jerry",5);
        map.put("Max",3);
        //map.size() 返回key-value数
        System.out.println(map.size());
        //Set entrySet()返回包含映射关系的set视图
        System.out.println(map.entrySet());
        //Set keySet()返回map中key的set视图
        System.out.println(map.keySet());

        // boolean containsKey(key):如果map中包含指定key的映射关系，返回true
        if(map.containsKey("lily")){
            //get(key)返回指定键映射的值，如果map中没有这个key则返回null
            System.out.println(map.get("lily"));
        }
        //boolean containsValue(value):如果map中有一个或多个key映射到该value 返回true
        if(map.containsValue(5)){
            System.out.println("this map have");
        }

        Map<String,Integer> map2 = new HashMap<>();
        map2.put("lily",1);
        map2.put("Tom",2);
        map2.put("Jerry",5);
        map2.put("Max",3);
        //boolean equals(map)：比较map与当前map是否相等
        System.out.println( map.equals(map2));

        //hashCode()返回map的hashCode
        //通过比较hashCode发现 map和map2是同一个对象
        System.out.println(map.hashCode());
        System.out.println(map2.hashCode());

        // boolean isEmpty() 判断map是否为空
        System.out.println(map.isEmpty());

        Map<String,Integer> map3 = new HashMap<>();
        //putAll(map)将指定map中所有映射关系复制到此map中
        map3.putAll(map);
        System.out.println(map3.equals(map));

        //remove(key)将指定key的映射关系删除
        map3.remove("lily");
        System.out.println(map3.size());

        //values()返回map中value的collection视图
        System.out.println(map3.values());
    }
}
