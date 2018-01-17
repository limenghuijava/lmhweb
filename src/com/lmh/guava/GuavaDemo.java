package com.lmh.guava;

import com.google.common.base.Strings;
import org.junit.Test;

public class GuavaDemo {

    @Test
    public void nullOrEmpty(){
        String a = null;
        System.out.println(Strings.isNullOrEmpty(a));
        System.out.println(Strings.nullToEmpty(a));
    }
}
