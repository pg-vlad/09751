package com.skiteldev.myapplication;

import com.skiteldev.myapplication.helper.ValidateUtil;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidateUtilTest {

    @Test
    public void validate() {
        assertTrue(ValidateUtil.validate("3","2"));
        assertTrue(ValidateUtil.validate("vdv", "asd"));
        assertTrue(ValidateUtil.validate("v3dv", "a2sd"));
        assertFalse(ValidateUtil.validate("", "asa"));
        assertFalse(ValidateUtil.validate("", ""));
        assertFalse(ValidateUtil.validate("!", "asa"));
        assertFalse(ValidateUtil.validate("asc", "as!a"));
        assertFalse(ValidateUtil.validate("sas ","sa"));
    }
}