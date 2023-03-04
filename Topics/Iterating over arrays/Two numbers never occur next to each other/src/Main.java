import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] num = new int[size];
        for (int i = 0; i < size; i++) {
            num[i] = Integer.parseInt(scanner.next());
            //System.out.println(num[i]);
        }
        int[] check = new int[2];
        for (int i = 0; i < 2; i++){
            check[i] = Integer.parseInt(scanner.next());
            //System.out.println(check[i]);
        }
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size && j
                    < i + 2; j++) {
                if (num[i] == check[0] && num[j] == check[1] || num[j] == check[0] && num[i] == check[1]) {
                    System.out.println("false");
                    return;
                }
                else {
                    continue;
                }
            }
        }
        System.out.println("true");
    }
}