public class Immutable {
    public static String upcase(String s){
        return s.toUpperCase();
    }
    public static void main(String[] args) {
        String q = "howby";
        System.out.println(q);
        String qq = upcase(q);
        System.out.println(qq);
        System.out.println(q);
    }
}
