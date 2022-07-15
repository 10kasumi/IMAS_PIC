package com.cjl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cjl.form.IdolForm;
import com.cjl.pojo.Idol;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@FeignClient(value = "IMAS-PIC-Productor")
public interface IdolFeignService{
    @PostMapping("/idol")
    public String insert(@RequestParam("idolForm") IdolForm idolForm);

    @GetMapping("/idol/delete/{idolId}")
    public String delete(@PathVariable("idolId") Integer idolId);

    @GetMapping("/idol/{id}")
    public Idol getIdolById(@PathVariable("id") Integer idolId);

    @GetMapping("/idol/{idolName}/{page}")
    public List<Idol> getIdolByPage(@PathVariable("idolName") String idolName,
                                    @PathVariable("page") Integer page);

    @GetMapping("/companyIdol/{companyId}/{page}")
    public List<Idol> getIdolByCompany(@PathVariable("companyId") Integer companyId,
                                       @PathVariable("page") Integer page);

    @GetMapping("/idol/list/{page}")
    public List<Idol> listIdolByPage(@PathVariable("page") Integer pageNums);

    @PostMapping("/idol/{page}")
    public List<Idol> getIdolByCompanyAndName(@PathVariable("page") Integer pageNUms,
                                              @RequestParam("idolName") String idolName,
                                              @RequestParam("companyId") Integer companyId);
}
