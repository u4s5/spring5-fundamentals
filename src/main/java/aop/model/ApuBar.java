package aop.model;

import aop.AopLog;

public class ApuBar implements Bar {

    @Override
    public Squishee sellSquishee(Customer customer) {
        if (customer.isBroke())
            throw new CustomerBrokenException();

        AopLog.append("Here is your Squishee \n");
        return new Squishee("Usual Squishee");
    }
}
