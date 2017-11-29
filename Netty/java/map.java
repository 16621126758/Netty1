import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class map {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>() ;
        map.put("key","Hello");
        map.put("key1","nihao");
        for (Map.Entry<String,String> entry:map.entrySet()){
            System.out.println("key = "+entry.getKey()+", Value"+entry.getValue());
        }
    }
}
