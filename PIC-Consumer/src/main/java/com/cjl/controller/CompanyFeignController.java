package com.cjl.controller;

import com.cjl.form.CompanyForm;
import com.cjl.pojo.Company;
import com.cjl.service.CompanyFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CompanyFeignController {

    @Autowired
    private CompanyFeignService companyFeignService;

    @PostMapping("/consumer/company")
    public String insert(@RequestParam("companyForm") CompanyForm companyForm) {
        return companyFeignService.insert(companyForm);
    }

    @GetMapping("/consumer/company/delete/{companyId}")
    public String delete(@PathVariable("companyId") Integer companyId) {
        return companyFeignService.delete(companyId);
    }

    @GetMapping("/consumer/company/{id}")
    public Company getCompanyById(@PathVariable("id") Integer companyId) {
        return companyFeignService.getCompanyById(companyId);
    }

    @GetMapping("/consumer/company/{companyName}/{page}")
    public List<Company> getCompanyByPage(@PathVariable("companyName") String companyName,
                                          @PathVariable("page") Integer page) {
        return companyFeignService.getCompanyByPage(companyName, page);
    }

    @GetMapping("/consumer/company/list/{page}")
    public List<Company> listCompanyByPage(@PathVariable("page") Integer page) {
        return companyFeignService.listCompanyByPage(page);
    }

}
