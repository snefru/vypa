// This is a generated file. Not intended for manual editing.
package io.vypa.llvm.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface LLVMOperandBundle extends PsiElement {

  @NotNull
  List<LLVMTypedValue> getTypedValueList();

  @NotNull
  PsiElement getString();

}
