public class Main {
    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {
        try {
             sum();
        }
        catch (MyArraySizeException e) {
             System.out.println(e);
        }
        catch (MyArrayDataException e) {
              System.out.println(e);
        }
       
        System.out.println(result);
    }
}