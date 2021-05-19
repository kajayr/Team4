package com.leo.admin;

public interface AdminAccess {
    String filterUserByPhoneNumber();
    String filterUserByAddress();
    String filterUserBySalary();
    int updateInterestRate();
    int updateLoadOption();
    String updateCreditCardPolicy();
}
