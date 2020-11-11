package core.infrastructure.mapper.mrs;

import core.infrastructure.model.mrs.Employee;
import core.infrastructure.model.mrs.EmployeeExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface EmployeeMapper {

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(EmployeeExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(EmployeeExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(Employee record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(Employee record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<Employee> selectByExampleWithLock(EmployeeExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<Employee> selectByExample(EmployeeExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") Employee record, @Param("example") EmployeeExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") Employee record, @Param("example") EmployeeExample example);
}