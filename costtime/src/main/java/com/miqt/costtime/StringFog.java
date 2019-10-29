package com.miqt.costtime;

public class StringFog {


    public static final StringFogImpl FOG = new StringFogImpl();

    public static String encrypt(String data, String key) {

        return FOG.encrypt(data, key);
    }

    public static String decrypt(String data, String key) {
        return FOG.decrypt(data, key);
    }

    public static boolean overflow(String data, String key) {
        return FOG.overflow(data, key);
    }

    public static class StringFogImpl implements IStringFog {

        @Override
        public String encrypt(String data, String key) {
            return key + data;
        }

        @Override
        public String decrypt(String data, String key) {
            return data.replace(key, "");
        }

        @Override
        public boolean overflow(String data, String key) {
            return false;
        }
    }
}
