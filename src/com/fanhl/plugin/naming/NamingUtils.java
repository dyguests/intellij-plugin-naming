package com.fanhl.plugin.naming;

import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

/**
 * 命名工具
 */
class NamingUtils {

    @NonNls
    @NotNull
    static String toUpperCase(String string) {
        return string != null ? string.toUpperCase() : "";
    }
}
