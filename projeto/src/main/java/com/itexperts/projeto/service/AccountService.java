package com.itexperts.projeto.service;

import com.itexperts.projeto.enums.CardTypeEnum;
import com.itexperts.projeto.model.Account;
import com.itexperts.projeto.model.Card;
import com.itexperts.projeto.model.CardType;
import com.itexperts.projeto.repository.AccountRepository;
import com.itexperts.projeto.repository.CardRepository;
import com.itexperts.projeto.repository.CardTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {


    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private CardTypeRepository cardTypeRepository;

    @Transactional
    public Account create(Account account) {
        persistCardEntity(account);
        return accountRepository.save(account);
    }


    private void persistCardEntity(Account account) {
        List<Card> cards = account.getCards();
        for (Card card : cards) {
            card.setAccount(account);
            cardRepository.save(card);
        }
    }

}
