// Пытался решить задачу о 8 ферзях, но пока готового решения нет.
// Решение задачи "Ханойская башня" представлено дальше.
public class Hanoi {
    private static int disks = 3;

    public static void main(String[] args) {
        doHanoi(disks, 'A', 'B', 'C');
    }

    public static void doHanoi(int n, char from, char inter, char to) {
        if(n == 1)
            System.out.println("Disk 1 from " + from + " to "+ to);
        else {
            doHanoi(n-1, from, to, inter);
            System.out.println("Disk " + n + " from " + from + " to "+ to);
            doHanoi(n-1, inter, from, to);
        }
    }
}
