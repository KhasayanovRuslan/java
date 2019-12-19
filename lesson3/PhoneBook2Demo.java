public class PhoneBook2<String, ArrayList<Integer>> extends HashMap<String, ArrayList<Integer>> {
    public PhoneBook2() {
        super();
    } 

    void add(String lastname, Integer number) {
        this.put(String lastname, Integer number);
    }

    @Override
    ArrayList<Integer> get(String lastname) {
       System.out.println(this.get(String lastname));
    }
}

public class PhoneBook2Demo {       
    public static void main(String[] args) {
        PhoneBook2 pb = new PhoneBook2();
  
        pb.add("Petrov", 4651188);
        pb.add("Ivanov", 1091309);
        pb.add("Petrov", 1990006);
        pb.add("Ivanov", 1427879);
        pb.add("Sidorov", 1263190);
        pb.add("Alexandrov", 0856539);

        for (Map.Entry<String, ArrayList<Integer>> o: pb.entrySet()) {
            System.out.println(o.getKey() + ": " + o.getValue());
        }

        pb.get("Petrov");
        pb.get("Alexandrov");
    }
}