package core.infrastructure.mapper.mrs;

import core.infrastructure.model.mrs.Book;
import core.infrastructure.model.mrs.BookExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BookMapper {

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(BookExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(BookExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(Book record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(Book record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<Book> selectByExampleWithLock(BookExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<Book> selectByExample(BookExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") Book record, @Param("example") BookExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") Book record, @Param("example") BookExample example);
}