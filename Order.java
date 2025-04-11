public class Order {
    private static int counter = 1;
    private int id;
    private Book book;
    private String customerName;
    private String address;
    private String phone;

    public Order(Book book, String customerName, String address, String phone) {
        this.id = counter++;
        this.book = book;
        this.customerName = customerName;
        this.address = address;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public double getTotal() {
        return book.getPrice();
    }
}
