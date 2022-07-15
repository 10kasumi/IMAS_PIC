package com.cjl.controller;

import com.cjl.form.IdolForm;
import com.cjl.pojo.Idol;
import com.cjl.service.IdolService;
import com.cjl.utils.PmsUploadUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class IdolController {

    @Resource
    private IdolService idolService;

    @PostMapping("/idol")
    public String insert(@RequestParam("idolForm") IdolForm idolForm) {
        Idol idol = new Idol();
        if (!idolForm.getMultipartFile().isEmpty()) {
            String picPath = PmsUploadUtil.uploadImage(idolForm.getMultipartFile());
            idol.setPicPath(picPath);
        }
        idol.setAge(idolForm.getAge());
        idol.setCompanyId(idolForm.getCompanyId());
        idol.setIdolName(idolForm.getName());
        idol.setSlogan(idolForm.getSlogan());
        idol.setHobby(idolForm.getHobby());
        idol.setHeight(idolForm.getHeight());
        idol.setFigure(idolForm.getFigure());
        String result = idolService.insert(idol);
        return result;
    }

    @GetMapping("/idol/delete/{idolId}")
    public String delete(@PathVariable("idolId") Integer idolId) {
        String result = idolService.delete(idolId);
        return result;
    }

    @GetMapping("/idol/{id}")
    public Idol getIdolById(@PathVariable("id") Integer idolId) {
        Idol idol = idolService.findIdolById(idolId);
        return idol;
    }

    @GetMapping("/idol/{idolName}/{page}")
    public List<Idol> getIdolByPage(@PathVariable("idolName") String idolName,
                                    @PathVariable("page") Integer page) {
        List<Idol> idolList = idolService.findIdolByName(idolName, page);
        return idolList;
    }

    @GetMapping("/companyIdol/{companyId}/{page}")
    public List<Idol> getIdolByCompany(@PathVariable("companyId") Integer companyId,
                                       @PathVariable("page") Integer page) {
        List<Idol> idolList = idolService.findIdolByCompany(companyId, page);
        return idolList;
    }

    @GetMapping("/idol/list/{page}")
    public List<Idol> listIdolByPage(@PathVariable("page") Integer pageNums) {
        List<Idol> idolList = idolService.listIdols(pageNums);
        return idolList;
    }

    @PostMapping("/idol/{page}")
    public List<Idol> getIdolByCompanyAndName(@PathVariable("page") Integer pageNUms,
                                              @RequestParam("idolName") String idolName,
                                              @RequestParam("companyId") Integer companyId) {
        List<Idol> idolList = idolService.findIdolByCompanyAndName(companyId, idolName, pageNUms);
        return idolList;
    }
}
