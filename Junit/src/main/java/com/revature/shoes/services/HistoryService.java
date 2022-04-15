package com.revature.shoes.services;

import com.revature.shoes.daos.CartDAO;
import com.revature.shoes.daos.CrudDAO;
import com.revature.shoes.daos.HistoryDAO;
import com.revature.shoes.models.History;


public class HistoryService {
    private final HistoryDAO historyDAO;


    public HistoryService(HistoryDAO historyDAO) {
        this.historyDAO = historyDAO;

    }

    public HistoryDAO getHistoryDAO() {
        return historyDAO;
    }


}
