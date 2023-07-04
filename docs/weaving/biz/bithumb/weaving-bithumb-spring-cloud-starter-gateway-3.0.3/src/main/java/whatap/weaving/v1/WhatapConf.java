package whatap.weaving.v1;

/**
 * 와탭 설정값을 호출할 수 있다.
 *
 * @since agent v2.0_55-20210825
 */
public class WhatapConf {

    /**
     * @since agent v2.0_55-20210825
     */
    public static String get(String key) {
        return null;
    }

    /**
     * @since agent v2.0_55-20210825
     */
    public static boolean getBoolean(String key, boolean def) {
        String v = get(key);
        if (v == null || v.length() == 0)
            return def;
        return "true".equalsIgnoreCase(v);
    }

    /**
     * @since agent v2.0_55-20210825
     */
    public static int getInt(String key, int def) {
        return def;
    }

    /**
     * @since agent v2.0_55-20210825
     */
    public static long getLong(String key, long def) {
        return def;
    }

    /**
     * @since agent v2.0_55-20210825
     */
    public static float getFloat(String key, float def) {
        return def;
    }

    /**
     * @since agent v2.0_55-20210825
     */
    public static void onModified(String id, Runnable r) {
    }
}
