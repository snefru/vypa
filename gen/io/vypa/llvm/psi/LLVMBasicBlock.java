// This is a generated file. Not intended for manual editing.
package io.vypa.llvm.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface LLVMBasicBlock extends PsiElement {

  @NotNull
  List<LLVMStatement> getStatementList();

  @Nullable
  PsiElement getLabelId();

}
