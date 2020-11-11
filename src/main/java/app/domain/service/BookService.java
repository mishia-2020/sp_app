package app.domain.service;

import app.apl.resorce.BookRequest;
import app.apl.resorce.BookResponse;
import app.infrastructure.mapper.mrs.BookExtMapper;
import core.infrastructure.mapper.mrs.BookMapper;
import core.infrastructure.model.mrs.Book;
import core.infrastructure.model.mrs.BookExample;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    @Autowired
    BookMapper bookMapper;

    @Autowired
    BookExtMapper bookExtMapper;

    /**
     * 本の一覧を取得する.
     *
     * @return 本マスタ一覧
     */
    public List<BookResponse> getBookList() {


        List<Book> books = bookMapper.selectByExample(null);

        // 返却値生成
        List<BookResponse> resBooks = new ArrayList<>();
        books.forEach(book -> {

            BookResponse resBook = new BookResponse();
            resBook.setBookId(book.getBookId());
            resBook.setName(book.getBookName());
            resBooks.add(resBook);
        });
        return resBooks;
    }

    public Book getBook() {

        return bookExtMapper.selectByBookByBookId();
    }

    public void putBook(BookRequest book) {

        BookExample exampl = new BookExample();
        exampl.createCriteria()
                .andBookIdEqualTo(book.getBookId());
        exampl.setNowait(true);

        Book updata = new Book();
        updata.setBookId(book.getBookId());
        updata.setBookName(book.getName());

        bookMapper.selectByExampleWithLock(exampl);
        bookMapper.updateByExample(updata, exampl);

    }


}
