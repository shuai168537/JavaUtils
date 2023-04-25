package com.personal.util.component;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import org.springframework.stereotype.Component;

/**
 * dozer 转换器
 *
 * @author yuanss
 */
@Component
public class DozerConvertor {

    //持有Dozer单例, 避免重复创建DozerMapper消耗资源.
    public static final Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    /**
     * List  实体类 转换器
     *
     * @param source 原数据
     * @param clz    转换类型
     * @param <T>    返回类型
     * @param <S>    传入类型
     */
    public <T, S> List<T> convertor(List<S> source, Class<T> clz) {
        if (source == null) {
            return null;
        }
        List<T> map = new ArrayList<>();
        for (S s : source) {
            map.add(mapper.map(s, clz));
        }
        return map;
    }

    /**
     * Set 实体类 深度转换器
     *
     * @param source 原数据
     * @param clz    目标对象
     * @param <T>    返回类型
     * @param <S>    传入类型
     */
    public <T, S> Set<T> convertor(Set<S> source, Class<T> clz) {
        if (source == null) {
            return null;
        }
        Set<T> set = new TreeSet<>();
        for (S s : source) {
            set.add(mapper.map(s, clz));
        }
        return set;
    }

    /**
     * 实体类 深度转换器
     *
     * @param source 原数据
     * @param clz    目标对象
     * @param <T>    返回类型
     * @param <S>    传入类型
     */
    public <T, S> T convertor(S source, Class<T> clz) {
        if (source == null) {
            return null;
        }
        return mapper.map(source, clz);
    }

    public void convertor(Object source, Object object) {
        mapper.map(source, object);
    }

    public <T> void copyConvertor(T source, Object object) {
        mapper.map(source, object);
    }

}
