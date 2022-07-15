package com.cjl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cjl.mapper.CardMapper;
import com.cjl.pojo.Card;
import com.cjl.service.CardService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class CardServiceImpl extends ServiceImpl<CardMapper, Card> implements CardService {

    @Resource
    private CardMapper cardMapper;

    @Override
    public String insert(Card card) {
        int result = cardMapper.insert(card);
        return result == 1 ? "Success" : "Fail";
    }

    @Override
    public String delete(Integer cardId) {
        int result = cardMapper.deleteById(cardId);
        return result == 1 ? "Success" : "Fail";
    }

    @Override
    public List<Card> listCards(Integer pageNums) {
        int pageSize = 10;
        QueryWrapper<Card> cardQueryWrapper = new QueryWrapper<>();
        Page<Card> page = new Page<>(pageNums, pageSize);
        List<Card> cardList = cardMapper.selectPage(page, cardQueryWrapper).getRecords();
        return cardList;
    }

    @Override
    public List<Card> findCardByName(String cardName, Integer pageNums) {
        int pageSize = 10;
        QueryWrapper<Card> cardQueryWrapper = new QueryWrapper<>();
        cardQueryWrapper.like("card_name", cardName);
        Page<Card> page = new Page<>(pageNums, pageSize);
        List<Card> cardList = cardMapper.selectPage(page, cardQueryWrapper).getRecords();
        return cardList;
    }

    @Override
    public Card findCardById(Integer cardId) {
        Card card = cardMapper.selectById(cardId);
        return card;
    }

    @Override
    public List<Card> findCardByIdol(Integer idolId, Integer pageNums) {
        int pageSize = 10;
        QueryWrapper<Card> cardQueryWrapper = new QueryWrapper<>();
        cardQueryWrapper.eq("idol_id", idolId);
        Page<Card> page = new Page<>(pageNums, pageSize);
        List<Card> cardList = cardMapper.selectPage(page, cardQueryWrapper).getRecords();
        return cardList;
    }

    @Override
    public List<Card> findCardByIdolAndName(Integer idolId, String cardName, Integer pageNums) {
        int pageSize = 10;
        QueryWrapper<Card> cardQueryWrapper = new QueryWrapper<>();
        cardQueryWrapper.like("card_name", cardName);
        cardQueryWrapper.eq("idol_id", idolId);
        Page<Card> page = new Page<>(pageNums, pageSize);
        List<Card> cardList = cardMapper.selectPage(page, cardQueryWrapper).getRecords();
        return cardList;
    }
}
