package com.whu.hong.pojo;

/**
 * Description:
 * Created by lvhw on 2016/9/23 6:54.
 */
public class Filter {
    private String fieldId;
    private String dbObjName;
    private int operator;
    private String value;

    public String getFieldId() {
        return fieldId;
    }

    public void setFieldId(String fieldId) {
        this.fieldId = fieldId;
    }

    public String getDbObjName() {
        return dbObjName;
    }

    public void setDbObjName(String dbObjName) {
        this.dbObjName = dbObjName;
    }

    public int getOperator() {
        return operator;
    }

    public void setOperator(int operator) {
        this.operator = operator;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Filter{" +
                "fieldId='" + fieldId + '\'' +
                ", dbObjName='" + dbObjName + '\'' +
                ", operator=" + operator +
                ", value='" + value + '\'' +
                '}';
    }
}
