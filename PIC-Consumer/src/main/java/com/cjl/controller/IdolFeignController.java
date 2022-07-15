package com.cjl.controller;

import com.cjl.form.IdolForm;
import com.cjl.pojo.Idol;
import com.cjl.service.IdolFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IdolFeignController {

    @Autowired
    private IdolFeignService idolFeignService;

    @PostMapping("/consumer/idol")
    public String insert(@RequestParam("idolForm") IdolForm idolForm) {
        return idolFeignService.insert(idolForm);
    }

    @GetMapping("/consumer/idol/delete/{idolId}")
    public String delete(@RequestParam("idolId") Integer idolId) {
        return idolFeignService.delete(idolId);
    }

    @GetMapping("/consumer/idol/{id}")
    public Idol getIdolById(@PathVariable("id") Integer idolId) {
        return idolFeignService.getIdolById(idolId);
    }

    @GetMapping("/consumer/idol/{idolName}/{page}")
    public List<Idol> getIdolByPage(@PathVariable("idolName") String idolName,
                                    @PathVariable("page") Integer page) {
        return idolFeignService.getIdolByPage(idolName, page);
    }

    @GetMapping("/consumer/companyIdol/{companyId}/{page}")
    public List<Idol> getIdolByCompany(@PathVariable("companyId") Integer companyId,
                                       @PathVariable("page") Integer page) {
        return idolFeignService.getIdolByCompany(companyId, page);
    }

    @GetMapping("/consumer/idol/list/{page}")
    public List<Idol> listIdolByPage(@PathVariable("page") Integer pageNums) {
        return idolFeignService.listIdolByPage(pageNums);
    }

    @PostMapping("/consumer/idol/{page}")
    public List<Idol> getIdolByCompanyAndName(@PathVariable("page") Integer pageNums,
                                              @RequestParam("idolName") String idolName,
                                              @RequestParam("companyId") Integer companyId) {
        return idolFeignService.getIdolByCompanyAndName(pageNums, idolName, companyId);
    }
}
