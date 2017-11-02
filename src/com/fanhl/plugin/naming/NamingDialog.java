package com.fanhl.plugin.naming;

import com.fanhl.plugin.util.JBListUtils;
import com.intellij.ide.util.DefaultPsiElementCellRenderer;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.openapi.ui.LabeledComponent;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiField;
import com.intellij.ui.CollectionListModel;
import com.intellij.ui.ToolbarDecorator;
import com.intellij.ui.components.JBList;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.List;

/**
 * 重命名的对话框
 *
 * @author fanhl
 */
public class NamingDialog extends DialogWrapper {
    private final LabeledComponent<JPanel> component;
    private final JBList<PsiField> fieldJBList;

    NamingDialog(PsiClass psiClass) {
        super(psiClass.getProject());
        setTitle("Select Fields to Rename");

        CollectionListModel<PsiField> myFields = new CollectionListModel<>(psiClass.getAllFields());
        fieldJBList = new JBList<>(myFields);
        fieldJBList.setCellRenderer(new DefaultPsiElementCellRenderer());
//        JBListUtils.makeItSelectAll(fieldJBList);
        ToolbarDecorator decorator = ToolbarDecorator.createDecorator(fieldJBList);
        decorator.disableAddAction();
        decorator.disableRemoveAction();
        decorator.disableUpDownActions();
        JPanel panel = decorator.createPanel();
        component = LabeledComponent.create(panel, "Select Fields");

        init();
    }

    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        return component;
    }

    @Override
    protected void dispose() {
        super.dispose();

    }

    List<PsiField> getSelectedFields() {
        return fieldJBList.getSelectedValuesList();
    }
}
