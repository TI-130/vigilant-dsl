package libs;

public class TypeCheckException extends RuntimeException {
    public TypeCheckException(String n1, String t1, String n2, String t2) {
        System.out.println("TYPE CHECK FAIL! You tried to connect node: " + n1 + " with shape: " + t1 + " to "
                + "node: " + n2 + " with shape " + t2);
    }
}
