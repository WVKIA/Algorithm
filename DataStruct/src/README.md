#### 表的实现

#### 1. 动态数组实现

#### 2. 单链表实现

#### 3. 双链表实现

#### 栈的实现

#### 1. 动态数组实现

#### 2. 单链表实现

单链表实现有两种

1。 一种是以head作为头节点的普通单链表，每一次添加节点都加入到末尾节点，但从始至终head节点位置始终保持不变，始终位于链表头节点；
这样做的优点：是理解简单，容易代码实现，和普通单链表实现没有什么两样，但缺点也很明显，就是每一次push或pop操作，都需要找到最末尾节点，也就是
每一次都要进行一次全表遍历，用图例展示：
```
head.next -> null

push();

head.next-> one
head.next -> one.next -> two

pop();

head.next -> one.next

```

2。另一种使用单链表的形式就是head节点始终指向栈顶元素节点，但next指针指向相反，可以用图例展示：

```
head.next -> null;

push();

head.next-> one;
one.next-> null;

head.next-> two
two.next -> one

head.next-three
three.next -> two.next -> one


pop();

head.next-> two
two.next -> one
```
也就是将指针反向指向，这样做只要一个单链表就可以实现栈
