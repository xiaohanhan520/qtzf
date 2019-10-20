package com.xh;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;


@RunWith(SpringRunner.class)
@SpringBootTest
public class QtzfApplicationTests {



    @Test
    public void contextLoads() {

        File file = new File("/Users/apple/Desktop/修改和新功能.pdf");
        ArrayList<Object> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.forEach(i-> System.out.println(i));
        HashMap<Object, Object> map = new HashMap<>();
        map.put(11,1);
        map.put(222,2);
        map.forEach((key,value)-> System.out.println(key));

    }

}
