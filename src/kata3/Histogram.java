/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kata3;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author usuario
 */
public class Histogram <T>{
    Map<T,Integer> map = new HashMap<>();
    
    public Integer get(T Key){
        return map.get(Key);
    }
    
    public Set<T> keySet(){
        return map.keySet();
    }
    
    public void increment(T key, int valor){
        map.put(key, valor);
    }
}
