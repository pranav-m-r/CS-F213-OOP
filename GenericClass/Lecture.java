public class Lecture {
    public static void main(String[] args) {
        Box<String> b = new Box<String>("Hello");
        Box<String> c = new Box<String>("No");
        c.copyFrom(b);
        System.out.println(b.getData());
        System.out.println(c.getData());
    }
}
