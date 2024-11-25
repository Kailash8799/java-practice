import java.util.Iterator;

public class Array {

  public static void main(String[] args) {
    CustomList<Integer> list = new CustomList<>(10);
    list.push(10);

    Iterator<Integer> it = list.iterator();

    while (it.hasNext()) {
      System.out.println(it.next());
    }

    System.out.println("Hello");
  }
}
