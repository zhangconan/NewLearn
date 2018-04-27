package com.zkn.newlearn.jvm.depth_analysis_jvm.third.gc;

/**
 * GC参数的整理：
 * <p>
 * -XX:+UseSerialGC：在新生代和老年代使用串行收集器
 * <p>
 * -XX:SurvivorRatio：设置eden区大小和survivior区大小的比例
 * <p>
 * -XX:NewRatio:新生代和老年代的比
 * <p>
 * -XX:+UseParNewGC：在新生代使用并行收集器
 * <p>
 * -XX:+UseParallelGC ：新生代使用并行回收收集器
 * <p>
 * -XX:+UseParallelOldGC：老年代使用并行回收收集器
 * <p>
 * -XX:ParallelGCThreads：设置用于垃圾回收的线程数
 * <p>
 * -XX:+UseConcMarkSweepGC：新生代使用并行收集器，老年代使用CMS+串行收集器
 * <p>
 * -XX:ParallelCMSThreads：设定CMS的线程数量
 * <p>
 * -XX:CMSInitiatingOccupancyFraction：设置CMS收集器在老年代空间被使用多少后触发
 * <p>
 * -XX:+UseCMSCompactAtFullCollection：设置CMS收集器在完成垃圾收集后是否要进行一次内存碎片的整理
 * <p>
 * -XX:CMSFullGCsBeforeCompaction：设定进行多少次CMS垃圾回收后，进行一次内存压缩
 * <p>
 * -XX:+CMSClassUnloadingEnabled：允许对类元数据进行回收
 * <p>
 * -XX:CMSInitiatingPermOccupancyFraction：当永久区占用率达到这一百分比时，启动CMS回收
 * <p>
 * -XX:UseCMSInitiatingOccupancyOnly：表示只在到达阀值的时候，才进行CMS回收
 * <p>
 * GC日志参数：
 * -XX:+PrintGC 输出GC日志
 * <p>
 * -XX:+PrintGCDetails 输出GC的详细日志
 * <p>
 * -XX:+PrintGCTimeStamps 输出GC的时间戳（以基准时间的形式）
 * <p>
 * -XX:+PrintGCDateStamps 输出GC的时间戳（以日期的形式，如 2013-05-04T21:53:59.234+0800）
 * <p>
 * -XX:+PrintHeapAtGC 在进行GC的前后打印出堆的信息
 * <p>
 * -XX:+PrintGCApplicationStoppedTime // 输出GC造成应用暂停的时间
 * <p>
 * -Xloggc:../logs/gc.log 日志文件的输出路径
 * <p>
 * 参考：
 * https://blog.csdn.net/doc_sgl/article/details/46594123
 *
 * @author zkn
 * @date 2018/4/26
 */
public class ReferenceCountingLearn {

    public Object instance = null;

    private static final int ARRAY_SIZE = 1024 * 1024;

    /**
     *
     */
    private byte[] bigSize = new byte[2 * ARRAY_SIZE];

    /**
     * Serial 收集器中新生代名为 “Default New Generation”，显示的名字为 “[DefNew”。
     * 对于ParNew收集器，显示的是 “[ParNew”，表示 “Parallel New Generation”。
     * 对于 Parallel Scavenge 收集器，新生代名为 “PSYoungGen”。
     */
    public static void testGC() {
        ReferenceCountingLearn objA = new ReferenceCountingLearn();
        ReferenceCountingLearn objB = new ReferenceCountingLearn();
        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;
        //测试这里能否回收objA 和 objB
        System.gc();
    }

    public static void main(String[] args) {
        testGC();
    }
}
