package org.stenio.docmanager.util;

import org.junit.*;


import static org.junit.Assert.*;

/**
 * Created by bjhexin3 on 2017/3/21.
 */
public class FileUtilTest {
    @Test
    public void splitDirAndName() throws Exception {
        String[] strs1 = FileUtil.splitDirAndName("abc");
        assertEquals("/", strs1[0]);
        assertEquals("abc", strs1[1]);
        String[] strs2 = FileUtil.splitDirAndName("/abc");
        assertEquals("/", strs2[0]);
        assertEquals("abc", strs2[1]);
        String[] strs3 = FileUtil.splitDirAndName("/abc/def");
        assertEquals("/abc", strs3[0]);
        assertEquals("def", strs3[1]);
    }

    @Test
    public void fixPath() {
        String path1 = FileUtil.fixPath("abc/def");
        assertEquals("/abc/def", path1);
        String path2 = FileUtil.fixPath("abc//def");
        assertEquals("/abc/def", path2);
    }

}