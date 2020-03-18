public class ArraySum {
    public int result;

    public int sum(String[][] arr) {
        if (arr.length != 4) throw MyArraySizeException;
       
        for (int i = 0; i < 4; i++) {
            if (arr[i].length != 4) throw MyArraySizeException;
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; i++) {
                if (!((int) arr[i][j])) throw MyArrayDataException;
                result += (int) arr[i][j];
            }
        }
    }
}
            