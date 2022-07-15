package com.cjl.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cjl.mapper.IdolMapper;
import com.cjl.pojo.Idol;
import com.cjl.service.IdolService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class IdolServiceImpl extends ServiceImpl<IdolMapper, Idol> implements IdolService {

    @Resource
    private IdolMapper idolMapper;

    @Override
    public String insert(Idol idol) {
        int result = idolMapper.insert(idol);
        return result == 1 ? "Success" : "Fail";
    }

    @Override
    public String delete(Integer idolId) {
        int result = idolMapper.deleteById(idolId);
        return result == 1 ? "Success" : "Fail";
    }

    @Override
    public List<Idol> listIdols(Integer pageNums) {
        int pageSize = 10;
        QueryWrapper<Idol> idolQueryWrapper = new QueryWrapper<>();
        Page<Idol> page = new Page<>(pageNums, pageSize);
        List<Idol> idolList = idolMapper.selectPage(page, idolQueryWrapper).getRecords();
        return idolList;
    }

    @Override
    public List<Idol> findIdolByName(String idolName, Integer pageNums) {
        int pageSize = 10;
        QueryWrapper<Idol> idolQueryWrapper = new QueryWrapper<>();
        idolQueryWrapper.like("idol_name", idolName);
        Page<Idol> page = new Page<>(pageNums, pageSize);
        List<Idol> idolList = idolMapper.selectPage(page, idolQueryWrapper).getRecords();
        return idolList;
    }

    @Override
    public Idol findIdolById(Integer id) {
        Idol idol = idolMapper.selectById(id);
        return idol;
    }

    @Override
    public List<Idol> findIdolByCompany(Integer companyId, Integer pageNums) {
        int pageSize = 10;
        QueryWrapper<Idol> idolQueryWrapper = new QueryWrapper<>();
        idolQueryWrapper.eq("company_id", companyId);
        Page<Idol> page = new Page<>(pageNums, pageSize);
        List<Idol> idolList = idolMapper.selectPage(page, idolQueryWrapper).getRecords();
        return idolList;
    }

    @Override
    public List<Idol> findIdolByCompanyAndName(Integer companyId, String idolName, Integer pageNums) {
        int pageSize = 10;
        QueryWrapper<Idol> idolQueryWrapper = new QueryWrapper<>();
        idolQueryWrapper.like("idol_name", idolName);
        idolQueryWrapper.eq("company_id", companyId);
        Page<Idol> page = new Page<>(pageNums, pageSize);
        List<Idol> idolList = idolMapper.selectPage(page, idolQueryWrapper).getRecords();
        return idolList;
    }
}
