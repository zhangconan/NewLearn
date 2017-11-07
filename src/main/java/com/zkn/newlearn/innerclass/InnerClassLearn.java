package com.zkn.newlearn.innerclass;

/**
 *
 * @author zkn
 * @date 2017/11/7
 */
public class InnerClassLearn {

    private InnerClassInvoker innerClassInvoker;

    /**
     * 执行内部类方法
     */
    public void invokerInnerClass() {
        innerClassInvoker.invoker(getInnerClass());
    }

    public InnerClassInter getInnerClass() {
        return new InnerClass();
    }

    private class InnerClass implements InnerClassInter {

        /**
         * 测试内部类
         */
        @Override
        public void inokerInnerClass() {
            System.out.println("调用内部类");
        }
    }

    public void setInnerClassInvoker(InnerClassInvoker innerClassInvoker) {
        this.innerClassInvoker = innerClassInvoker;
    }
}
