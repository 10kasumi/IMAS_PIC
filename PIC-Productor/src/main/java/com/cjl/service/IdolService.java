package com.cjl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cjl.pojo.Idol;

import java.util.List;

public interface IdolService extends IService<Idol> {
    public String insert(Idol idol);

    public String delete(Integer idolId);

    public List<Idol> listIdols(Integer page);

    public List<Idol> findIdolByName(String idolName, Integer page);

    public Idol findIdolById(Integer id);

    public List<Idol> findIdolByCompany(Integer companyId, Integer page);

    public List<Idol> findIdolByCompanyAndName(Integer companyId, String idolName, Integer page);
}
