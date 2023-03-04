import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int[] input = new int[number];
        int min = 100;

        for (int i : input){
            input[i] = scanner.nextInt();
            if (min > input[i]){
                min = input[i];
                continue;
            }
            }
        System.out.println(min);
        }

    }
