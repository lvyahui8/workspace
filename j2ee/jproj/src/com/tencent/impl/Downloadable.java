package com.tencent.impl;

/**
 * Author : samlv .
 * Date   : 2016/1/7 10:04.
 */
public interface Downloadable {
    /**
     * @return 下载URL
     */
    String getUrl();

    /**
     * @return 不包含路径的文件名
     */
    String getFileName();
}
