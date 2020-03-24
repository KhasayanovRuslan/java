public class Fruit {
    public static void main (String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("Orange", "Banana", "Apple" , "Orange", "Cherry", "Orange", "Apple", "Kiwi", "Lemon", "Cherry"));
        int result = 0 ;
        
        for (int i = 0; i < list.size(); i++) {
            for ( int j = i + 1; j < list.size(); j++) {
               if (list.get(i) == list.get(j)) { 
                  list.remove(i);
                  return;
               }
            }
        }

        System.out.println(list);

        for (int i = 0; i < list.size(); i++) {
            for ( int j = i + 1; j < list.size(); j++) {
               if (list.get(i) == list.get(j)) result++;
            }
            System.out.println(list.get(i) + "встречается" + result + "раз");
        }
    }
}

       

        
               
