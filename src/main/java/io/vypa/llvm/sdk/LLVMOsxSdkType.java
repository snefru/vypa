package io.vypa.llvm.sdk;

import com.intellij.openapi.projectRoots.*;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import io.vypa.llvm.LLVMBundle;
import org.jdom.Element;
import org.jetbrains.annotations.Nullable;

import java.io.File;

public class LLVMOSXSdkType extends SdkType {

    public static final String ROOT_DIR = "/usr/local";
    private static final String DEAULT_NAME = "LLVMOSXSdk";
    //    private static final String PREFIX = "LLVM-";
//    private static final String SUFFIX = ".app";
//    private static final String LIBRARY = "Contents/Resources/LLVM/share/LLVM/base";
    private static final LLVMOSXSdkType INSTANCE = new LLVMOSXSdkType();


    public LLVMOSXSdkType() {
        this(DEAULT_NAME);
    }

    public LLVMOSXSdkType(String name) {
        super(name);
    }

    static LLVMOSXSdkType getInstance() {
        return INSTANCE;
    }

    @Nullable
    private static VirtualFile root(File file, final String relativePath) {
        file = new File(file.getAbsolutePath() + File.separator + relativePath.replace('/', File.separatorChar));
        if (!file.exists() || !file.isDirectory()) return null;
        final String path = file.getAbsolutePath().replace(File.separatorChar, '/');
        return LocalFileSystem.getInstance().findFileByPath(path);
    }

    @Nullable
    @Override
    public String suggestHomePath() {
        final File[] applications = new File(ROOT_DIR).listFiles();
        for (File application : applications) {
            if (application.getName().toLowerCase().contains("llvm"))
                return application.getAbsolutePath();
        }
        return ROOT_DIR;
    }

    @Override
    public boolean isValidSdkHome(String path) {
        return path.toLowerCase().contains("llvm");

    }

    @Override
    public String suggestSdkName(String currentSdkName, String sdkHome) {
        return LLVMBundle.message("sdk.name");

    }

    @Nullable
    @Override
    public AdditionalDataConfigurable createAdditionalDataConfigurable(SdkModel sdkModel, SdkModificator sdkModificator) {
        return null;
    }

    @Override
    public String getPresentableName() {
        return LLVMBundle.message("sdk.name");
    }

    @Override
    public void saveAdditionalData(SdkAdditionalData additionalData, Element additional) {

    }

    @Nullable
    @Override
    public String getVersionString(String sdkhome) {
        return "undefined";
    }

    @Override
    public void setupSdkPaths(Sdk sdk) {
        final String homePath = sdk.getHomePath();
        if (homePath == null)
            return;
        final File sdkHome = new File(homePath);
//        final VirtualFile classes = root(sdkHome, LIBRARY);
//        final VirtualFile sources = root(sdkHome, LIBRARY);
        final SdkModificator sdkModificator = sdk.getSdkModificator();
//        if (classes != null) {
//            sdkModificator.addRoot(classes, OrderRootType.CLASSES);
//        }
//        if (sources != null) {
//            sdkModificator.addRoot(sources, OrderRootType.SOURCES);
//        }
        sdkModificator.commitChanges();
    }
}
