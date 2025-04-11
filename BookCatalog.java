public class BookCatalog {
    private MyArrayList<Book> books = new MyArrayList<>();

    // Thêm sách mới nếu chưa trùng tiêu đề
    public void addBook(Book book) {
        if (book == null || book.getTitle().trim().isEmpty()) {
            System.out.println("❌ Invalid book.");
            return;
        }

        if (contains(book.getTitle())) {
            System.out.println("⚠️ Book already exists in the catalog.");
            return;
        }

        books.add(book);
        System.out.println("✅ Book added: " + book.getTitle());
    }

    // Kiểm tra trùng tiêu đề sách
    public boolean contains(String title) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().equalsIgnoreCase(title)) {
                return true;
            }
        }
        return false;
    }

    // Hiển thị tất cả sách
    public void displayBooks() {
        if (books.size() == 0) {
            System.out.println("📚 Catalog is empty.");
            return;
        }

        System.out.println("📚 Book Catalog:");
        for (int i = 0; i < books.size(); i++) {
            System.out.println((i + 1) + ". " + books.get(i)); // gọi toString() trong Book
        }
    }

    // Sắp xếp danh mục theo tiêu đề
    public void sortBooks() {
        books.sort();
        System.out.println("📖 Catalog sorted by title.");
    }

    // Trả về sách theo tiêu đề (nếu cần dùng)
    public Book getBookByTitle(String title) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().equalsIgnoreCase(title)) {
                return books.get(i);
            }
        }
        return null;
    }
    public Book findBookByTitle(String title) {
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
    
}
