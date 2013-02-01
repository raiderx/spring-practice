package org.karpukhin.springpractice.scan.bean;

import org.karpukhin.springpractice.scan.Service;

/**
 * @author Pavel Karpukhin
 * @since 01.02.13
 */
public class MyService implements Service {

    @Override
    public void someMethod() {
        System.out.println("Test");
    }
}
