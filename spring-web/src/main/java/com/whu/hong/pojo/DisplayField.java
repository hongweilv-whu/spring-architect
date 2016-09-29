package com.whu.hong.pojo;

/**
 * Description:
 * Created by lvhw on 2016/9/23 6:56.
 */
public class DisplayField {
    private String objName;
    private String fieldId;
    private String aliasName;


    public String getObjName() {
        return objName;
    }

    public void setObjName(String objName) {
        this.objName = objName;
    }

    public String getFieldId() {
        return fieldId;
    }

    public void setFieldId(String fieldId) {
        this.fieldId = fieldId;
    }

    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }

    @Override
    public String toString() {
        return "DisplayField{" +
                "objName='" + objName + '\'' +
                ", fieldId='" + fieldId + '\'' +
                ", aliasName='" + aliasName + '\'' +
                '}';
    }
}
