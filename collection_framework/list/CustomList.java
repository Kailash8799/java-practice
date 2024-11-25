import java.util.Iterator;

public class CustomList<T> implements Iterable<T> {

  private T[] item;
  private int size;
  private int currentIndex = 0;

  @SuppressWarnings("unchecked")
  public CustomList(int size) {
    this.size = size;
    this.item = (T[]) new Object[size];
  }

  public void push(T value) {
    if (currentIndex >= size) {
      throw new IndexOutOfBoundsException("List is full");
    }
    this.item[this.currentIndex++] = value;
  }

  public T get(int index) {
    if (index >= currentIndex || index < 0) {
      throw new IndexOutOfBoundsException("Index not found");
    }
    return this.item[index];
  }

  @Override
  public Iterator<T> iterator() {
    return new CustomIterator(this);
  }

  private class CustomIterator implements Iterator<T> {

    private CustomList<T> list;
    private int index = 0;

    CustomIterator(CustomList<T> list) {
      this.list = list;
    }

    @Override
    public boolean hasNext() {
      return index < list.currentIndex;
    }

    @Override
    public T next() {
      if (!hasNext()) {
        throw new IndexOutOfBoundsException("No more elements");
      }
      return list.item[index++];
    }
  }
}
