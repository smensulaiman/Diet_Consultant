package com.diu.finalproject.dietplan.UserModel;

import android.database.Cursor;

public class UserItem {
    boolean validate;
    Cursor cs;

    public UserItem() {
    }

    public UserItem(boolean validate, Cursor cs) {
        this.validate = validate;
        this.cs = cs;
    }

    public boolean isValidate() {
        return validate;
    }

    public void setValidate(boolean validate) {
        this.validate = validate;
    }

    public Cursor getCs() {
        return cs;
    }

    public void setCs(Cursor cs) {
        this.cs = cs;
    }
}
