### 原子操作
这里所指的原子操作是指不会被线程调度机制打断的操作，一个操作一旦开始，就一直运行到结束，中间不会有任何ContentSwitch(线程上下文切换)。

### 分布式锁
分布式应用中的锁。单体应用可以使用synchronize或者lock去实现，分布式应用中可以使用Redis、Zookeeper等方式实现。


