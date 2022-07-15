package com.cjl.controller;

import com.cjl.form.CardForm;
import com.cjl.pojo.Card;
import com.cjl.service.CardService;
import com.cjl.utils.PmsUploadUtil;
import com.cjl.utils.RankCheckUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

@RestController
public class CardController {

    @Resource
    private CardService cardService;

    @PostMapping("/card")
    public String insert(@RequestParam("cardForm") CardForm cardForm) {
        Card card = new Card();
        if (!cardForm.getMultipartFile().isEmpty()) {
            String picPath = PmsUploadUtil.uploadImage(cardForm.getMultipartFile());
            card.setPicPath(picPath);
            try {
                BufferedImage bufferedImage = ImageIO.read(cardForm.getMultipartFile().getInputStream());
                if (null == bufferedImage) {
                    card.setHeight(0);
                    card.setWidth(0);
                }
                card.setHeight(bufferedImage.getHeight());
                card.setWidth(bufferedImage.getWidth());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        card.setCardName(cardForm.getCardName());
        card.setIdolId(card.getIdolId());
        if (RankCheckUtil.checkIsRank(cardForm.getRareRank())) {
            card.setRareRank(cardForm.getRareRank());
        }
        card.setSkillDescription(cardForm.getSkillDescription());
        StringBuilder builder = new StringBuilder();
        Integer[][] lv = cardForm.getLv();
        for (int i = 0; i < lv.length; i++) {
            for (int j = 0; j < lv[0].length; j++) {
                builder.append(lv[i][j]);
                if (j != lv[0].length - 1) {
                    builder.append(",");
                }
            }
            builder.append(";");
        }
        card.setLv(builder.toString());
        String result = cardService.insert(card);
        return result;
    }

    @GetMapping("/card/delete/{cardId}")
    public String delete(@PathVariable("cardId") Integer cardId) {
        String result = cardService.delete(cardId);
        return result;
    }

    @GetMapping("/card/{id}")
    public Card getCardById(@PathVariable("id") Integer cardId) {
        Card card = cardService.findCardById(cardId);
        return card;
    }

    @GetMapping("/card/{cardName}/{page}")
    public List<Card> getCardByCardName(@PathVariable("cardName") String cardName,
                                        @PathVariable("page") Integer page) {
        List<Card> cardList = cardService.findCardByName(cardName, page);
        return cardList;
    }

    @GetMapping("/idolCard/{idolId}/{page}")
    public List<Card> getCardByIdol(@PathVariable("idolId") Integer idolId,
                                    @PathVariable("page") Integer page) {
        List<Card> cardList = cardService.findCardByIdol(idolId, page);
        return cardList;
    }

    @GetMapping("/card/list/{page}")
    public List<Card> listCardByPage(@PathVariable("page") Integer pageNums) {
        List<Card> cardList = cardService.listCards(pageNums);
        return cardList;
    }

    @PostMapping("/card/{page}")
    public List<Card> getCardByIdolAndName(@PathVariable("page") Integer pageNUms,
                                           @RequestParam("cardName") String cardName,
                                           @RequestParam("idolId") Integer idolId) {
        List<Card> cardList = cardService.findCardByIdolAndName(idolId, cardName, pageNUms);
        return cardList;
    }
}
