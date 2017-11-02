package com.fanhl.plugin.naming;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.LangDataKeys;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiField;
import com.intellij.psi.PsiFile;
import com.intellij.psi.util.PsiTreeUtil;

import java.util.List;

/**
 * 命名Action
 * <p>
 * date: 2017/11/01
 *
 * @author fanhl
 */
public class NamingAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        PsiClass psiClass = getPsiClass(e);
        NamingDialog dialog = new NamingDialog(psiClass);

        //这步是挂起的
        dialog.show();

        if (dialog.isOK()) {
            performNaming(psiClass, dialog.getSelectedFields());
        }
    }

    @Override
    public void update(AnActionEvent e) {
        super.update(e);
        e.getPresentation().setEnabled(getPsiClass(e) != null);
    }

    /**
     * 获取action所在的class
     *
     * @param e e
     * @return action所在的class
     */
    private PsiClass getPsiClass(AnActionEvent e) {
        PsiFile psiFile = e.getData(LangDataKeys.PSI_FILE);
        Editor editor = e.getData(PlatformDataKeys.EDITOR);
        if (psiFile == null || editor == null) {
            return null;
        }
        int offset = editor.getCaretModel().getOffset();
        PsiElement elementAtOffset = psiFile.findElementAt(offset);
        return PsiTreeUtil.getParentOfType(elementAtOffset, PsiClass.class);
    }

    private void performNaming(PsiClass psiClass, List<PsiField> fields) {

    }
}
