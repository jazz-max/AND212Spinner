package com.example.and_212_spinner;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import androidx.annotation.IntDef;

@IntDef({Country.RUSSIA, Country.UKRAINE, Country.BELARUS})
@Retention(RetentionPolicy.SOURCE)
public @interface Country {
    int RUSSIA = 0;
    int UKRAINE = 1;
    int BELARUS = 2;
}