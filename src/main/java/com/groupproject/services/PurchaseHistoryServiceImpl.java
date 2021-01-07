package com.groupproject.services;

import com.groupproject.entities.Account;
import com.groupproject.entities.PurchaseHistory;
import com.groupproject.repository.AccountRepository;
import com.groupproject.repository.PurchaseHistoryRepository;
import com.groupproject.requests.PurchaseHistoryRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Objects.isNull;

@Slf4j
@Service
public class PurchaseHistoryServiceImpl implements IPurchaseHistoryService{

    @Autowired
    private PurchaseHistoryRepository purchaseHistoryRepository;

    @Autowired
    private AccountRepository accountRepository;

    // list of all purchases
    @Override
    public List<PurchaseHistory> getAll() {
        log.info("Ready to find all the purchases");
        return purchaseHistoryRepository.findAll();
    }

    // purchase by id
    @Override
    public PurchaseHistory getById(Long id) {
        log.info("Ready to find the purchase ith id {}",id);
        return purchaseHistoryRepository.findById(id).orElse(null);
    }

    // new purchase
    @Override
    public void newPurchase(PurchaseHistoryRequest request) {
            Long id=request.getAccountId();
            Account account = accountRepository.findById(id).orElse(null);
            if(isNull(account)){
                log.info("Could not found the account");
            }
            log.info("Ready to create a new Purchase");
            PurchaseHistory purchaseHistory = new PurchaseHistory(request.getPurchaseDate(), request.getEurosSpent(), request.getPurchasedCoins(), account);
            purchaseHistoryRepository.save(purchaseHistory);
            log.info("The new purchase has been inserted to the DB");

    }

    // update purchase by id
    @Override
    public PurchaseHistory updatePurchase(Long id, PurchaseHistoryRequest request) {
        log.info("Ready to update a Purchase");
        PurchaseHistory purchaseHistory=purchaseHistoryRepository.findById(id).orElse(null);
        if (isNull(purchaseHistory)){
            log.info("The Purchase does not exists");
        }
        purchaseHistory.setPurchaseDate(request.getPurchaseDate());
        purchaseHistory.setEurosSpent(request.getEurosSpent());
        purchaseHistory.setPurchasedCoins(request.getPurchasedCoins());
        PurchaseHistory updatedPurchaseHistory=purchaseHistoryRepository.save(purchaseHistory);
        log.info("Purchase has been updated");
        return updatedPurchaseHistory;
    }

    // delete a purchase by id
    @Override
    public boolean deletePurchase(Long id) {
        log.info("Ready to delete a purchase with the id {}",id);
        if (purchaseHistoryRepository.existsById(id)){
            purchaseHistoryRepository.deleteById(id);
            log.info("purchase deleted successfully");
            return true;
        }
        log.info("purchase has not deleted successfully");
        return false;
    }
}
