package org.stenio.docmanager.constants;

/**
 * Created by bjhexin3 on 2017/3/21.
 */
public enum FileItemType {

    Dir(1), File(0);

    private Integer value;

    FileItemType(int value){
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
