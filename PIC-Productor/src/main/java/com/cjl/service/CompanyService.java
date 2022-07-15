package com.cjl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cjl.pojo.Company;

import java.util.List;

public interface CompanyService extends IService<Company> {
    public String insert(Company company);

    public List<Company> listCompany(Integer page);

    public String delete(Integer companyId);

    public Company getCompanyById(Integer companyId);

    public List<Company> getCompanyByName(String companyName, Integer page);
}
