package com.fanhl.plugin.naming;

import com.intellij.ide.util.DefaultPsiElementCellRenderer;
import com.intellij.ide.util.PsiElementModuleRenderer;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiField;
import com.intellij.ui.CollectionListModel;
import com.intellij.ui.components.JBList;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * 重命名的对话框
 *
 * @author fanhl
 */
public class NamingDialog extends DialogWrapper {

    private final CollectionListModel<PsiField> myFields;

    NamingDialog(PsiClass psiClass) {
        super(psiClass.getProject());
        setTitle("Select Fields to Rename");
        myFields = new CollectionListModel<>(psiClass.getAllFields());
        JBList<PsiField> fieldJBList = new JBList<>(myFields);
        fieldJBList.setCellRenderer(new PsiElementModuleRenderer());
    }

    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        return null;
    }
}
