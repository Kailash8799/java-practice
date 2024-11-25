import java.util.ArrayList;
import java.util.List;

public class JavaList {

  public static void main(String[] args) {
    List<Integer> alist = new ArrayList<>();
    alist.add(10);
    alist.add(20);
    alist.add(30);
    alist.set(0, 1000);
    System.out.println(alist.indexOf(100));

    for (Integer aInteger : alist) {
      System.out.println(aInteger);
    }
  }
}
