package com.cjl.service;

import com.cjl.form.CardForm;
import com.cjl.pojo.Card;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@FeignClient(value = "IMAS-PIC-Productor")
public interface CardFeignService{

    @PostMapping("/card")
    public String insert(@RequestParam("cardForm") CardForm cardForm);

    @GetMapping("/card/delete/{cardId}")
    public String delete(@PathVariable("cardId") Integer cardId);

    @GetMapping("/card/{id}")
    public Card getCardById(@PathVariable("id") Integer cardId);

    @GetMapping("/card/{cardName}/{page}")
    public List<Card> getCardByCardName(@PathVariable("cardName") String cardName,
                                        @PathVariable("page") Integer page);

    @GetMapping("/idolCard/{idolId}/{page}")
    public List<Card> getCardByIdol(@PathVariable("idolId") Integer idolId,
                                    @PathVariable("page") Integer page);

    @GetMapping("/card/list/{page}")
    public List<Card> listCardByPage(@PathVariable("page") Integer pageNums);

    @PostMapping("/card/{page}")
    public List<Card> getCardByIdolAndName(@PathVariable("page") Integer pageNUms,
                                           @RequestParam("cardName") String cardName,
                                           @RequestParam("idolId") Integer idolId);

}
