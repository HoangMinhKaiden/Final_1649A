public class MyQueue<T> {
    private static class Node<T> {
        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
        }
    }

    private Node<T> front; // đầu hàng đợi (dequeue từ đây)
    private Node<T> rear;  // cuối hàng đợi (enqueue vào đây)
    private int size = 0;

    // Thêm phần tử vào cuối hàng đợi
    public void enqueue(T value) {
        Node<T> newNode = new Node<>(value);
        if (rear != null) {
            rear.next = newNode;
        }
        rear = newNode;
        if (front == null) {
            front = newNode;
        }
        size++;
    }

    // Lấy và xoá phần tử ở đầu hàng đợi
    public T dequeue() {
        if (front == null) return null;
        T value = front.value;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return value;
    }

    // Kiểm tra hàng đợi rỗng
    public boolean isEmpty() {
        return size == 0;
    }

    // Trả về số phần tử trong hàng đợi
    public int size() {
        return size;
    }

    // Xem phần tử đầu tiên mà không xoá
    public T peek() {
        if (front == null) return null;
        return front.value;
    }
}
