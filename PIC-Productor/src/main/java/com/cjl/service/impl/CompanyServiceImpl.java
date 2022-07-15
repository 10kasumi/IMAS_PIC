package com.cjl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cjl.mapper.CompanyMapper;
import com.cjl.pojo.Company;

import com.cjl.service.CompanyService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, Company> implements CompanyService {

    @Resource
    CompanyMapper companyMapper;

    @Override
    public String insert(Company company) {
        int result = companyMapper.insert(company);
        return result == 1 ? "Success" : "Fail";
    }

    @Override
    public List<Company> listCompany(Integer pageNums) {
        int pageSize = 10;
        QueryWrapper<Company> companyQueryWrapper = new QueryWrapper<>();
        Page<Company> page = new Page<>(pageNums, pageSize);
        List<Company> companyList = companyMapper.selectPage(page, companyQueryWrapper).getRecords();
        return companyList;
    }

    @Override
    public String delete(Integer companyId) {
        int result = companyMapper.deleteById(companyId);
        return result == 1 ? "Success" : "Fail";
    }

    @Override
    public Company getCompanyById(Integer companyId) {
        return companyMapper.selectById(companyId);
    }

    @Override
    public List<Company> getCompanyByName(String companyName, Integer pageNums) {
        int pageSize = 10;
        QueryWrapper<Company> companyQueryWrapper = new QueryWrapper<>();
        companyQueryWrapper.like("company_name", companyName);
        Page<Company> page = new Page<>(pageNums, pageSize);
        List<Company> companyList = companyMapper.selectPage(page, companyQueryWrapper).getRecords();
        return companyList;
    }
}
