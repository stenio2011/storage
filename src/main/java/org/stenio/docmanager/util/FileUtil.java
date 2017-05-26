package org.stenio.docmanager.util;

import java.io.*;

/**
 * Created by bjhexin3 on 2017/3/21.
 */
public class FileUtil {

    public static String[] splitDirAndName(String path) {
        Assert.hasText(path, "path connot be empty");
        String[] strs = new String[2];
        int index = path.lastIndexOf("/");
        if (index < 0) {
            strs[0] = "/";
            strs[1] = path;
            return strs;
        }
        if (index == 0) {
            strs[0] = "/";
            strs[1] = path.substring(1);
            return strs;
        }

        strs[0] = path.substring(0, index);
        strs[1] = path.substring(index + 1);
        return strs;

    }

    public static String fixPath(String path) {
        Assert.hasText(path);
        if (!path.startsWith("/")) {
            path = "/" + path;
        }
        while (path.indexOf("//") >= 0) {
            path = path.replaceAll("//", "/");
        }
        if(path.endsWith("/") && path.length() > 1){
            path = path.substring(0, path.length() -1 );
        }
        return path;
    }

    public static void copyFile(File source, File target) {
        if(!target.exists()){
            target.mkdirs();
        }
        if(!target.isDirectory()){
            target.delete();
            target.mkdirs();
        }
        File targetFile = new File(target.getAbsolutePath() + "/" + source.getName());
        InputStream fis = null;
        OutputStream fos = null;
        try {
            fis = new BufferedInputStream(new FileInputStream(source));
            fos = new BufferedOutputStream(new FileOutputStream(targetFile));
            byte[] buf = new byte[4096];
            int i;
            while ((i = fis.read(buf)) != -1) {
                fos.write(buf, 0, i);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String getExt(String fileName) {
        if (StringUtil.isEmpty(fileName)) {
            return "";
        }
        int i = fileName.lastIndexOf(".");
        if (i >= 0) {
            return fileName.substring(i + 1);
        }
        return "";
    }


    public static void main(String[] args) {
        System.out.println(getExt(".abc"));
        System.out.println(getExt("xx.abc"));
        System.out.println(getExt("xx.x.abc"));
        System.out.println(getExt("xx"));
    }
}
