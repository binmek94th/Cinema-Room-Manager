package cinema;

import java.util.Scanner;

public class Cinema {
    static int purchaseTickets;
    static int income;
    static int totalIncome;
    static float percentage;
    static int seatB = 0;
    static int rowB = 0;

    public static void display(char[][] rowS, int row, int seats) {
        System.out.println("Cinema:");
        System.out.print("  ");
        for (int i = 1; i <= seats; i++) {
            System.out.print(i + " ");
        }
        System.out.println("");
        for (int i = 0; i < row; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < seats; j++) {
                System.out.print(rowS[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void stat(char[][] rowS, int row, int seats) {
        int firstR = row / 2;
        int secondR = row / 2 + row % 2;
        totalIncome = (firstR * 10 * seats + secondR * 8 * seats);
        System.out.println("Number of purchased tickets: " + purchaseTickets);
        percentage = (float) (((float) (purchaseTickets / (double)(row * seats))) *100d);
        System.out.print("Percentage: ");
        System.out.printf("%.2f", percentage);
        System.out.println("%");
        System.out.println("Current income: $" + income);
        System.out.println("Total income: $" + totalIncome);
    }

    public static boolean validate(char[][] rowS, int rows, int seats) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a row number:");
        rowB = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        seatB = scanner.nextInt();
        if (rowB  > rows || seatB  > seats) {
            System.out.println("Wrong input!");
            buy(rowS, rows, seats);
        } else if (rowS[rowB - 1][seatB - 1] == 'B') {
            System.out.println(" ");
            System.out.println("That ticket has already been purchased!");
            System.out.println("");
        } else {
            return true;
        }
        return false;
    }

    public static char[][] buy (char[][] rowS,int rows, int seats) {
        boolean valid = false;
        while (true) {
            if (valid == false) {
                valid = validate(rowS, rows, seats);
            } else if (valid == true) {
                int price = 0;
                if (rows * seats < 60) {
                    price = 10;
                } else {
                    if ((rows % 2 == 0 && rows / 2 + rows % 2 < rowB) || rowB == 1) {
                        price = 10;
                    } else if (rows % 2 != 0 && rowB < rows / 2 + rows % 2) {
                        price = 10;
                    } else if (rows % 2 != 0 && rows / 2 + rows % 2 <= rowB) {
                        price = 8;
                    }

                }
                System.out.print("Ticket price:");
                System.out.println("$" + price);
                rowS[rowB - 1][seatB - 1] = 'B';
                purchaseTickets++;
                income += price;

                return rowS;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows: ");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row: ");
        int seats = scanner.nextInt();
        char[][] rowS = new char[rows][seats];
        for (int i = 0; i < rows ; i++) {
            for (int j = 0; j < seats ; j++){
                rowS[i][j] = 'S';
            }
        }
        while (true) {
            System.out.println("");
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");

            int select = scanner.nextInt();
            switch (select) {
                case 1:
                    System.out.println("");
                    display(rowS, rows, seats);
                    break;
                case 2:
                    System.out.println("");
                    rowS = buy(rowS, rows, seats);
                    display(rowS, rows, seats);
                    break;
                case 3:
                    System.out.println("");
                    stat(rowS, rows, seats);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Wrong input!");
            }
        }
    }
}