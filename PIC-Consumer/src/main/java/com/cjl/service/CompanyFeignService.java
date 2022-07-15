package com.cjl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cjl.form.CompanyForm;
import com.cjl.pojo.Company;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@FeignClient(value = "IMAS-PIC-Productor")
public interface CompanyFeignService{
    @PostMapping("/company")
    public String insert(@RequestParam("companyForm") CompanyForm companyForm);

    @GetMapping("/company/delete/{companyId}")
    public String delete(@PathVariable("companyId") Integer companyId);

    @GetMapping("/company/{id}")
    public Company getCompanyById(@PathVariable("id") Integer companyId);

    @GetMapping("/company/{companyName}/{page}")
    public List<Company> getCompanyByPage(@PathVariable("companyName") String companyName,
                                          @PathVariable("page") Integer page);

    @GetMapping("/company/list/{page}")
    public List<Company> listCompanyByPage(@PathVariable("page") Integer page);
}
