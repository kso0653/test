package mybatis.boarduk.controller;
/*
import lombok.RequiredArgsConstructor;
import mybatis.boarduk.domain.Company;
import mybatis.boarduk.mapper.CompanyMapper;
import mybatis.boarduk.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
@RequiredArgsConstructor // 생성자 주입
public class    CompanyController {

    private CompanyMapper companyMapper;

    private CompanyService companyService;

    @PostMapping("")
    public Company post(@RequestBody Company company) throws Exception {
//        companyMapper.insert(company);
        companyService.add(company);
        return company;
    }

    @GetMapping("")
    public List<Company> getAll() {
        return companyMapper.getAll();
//        return companyService.getAll();
    }

    @GetMapping("/{id}")
    public Company getById(@PathVariable("id") int id) {
        return companyMapper.getById(id);
    }

}
*/