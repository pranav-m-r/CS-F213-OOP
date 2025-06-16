import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library lib = new Library();
        
        while (true) {
            String input = sc.next();
            String input1, input2, input3;

            switch (input) {
                case "ADD_BOOK":
                    input1 = sc.next();
                    String[] inputs = sc.nextLine().split("\"");
                    input2 = inputs[1];
                    input3 = inputs[3];
                    lib.addBook(input1, input2, input3);
                    break;
                case "REGISTER_MEMBER":
                    input1 = sc.next();
                    input2 = sc.nextLine().split("\"")[1];
                    lib.registerMember(input1, input2);
                    break;
                case "BORROW":
                    input1 = sc.next();
                    input2 = sc.next();
                    lib.borrowBook(input1, input2);
                    break;
                case "RETURN":
                    input1 = sc.next();
                    input2 = sc.next();
                    lib.returnBook(input1, input2);
                    break;
                case "DISPLAY_CATALOG":
                    lib.displayBookCatalog();
                    break;
                case "DISPLAY_MEMBER":
                    input1 = sc.next();
                    lib.displayMemberHistory(input1);
                    break;
                default:
                    break;
            }
        }
    }
}
