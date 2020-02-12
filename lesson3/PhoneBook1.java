public class PhoneBook1 {
    public static void main(String[] args) {
        HashMap<String, ArrayList<Integer>> hm = new HashMap<>();
  
        hm.put("Petrov", 4651188);
        hm.put("Ivanov", 1091309);
        hm.put("Petrov", 1990006);
        hm.put("Ivanov", 1427879);
        hm.put("Sidorov", 1263190);
        hm.put("Alexandrov", 0856539);

        for (Map.Entry<String, ArrayList<Integer>> o: hm.entrySet()) {
            System.out.println(o.getKey() + ": " + o.getValue());
        }

        System.out.println(hm.get("Petrov"));
        System.out.println(hm.get("Alexandrov"));
    }