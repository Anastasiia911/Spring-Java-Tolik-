package com.study.lab1.handler;

import com.study.lab1.model.Account;
import com.study.lab1.model.Operation;
import com.study.lab1.model.Request;
import com.study.lab1.service.AccountService;
import com.study.lab1.service.RequestValidator;

public class RequestHandler {
    private AccountService accountService = new AccountService();
    private RequestValidator requestValidator = new RequestValidator();

    public void handle(Request request) {
        requestValidator.validate(request);
        Account accountFrom = accountService.getAccount(request.getAccountFromId());
        Account accountTo = accountService.getAccount(request.getAccountToId());
        Operation operation = Operation.getOperation(request.getOperation());

        accountService.operate(accountFrom, accountTo, operation);
    }

    public AccountService getAccountService() {
        return accountService;
    }
}
