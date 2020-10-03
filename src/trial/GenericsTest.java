package trial;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenericsTest {
    public static void main(String[] args) {
        List<Object> objList = new ArrayList<>();
        objList.add("Apple");

        List<String> strList = new ArrayList<>();
        strList.add("orange");

        objList = Collections.singletonList(strList);
        objList.add("test");
    }
}
