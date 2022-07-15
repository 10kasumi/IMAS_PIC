package com.cjl.controller;

import com.cjl.form.CardForm;
import com.cjl.pojo.Card;
import com.cjl.service.CardFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CardFeignController {

    @Autowired
    private CardFeignService cardFeignService;

    @PostMapping("/consumer/card")
    public String insert(@RequestParam("cardForm") CardForm cardForm) {
        return cardFeignService.insert(cardForm);
    }

    @GetMapping("/consumer/card/delete/{cardId}")
    public String delete(@PathVariable("cardId") Integer cardId) {
        return cardFeignService.delete(cardId);
    }

    @GetMapping("/consumer/card/{id}")
    public Card getCardById(@PathVariable("id") Integer cardId) {
        return cardFeignService.getCardById(cardId);
    }

    @GetMapping("/consumer/card/{cardName}/{page}")
    public List<Card> getCardByCardName(@PathVariable("cardName") String cardName,
                                        @PathVariable("page") Integer page) {
        return cardFeignService.getCardByCardName(cardName, page);
    }

    @GetMapping("/consumer/idolCard/{idolId}/{page}")
    public List<Card> getCardByIdol(@PathVariable("idolId") Integer idolId,
                                    @PathVariable("page") Integer page) {
        return cardFeignService.getCardByIdol(idolId, page);
    }

    @GetMapping("/consumer/card/list/{page}")
    public List<Card> listCardByPage(@PathVariable("page") Integer pageNums) {
        return cardFeignService.listCardByPage(pageNums);
    }

    @PostMapping("/consumer/card/{page}")
    public List<Card> getCardByIdolAndName(@PathVariable("page") Integer pageNUms,
                                           @RequestParam("cardName") String cardName,
                                           @RequestParam("idolId") Integer idolId) {
        return cardFeignService.getCardByIdolAndName(pageNUms, cardName, idolId);
    }
}
