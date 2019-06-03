package com.shape.singleproject.util;

import com.google.common.collect.Sets;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Random;
import java.util.Set;

public class RandomUtil {
    private static Random random = new Random();

    /**
     * 随机从IdList中抽取指定数量的id值
     * @param ids
     * @param size
     * @return
     */
    public static Set<Integer> getUniqueIdSetByList(List<Integer> ids, int size) {
        Set<Integer> uniqueIds = Sets.newHashSet();
        if (CollectionUtils.isEmpty(ids) || size == 0) {
            return uniqueIds;
        }
        while (uniqueIds.size() < size) {
            int index = random.nextInt(ids.size());
            uniqueIds.add(ids.get(index));
        }
        return uniqueIds;
    }

    /**
     * 随机从IdList中抽取指定数量的id值
     * @param ids
     * @param size
     * @return
     */
    public static Set<Long> getUniqueIdSetByListWithLong(List<Long> ids, int size) {
        Set<Long> uniqueIds = Sets.newHashSet();
        if (CollectionUtils.isEmpty(ids) || size == 0) {
            return uniqueIds;
        }
        while (uniqueIds.size() < size) {
            int index = random.nextInt(ids.size());
            uniqueIds.add(ids.get(index));
        }
        return uniqueIds;
    }
}
