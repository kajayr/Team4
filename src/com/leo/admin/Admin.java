package com.leo.admin;

public class Admin implements AdminAccess{

    @Override
    public String filterUserByPhoneNumber() {
        return null;
    }

    @Override
    public String filterUserByAddress() {
        return null;
    }

    @Override
    public String filterUserBySalary() {
        return null;
    }

    @Override
    public int updateInterestRate() {
        return 0;
    }

    @Override
    public int updateLoadOption() {
        return 0;
    }

    @Override
    public String updateCreditCardPolicy() {
        return null;
    }
}
