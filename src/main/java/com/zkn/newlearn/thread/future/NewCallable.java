package com.zkn.newlearn.thread.future;

/**
 * Created by wb-zhangkenan on 2017/5/5.
 *
 * @author wb-zhangkenan
 * @date 2017/05/05
 */
public interface NewCallable<V> {
    /**
     * 回调接口
     * @return
     */
    V call();
}
