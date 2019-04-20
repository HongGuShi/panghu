package com.panghu.common.utils;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Map;

public final class ValidatorToolUtils {

    /**
     * Don't let anyone instantiate this class.
     */
    private ValidatorToolUtils() {
        //AssertionError不是必须的. 但它可以避免不小心在类的内部调用构造器. 保证该类在任何情况下都不会被实例化.
        //see 《Effective Java》 2nd
        throw new AssertionError("No " + getClass().getName() + " instances for you!");
    }

    /**
     * 判断对象 <code>value</code> 是不是 null或者empty.
     * <p>
     * <h3>示例:</h3>
     * <p>
     * <blockquote>
     * <p>
     * <pre class="code">
     * <p>
     * <span style="color:green">// null</span>
     * Validator.isNullOrEmpty(null)                                            = true
     * <p>
     * <span style="color:green">//CharSequence</span>
     * Validator.isNullOrEmpty("")                                              = true
     * Validator.isNullOrEmpty("   ")                                           = true
     * <p>
     * Validator.isNullOrEmpty(new StringBuffer())                              = true
     * Validator.isNullOrEmpty(new StringBuffer(""))                            = true
     * Validator.isNullOrEmpty(new StringBuffer(" "))                           = true
     * <p>
     * Validator.isNullOrEmpty(new StringBuilder())                             = true
     * Validator.isNullOrEmpty(new StringBuilder(""))                           = true
     * Validator.isNullOrEmpty(new StringBuilder(" "))                          = true
     * <p>
     * <span style="color:green">//Collection</span>
     * Validator.isNullOrEmpty(new ArrayList{@code <String>}())                 = true
     * <p>
     * <span style="color:green">//Map</span>
     * Validator.isNullOrEmpty(new LinkedHashMap{@code <String, String>}())     = true
     * <p>
     * <span style="color:green">//Iterator</span>
     * Validator.isNullOrEmpty(new ArrayList{@code <String>}().iterator())      = true
     * <p>
     * <span style="color:green">//Enumeration</span>
     * Validator.isNullOrEmpty(toEnumeration(new ArrayList{@code <String>}()))  = true
     * <p>
     * <span style="color:green">//Array</span>
     * Validator.isNullOrEmpty(new String[] {})                                 = true
     * Validator.isNullOrEmpty(new Integer[][] {})                              = true
     * Validator.isNullOrEmpty(new User[] {})                                   = true
     * <p>
     * <span style="color:green">//Primitive Array</span>
     * Validator.isNullOrEmpty(new double[] {})                                 = true
     * Validator.isNullOrEmpty(new float[] {})                                  = true
     * Validator.isNullOrEmpty(new long[] {})                                   = true
     * Validator.isNullOrEmpty(new int[] {})                                    = true
     * Validator.isNullOrEmpty(new short[] {})                                  = true
     * Validator.isNullOrEmpty(new char[] {})                                   = true
     * Validator.isNullOrEmpty(new byte[] {})                                   = true
     * Validator.isNullOrEmpty(new boolean[] {})                                = true
     * </pre>
     * <p>
     * </blockquote>
     * <p>
     * <h3>对于empty的判断,使用以下逻辑:</h3>
     * <p>
     * <blockquote>
     * <ol>
     * <li>{@link CharSequence},支持子类有 {@link String},{@link StringBuffer},{@link StringBuilder},使用
     * {@link org.apache.commons.lang3.StringUtils#isBlank(CharSequence)};</li>
     * <li>{@link Collection},使用其 {@link Collection#isEmpty()};</li>
     * <li>{@link Enumeration},使用 {@link Enumeration#hasMoreElements()};</li>
     *
     * @return 如果是null, 返回true<br>
     * 如果是empty也返回true<br>
     * 其他情况返回false<br>
     * @see org.apache.commons.lang3.StringUtils#isBlank(CharSequence)
     */
    public static boolean isNullOrEmpty(Object value) {
        if (null == value) {
            return true;
        }
        //字符串
        if (value instanceof CharSequence) {
            return StringUtils.isBlank((CharSequence) value);
        }
        // collections 支持的类型
        if (isCollectionsSupportType(value)) {
            return CollectionUtils.sizeIsEmpty(value);
        }
        return false;
    }

    /**
     * <p>
     * </p>
     * <p>
     * <h3>对于empty的判断,使用以下逻辑:</h3>
     * <p>
     * <blockquote>
     * <ol>
     * <li>{@link CharSequence},支持子类有 {@link String},{@link StringBuffer},{@link StringBuilder},使用
     * {@link org.apache.commons.lang3.StringUtils#isBlank(CharSequence)};</li>
     * <li>{@link Collection},使用其 {@link Collection#isEmpty()};</li>
     * <li>{@link Enumeration},使用 {@link Enumeration#hasMoreElements()};</li>
     */
    public static boolean isNotNullOrEmpty(Object value) {
        return !ValidatorToolUtils.isNullOrEmpty(value);
    }

    /**
     * Checks if is collections support type.
     *
     * @param value the value
     * @return true, if checks if is collections support type
     * @since 1.5.2
     */
    private static boolean isCollectionsSupportType(Object value) {
        //集合或者map
        boolean isCollectionOrMap = value instanceof Collection || value instanceof Map;
        // 枚举 或者是 Iterator迭代器
        boolean isEnumerationOrIterator = value instanceof Enumeration || value instanceof Iterable;
        return isCollectionOrMap || isEnumerationOrIterator || value.getClass().isArray();
    }


}
