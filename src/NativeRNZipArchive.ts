import type { TurboModule } from 'react-native/Libraries/TurboModule/RCTExport';
import { TurboModuleRegistry } from 'react-native';
import { Int32 } from 'react-native/Libraries/Types/CodegenTypes';

export interface Spec extends TurboModule {
    isPasswordProtected: (zipFilePath: string) => Promise<boolean>;
    unzipWithPassword: (zipFilePath: string, destDirectory: string, password: string) => Promise<string>;
    unzip: (zipFilePath: string, destDirectory: string, charset: string) => Promise<string>;
    unzipAssets: (assetsPath: string, destDirectory: string) => Promise<string>;
    zipFiles: (files: Readonly<Array<string>>, destDirectory: string) => Promise<string>;
    zipFolder: (folder: string, destFile: string) => Promise<string>;
    zipFilesWithPassword: (files: Readonly<Array<string>>, destFile: string, password: string, encryptionMethod: string) => Promise<string>;
    zipFolderWithPassword: (folder: string, destFile: string, password: string, encryptionMethod: string) => Promise<string>;
    addListener: (eventName: string) => void;
    removeListeners: (count?: Int32) => void;
}

export default (TurboModuleRegistry.get<Spec>('RNZipArchive')) as Spec;