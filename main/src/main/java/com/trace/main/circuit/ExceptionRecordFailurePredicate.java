package com.trace.main.circuit;

import java.util.concurrent.TimeoutException;
import java.util.function.Predicate;

import feign.FeignException;
import feign.RetryableException;

public class ExceptionRecordFailurePredicate implements Predicate<Throwable> {

    @Override
    public boolean test(Throwable t) {
        if (t instanceof TimeoutException) {
            return true;
        }

        if (t instanceof RetryableException) {
            return true;
        }

        return t instanceof FeignException.FeignServerException;
    }
    
}
