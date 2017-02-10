package com.prt.criminalintent;

import java.util.UUID;

/**
 * Created by L.Pikalova on 2/10/2017.
 */

public class Crime {

    private UUID mId;
    private String mTitle;

    public Crime() {
        // generate unique identifier
        mId = UUID.randomUUID();
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }
}
