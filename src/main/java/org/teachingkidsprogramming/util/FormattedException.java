package org.teachingkidsprogramming.util;


import com.spun.util.MySystem;

public class FormattedException extends RuntimeException {

    public FormattedException(String string, Object... params) {
        super(String.format(string, params));
        MySystem.variable(this.getMessage());
    }
}
