FCFS算法按照任务到达的顺序进行服务，先来先服务

每个Task对象可以描述为至少包含下列属性：
taskID //任务ID
arrivalTime //到达时间
serviceTime //服务时间
startingTime //开始时间
finishingTime //完成时间=开始时间+服务时间
turnAroundTime //周转时间=完成时间-达到时间
weightTurnAround //带权周转时间=周转时间/服务时间
其他的属性根据程序需要设置

任务(Task)的ID、开始时间和服务时间由文件读入，形如右图所示。这个任务列表文件首先由程序生成，每秒一个任务达到，服务时间由{6,2,1,3,9}这个集合中的数据随机获取。文件列表要包含至少100个任务。

先要求实现如下要求的FCFS
当只有一个处理队列时的情况
当有两个处理队列时的情况

SJF算法首先调度已到达的任务中，服务时间最短的任务，这里不要求实现任务的抢占。
按照FCFS算法的要求实现SJF算法，同样要求处理两种情况：
当只有一个处理队列时的情况
当有两个处理队列时的情况

![](https://github.com/summer1168/warehouse/raw/master/collectionClass/img/1.jpg)
![](https://github.com/summer1168/warehouse/raw/master/collectionClass/img/3.jpg)
![](https://github.com/summer1168/warehouse/raw/master/collectionClass/img/4.jpg)
![](https://github.com/summer1168/warehouse/raw/master/collectionClass/img/6.jpg)
![](https://github.com/summer1168/warehouse/raw/master/collectionClass/img/7.png)
![](https://github.com/summer1168/warehouse/raw/master/collectionClass/img/9.jpg)
![](https://github.com/summer1168/warehouse/raw/master/collectionClass/img/10.png)
![](https://github.com/summer1168/warehouse/raw/master/collectionClass/img/12.jpg)