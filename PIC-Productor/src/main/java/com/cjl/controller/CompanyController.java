package com.cjl.controller;

import com.cjl.form.CompanyForm;
import com.cjl.pojo.Company;
import com.cjl.service.CompanyService;
import com.cjl.utils.PmsUploadUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class CompanyController {

    @Resource
    private CompanyService companyService;

    @PostMapping("/company")
    public String insert(@RequestParam("companyForm") CompanyForm companyForm) {
        Company company = new Company();
        if (!companyForm.getMultipartFile().isEmpty()) {
            String picPath = PmsUploadUtil.uploadImage(companyForm.getMultipartFile());
            company.setPicPath(picPath);
        }
        company.setDescription(companyForm.getDescription());
        company.setCompanyName(companyForm.getName());
        String[] urls = companyForm.getUrls().split(";");
        company.setUrls(urls);
        String result = companyService.insert(company);
        return result;
    }

    @GetMapping("/company/delete/{companyId}")
    public String delete(@PathVariable("companyId") Integer companyId) {
        String result = companyService.delete(companyId);
        return result;
    }

    @GetMapping("/company/{id}")
    public Company getCompanyById(@PathVariable("id") Integer companyId) {
        Company company = companyService.getCompanyById(companyId);
        return company;
    }

    @GetMapping("/company/{companyName}/{page}")
    public List<Company> getCompanyByPage(@PathVariable("companyName") String companyName,
                                          @PathVariable("page") Integer page) {
        List<Company> companyList = companyService.getCompanyByName(companyName, page);
        return companyList;
    }

    @GetMapping("/company/list/{page}")
    public List<Company> listCompanyByPage(@PathVariable("page") Integer page) {
        List<Company> companyList = companyService.listCompany(page);
        return companyList;
    }

}
