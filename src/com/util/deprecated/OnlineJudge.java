package com.util.deprecated;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.CLASS)
public @interface OnlineJudge {
	public static final OnlineJudgeInit onlineJudgeInit = new OnlineJudgeInit();
}
