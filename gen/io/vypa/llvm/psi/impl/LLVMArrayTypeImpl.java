// This is a generated file. Not intended for manual editing.
package io.vypa.llvm.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static io.vypa.llvm.psi.LLVMTypes.*;
import io.vypa.llvm.psi.*;

public class LLVMArrayTypeImpl extends LLVMTypeImpl implements LLVMArrayType {

  public LLVMArrayTypeImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull LLVMVisitor visitor) {
    visitor.visitArrayType(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LLVMVisitor) accept((LLVMVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public LLVMType getType() {
    return findChildByClass(LLVMType.class);
  }

  @Override
  @NotNull
  public PsiElement getIntergerLiteral() {
    return findNotNullChildByType(INTERGER_LITERAL);
  }

}
