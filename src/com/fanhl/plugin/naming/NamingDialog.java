package com.fanhl.plugin.naming;

import com.intellij.ide.util.DefaultPsiElementCellRenderer;
import com.intellij.ide.util.PsiElementModuleRenderer;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.openapi.ui.LabeledComponent;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiField;
import com.intellij.ui.CollectionListModel;
import com.intellij.ui.ToolbarDecorator;
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
    private final LabeledComponent<JPanel> component;

    NamingDialog(PsiClass psiClass) {
        super(psiClass.getProject());
        setTitle("Select Fields to Rename");

        myFields = new CollectionListModel<>(psiClass.getAllFields());
        JBList<PsiField> fieldJBList = new JBList<>(myFields);
        fieldJBList.setCellRenderer(new DefaultPsiElementCellRenderer());
        ToolbarDecorator decorator = ToolbarDecorator.createDecorator(fieldJBList);
        decorator.disableAddAction();
        JPanel panel = decorator.createPanel();
        component = LabeledComponent.create(panel, "Select Fields to Rename.");

        init();
    }

    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        return component;
    }
}
