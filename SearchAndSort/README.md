### 排序

#### 选择排序

<iframe height=500 width=500 src="./ref/selectsortgif.gif">

原理：先找到元素中最小的，然后插入到最前面，然后从剩下的为排序的数据中找到次级小的，插入到已排序后面；通过交换位置实现插入
按照上述顺序，第一次排序后，最小的被移动到最开始，然后从第二个开始，继续上述过程

#### 冒泡排序

原理：重复走过要访问的数据，然后比较相邻的两个元素，如果元素顺序错误就进行位置交换，那么第一次访问后，肯定是最大的被移动到末尾；
然后需要访问的数据减少到倒数第二个，重复上次过程，最终实现所有到数据都得到排序

<iframe height=500 width=500 src="./ref/bubblesortgif.gif">


#### 插入排序

原理：从未排序的数据中拿出数据，然后插入到已经排序的对应的位置

1. 首先认为第一个数据是已经有序的
2. 取出下一个数据，插入到前面已经排好序对应的位置
3. 之前该位置的数据全部后移一位，正好覆盖掉取出的数据位置
4. 重复上述过程
 
<iframe height=500 width=500 src="./ref/insertsortgif.gif">


#### 归并排序

原理：采用分治法，先将数据序列分割成若干子序列，然后分别进行归并排序，最后将子序列合并成有序序列

采用二路归并，也就是先将序列拆成两个子序列，分别归并排序之后，再进行合并


<iframe height=500 width=500 src="./ref/mergesortgif.gif">


#### 快速排序

原理：同样采用分治法，从序列中选择一个基准，比基准大的放右边，比基准小的放左边，一次排序过后，基准就处于中间位置，这个就是分区操作；
然后对基准两边的子序列再采用递归快速排序

<iframe height=500 width=500 src="./ref/quicksortgif.gif">
