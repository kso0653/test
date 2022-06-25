package mybatis.boarduk.service;

import lombok.RequiredArgsConstructor;
import mybatis.boarduk.mapper.EmployeeMapper;
import mybatis.boarduk.domain.Company;
import mybatis.boarduk.mapper.CompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {

    @Autowired
    private CompanyMapper companyMapper;

    @Autowired
    private EmployeeMapper employeeMapper;

    public List<Company> getAll() {
        List<Company> companyList = companyMapper.getAll();
        if (companyList != null && companyList.size() > 0) {
            for(Company company : companyList) {
                company.setEmployeeList(employeeMapper.getByCompanyId(company.getId()));
//                System.out.println("test");
            }
        }
        return companyList;
    }

    @Transactional(rollbackFor = Exception.class)
     public Company add(Company company) throws Exception {
        if (true) {
            companyMapper.insert(company);
        } else {
            // add company into legacy system
            throw new Exception("Legacy Exception");
        }
        return company;
    }
}