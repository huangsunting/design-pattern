package com.bravo.pattern.composite.after;

public interface BoxComponent {

    // Box、Product、VerificationCard都是一种包裹组件，具备计价行为
    double calculatePrice();

}