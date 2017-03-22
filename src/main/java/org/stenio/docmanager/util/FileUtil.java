package org.stenio.docmanager.util;

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
        return path;
    }


}
