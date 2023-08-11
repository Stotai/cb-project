package com.qianya.util;

import com.qianya.exception.CustomException;

public class CardGenerator {
    private static final long EPOCH = 1628438400000L; // 设置一个起始时间，如2021-08-09 00:00:00
    private static final int PRODUCT_ID_BITS = 10; // 商品ID所占的位数
    private static final int SEQUENCE_BITS = 6; // 序列号所占的位数
    private static final int MAX_PRODUCT_ID = (int) (Math.pow(2, PRODUCT_ID_BITS) - 1);
    private static final int MAX_SEQUENCE = (int) (Math.pow(2, SEQUENCE_BITS) - 1);

    private static int lastProductId = 0;
    private static int lastSequence = 0;
    private static long lastTimestamp = 0;

    public static synchronized String generateUniqueCard(Integer productId) {
        long timestamp = System.currentTimeMillis();
        if (timestamp < lastTimestamp) {
            throw new CustomException("生成id失败",true);
        }

        if (productId > MAX_PRODUCT_ID) {
            throw new CustomException("生成id失败",true);
        }

        if (productId != lastProductId) {
            lastProductId = productId;
            lastSequence = 0;
        } else {
            lastSequence = (lastSequence + 1) & MAX_SEQUENCE;
            if (lastSequence == 0) {
                // 当前毫秒的序列号已达到最大值，等待下一毫秒
                timestamp = tilNextMillis(lastTimestamp);
            }
        }

        lastTimestamp = timestamp;

        long id = ((timestamp - EPOCH) << (PRODUCT_ID_BITS + SEQUENCE_BITS))
                | (productId << SEQUENCE_BITS)
                | lastSequence;

        // 将ID转换为16进制字符串
        String card = String.format("%016X", id);
        return card;
    }

    private static long tilNextMillis(long lastTimestamp) {
        long timestamp = System.currentTimeMillis();
        while (timestamp <= lastTimestamp) {
            timestamp = System.currentTimeMillis();
        }
        return timestamp;
    }

}