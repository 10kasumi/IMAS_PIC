package com.cjl.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.cjl.pojo.Card;

import java.util.List;

public interface CardService extends IService<Card> {
    public String insert(Card card);

    public String delete(Integer cardId);

    public List<Card> listCards(Integer page);

    public List<Card> findCardByName(String cardName, Integer page);

    public Card findCardById(Integer cardId);

    public List<Card> findCardByIdol(Integer idolId, Integer page);

    public List<Card> findCardByIdolAndName(Integer idolId, String cardName, Integer pageNums);
}
