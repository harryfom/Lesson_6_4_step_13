package ru.fomenko_iv;

import java.util.Comparator;
import java.util.Map;

/**
 * Created by FomeIV on 28.03.2016.
 */
public class MyComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        if (o1 == o2){
            return 0;
        }
        Map.Entry<String,Integer> e1 = (Map.Entry<String,Integer>)o1;
        Map.Entry<String,Integer> e2 = (Map.Entry<String,Integer>)o2;
        int retval = e2.getValue().compareTo(e1.getValue());
        if (retval == 0) {
            retval = e1.getKey().compareTo(e2.getKey());
        }
        return retval;
    }
}
