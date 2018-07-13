package org.sheamus.java.enumerate;

/**
 * Created by Sheamus on 2018/7/13.
 */
public enum NumberEnum {
    FIRST {
        @Override
        public String getInfo() {
            return "first day";
        }
    },SECOND {
        @Override
        public String getInfo() {
            return "last day";
        }
    };
    public abstract String getInfo();
}
