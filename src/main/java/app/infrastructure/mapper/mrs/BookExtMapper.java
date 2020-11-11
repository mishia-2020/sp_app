package app.infrastructure.mapper.mrs;

import core.infrastructure.model.mrs.Book;
import core.infrastructure.model.mrs.BookExample;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookExtMapper {
    Book selectByBookByBookId();
}
