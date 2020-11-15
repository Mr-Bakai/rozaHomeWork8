import java.util.*;

public class Main {

    public static void main(String[] args) {


        HashMap<String, String[]> smallOne = new HashMap<>();
        HashMap<String, String[]> dictionaryBigOne = new HashMap<>();

        smallOne.put("beautiful", new String[]{"attractive", "charming", "good-looking", "gorgeous"});
        smallOne.put("child", new String[]{"kid", "toddler", "children", "lil-boy"});
        smallOne.put("man", new String[]{"dude", "person", "human", "buddy"});
        smallOne.put("house", new String[]{"flat", "home", "apartment", "cozy-place"});

        for (Map.Entry<String, String[]> items : smallOne.entrySet()) {
            System.out.format("%s  -  %s%n", items.getKey(), Arrays.toString(items.getValue()));
        }


        dictionaryBigOne.putAll(smallOne);

        System.out.println("\n==========really ? =============");
        dictionaryBigOne.forEach((k, v) -> System.out.println((k + " - " + Arrays.toString(v))));


        for (String list1 : smallOne.keySet()) {      //KEYS: beautiful, man, house, child
            String key = list1;                       // currently we have  "beautiful"

            for (int i = 0; i < smallOne.get(key).length; i++) {
                ArrayList<String> val = new ArrayList<>();

                // now we are adding to col-n "val" values of smallOne  (on first iteration we have attractive, charming, good-looking, gorgeous)
                Collections.addAll(val, smallOne.get(key));

                String temp1 = val.get(i);  // attractive

                val.set(i, key);        // val[0] = beautiful

                String[] tArray = new String[val.size()];
                for (int j = 0; j < val.size(); j++) {
                    tArray[j] = val.get(j);

                    // after iteration we have in tArray = beautiful, charming, good-looking, gorgeous
                }

                dictionaryBigOne.put(temp1, tArray);    // temp1 = attractive   tArray = beautiful, charming, good-looking, gorgeous

            }
        }
        System.out.println("\n==========list of final one =============");
        dictionaryBigOne.forEach((k, v) -> System.out.println((k + " - " + Arrays.toString(v))));
    }
}