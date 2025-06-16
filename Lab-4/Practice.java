public class Practice {
    public int[] getUniqueNumbers(String numbers) {
        String[] nos = numbers.split(", ");
        String no = "";
        for (String s : nos) {
            if (!no.contains(s)) {
                no += s;
            }
        }
        int[] uniqueNumbers = new int[no.length()];
        for (int i = 0; i < no.length(); i++) {
            uniqueNumbers[i] = Integer.parseInt(no.substring(i, i + 1));
        }
        return uniqueNumbers;
    }

    public boolean isPalindrome(String word){
        StringBuffer wrd = new StringBuffer(word);
        return word.equals(wrd.reverse().toString());
    }

    public static void main(String[] args) {
        Practice practice = new Practice();
        int[] uniqueNumbers = practice.getUniqueNumbers("1, 2, 3, 4, 5, 1, 2, 3, 4, 5");
        for (int number : uniqueNumbers) {
            System.out.println(number);
        }
        System.out.println("Length: " + uniqueNumbers.length); // Should be 5 for the given sample
        String notPalin = "hello";
        String palin = "racecar";
        System.out.println(notPalin + " is a palindrome: " + practice.isPalindrome(notPalin));
        System.out.println(palin + " is a palindrome: " + practice.isPalindrome(palin));
    }
}
