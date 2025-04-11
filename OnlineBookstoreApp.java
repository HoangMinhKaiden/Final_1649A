import java.util.Scanner;

public class OnlineBookstoreApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookCatalog catalog = new BookCatalog();
        OrderManager orderManager = new OrderManager();

        while (true) {
            System.out.println("\n=== Online Bookstore Menu ===");
            System.out.println("1. Add Book to Catalog");
            System.out.println("2. Display Catalog");
            System.out.println("3. Sort Catalog");
            System.out.println("4. Place Order");
            System.out.println("5. Process Order");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine(); // consume leftover newline

                    Book newBook = new Book(title, author, price);
                    catalog.addBook(newBook);
                    break;

                case 2:
                    catalog.displayBooks();
                    break;
                case 3:
                    catalog.sortBooks();
                    System.out.println("Catalog sorted.");
                    break;
                case 4:
        
                    System.out.print("Enter book title to order: ");
                    String bookToOrder = scanner.nextLine();
                    Book selectedBook = catalog.findBookByTitle(bookToOrder);

                    if (selectedBook != null) {
                        System.out.print("Enter your name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter your address: ");
                        String address = scanner.nextLine();
                        System.out.print("Enter your phone: ");
                        String phone = scanner.nextLine();

                        Order order = new Order(selectedBook, name, address, phone);
                        orderManager.placeOrder(order);
                    } else {
                        System.out.println("Book not found in catalog.");
                    }
                    break;

                case 5:
                    orderManager.processNextOrder();
                    break;
                case 6:
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
