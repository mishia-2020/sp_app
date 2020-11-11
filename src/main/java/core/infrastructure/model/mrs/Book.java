package core.infrastructure.model.mrs;

/**
 * Table: mrs.book
 */
public class Book {
    /**
     * Column: book_id
     */
    private String bookId;

    /**
     * Column: book_name
     */
    private String bookName;

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId == null ? null : bookId.trim();
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName == null ? null : bookName.trim();
    }
}