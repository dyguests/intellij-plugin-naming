package com.fanhl.plugin.util;

import com.intellij.ui.components.JBList;

public class JBListUtils {
    public static <T> void makeItSelectAll(JBList<T> jbList) {
        int itemsCount = jbList.getItemsCount();
        int[] indices = new int[itemsCount];
        for (int i = 0; i < itemsCount; i++) {
            indices[i] = i;
        }
        jbList.setSelectedIndices(indices);
    }
}
