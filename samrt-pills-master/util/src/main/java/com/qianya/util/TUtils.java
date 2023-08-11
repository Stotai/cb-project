package com.qianya.util;

import com.qianya.exception.CustomException;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TUtils {
    public static ThreadPoolExecutor threadPoolExecutor;

    public TUtils() {
        throw new CustomException("This is a utility class and cannot be instantiated");
    }

    public static boolean isEmpty(Object object) {
        if (object instanceof String) {
            return "".equals(object.toString().trim());
        } else {
            return object == null;
        }
    }

    public static boolean isNotEmpty(Object object) {
        return !isEmpty(object);
    }

    static {
        threadPoolExecutor = new ThreadPoolExecutor(3, Runtime.getRuntime().availableProcessors() * 2, 10L, TimeUnit.MINUTES, new LinkedBlockingQueue(30), Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());
    }
}