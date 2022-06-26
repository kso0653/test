package mybatis.boarduk.mapper;
/*

import mybatis.boarduk.domain.Company;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CompanyMapper  {

    @Insert("INSERT INTO company(company_name, company_address) VALUES(#{company.name}, #{company.address})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(@Param("company") Company company);

    @Select("SELECT * FROM company")
    @Results(id="CompanyMap", value = {
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "company_name"),
            @Result(property = "address", column = "company_address"),
            @Result(property = "employeeList", column = "id", many = @Many(select="mybatis.boarduk.mapper.EmployeeMapper.getByCompanyId"))
    })
    List<Company> getAll();

    @Select("SELECT * FROM company WHERE id=#{id}")
    @ResultMap("CompanyMap")
    Company getById(@Param("id") int id);

}
*/
