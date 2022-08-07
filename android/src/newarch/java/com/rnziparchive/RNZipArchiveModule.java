package com.rnziparchive;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;


public class RNZipArchiveModule extends NativeRNZipArchiveSpec {
  private RNZipArchiveModuleImpl moduleImpl;

  public RNZipArchiveModule(ReactApplicationContext reactContext) {
    super(reactContext);
    moduleImpl = new RNZipArchiveModuleImpl(reactContext);
  }

  @Override
  public String getName() {
    return RNZipArchiveModuleImpl.NAME;
  }

  @Override
  public void isPasswordProtected(final String zipFilePath, final Promise promise) {
    moduleImpl.isPasswordProtected(zipFilePath,promise);
  }

  @Override
  public void unzipWithPassword(final String zipFilePath, final String destDirectory,
        final String password, final Promise promise) {
    moduleImpl.unzipWithPassword(zipFilePath,destDirectory,password,promise);
  }

  @Override
  public void unzip(final String zipFilePath, final String destDirectory, final String charset, final Promise promise) {
    moduleImpl.unzip(zipFilePath,destDirectory,charset,promise);
  }

  /**
   * Extract a zip held in the assets directory.
   * <p>
   * Note that the progress value isn't as accurate as when unzipping
   * from a file. When reading a zip from a stream, we can't
   * get accurate uncompressed sizes for files (ZipEntry#getCompressedSize() returns -1).
   * <p>
   * Instead, we compare the number of bytes extracted to the size of the compressed zip file.
   * In most cases this means the progress 'stays on' 100% for a little bit (compressedSize < uncompressed size)
   */
  @Override
  public void unzipAssets(final String assetsPath, final String destDirectory, final Promise promise) {
    moduleImpl.unzipAssets(assetsPath,destDirectory,promise);
  }

  @Override
  public void zipFiles(final ReadableArray files, final String destDirectory, final Promise promise) {
    moduleImpl.zipFiles(files,destDirectory,promise);
  }

  @Override
  public void zipFolder(final String folder, final String destFile, final Promise promise) {
    moduleImpl.zipFolder(folder,destFile,promise);
  }

  @Override
  public void zipFilesWithPassword(final ReadableArray files, final String destFile, final String password,
                              String encryptionMethod, Promise promise) {
   moduleImpl.zipFilesWithPassword(files,destFile,password,encryptionMethod,promise);
  }


  @Override
  public void zipFolderWithPassword(final String folder, final String destFile, final String password,
                                   String encryptionMethod, Promise promise) {
    moduleImpl.zipFolderWithPassword(folder,destFile,password,encryptionMethod,promise);
  }

  @Override
  public void addListener(String eventName) {
    // Keep: Required for RN built in Event Emitter Calls.
  }

  @Override
  public void removeListeners(Double count) {
    // Keep: Required for RN built in Event Emitter Calls.
  }
}
