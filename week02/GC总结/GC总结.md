GC总结

## 串行GC（Serial GC）：

1.堆内存越大，执行youngGC和fullGC的次数越少

2.单次youngGC和fullGC的时间随着内存的增大而增大

3.在堆内存为1g时，生成的对象最多



## 并行GC（Parallel GC）：

1.堆内存越大，执行的youngGC和fullGC的次数越少，

2.单次youngGc和FullGC的时间会随着内存的增大而增大

3.在堆内存越大,生成的对象更多

4.采用并行GC比串行GC每次GC的时间更少



## CMSGC

1.堆内存越大，执行youngGC和fullGC的次数越少

2.单次youngGC和fullGC的时间随着内存的增大而增大

3.在堆内存为越大，生成对象越多

## G1GC

1.堆内存越大，越适合用G1GC

2.在堆内存为越大，生成对象越多

## 如何选择正确的GC

如果考虑系统吞吐优先，CPU资源都用来最大程度处理业务，用并行GC（Parallel GC）

如果考虑低延迟有限，每次使用GC时间尽量短的话，用CMS GC

如果系统内存大的话，同时希望整体的GC平均时间可控，使用G1 GC

一般4G内存以上的话，用G1的性价比高

如果超过8G，非常推荐使用G1 GC 