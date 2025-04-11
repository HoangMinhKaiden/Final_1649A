public class OrderManager {
    private MyQueue<Order> orderQueue = new MyQueue<>(); // dùng MyQueue tự cài đặt bằng Node

    public void placeOrder(Order order) {
        orderQueue.enqueue(order); // thêm đơn hàng vào hàng đợi
        System.out.println("✅ Order placed: ID = " + order.getId() + ", Book = '" + getBookTitles(order) + "'");
    }

    public void processNextOrder() {
        if (!orderQueue.isEmpty()) {
            Order order = orderQueue.dequeue(); // lấy đơn đầu tiên
            System.out.println("📦 Processing Order ID = " + order.getId());
            System.out.println("📚 Book(s): " + getBookTitles(order));
            System.out.println("🧑 Customer: " + order.getCustomerName());
            System.out.println("🏡 Address: " + order.getAddress());
            System.out.println("📞 Phone: " + order.getPhone());
            System.out.println("💳 Total: $" + order.getTotal());
        } else {
            System.out.println("❌ No orders to process.");
        }
    }

    private String getBookTitles(Order order) {
        return order.getBook().getTitle();
    }
    
}
