# 线性表栈的顺序存储结构实现
```
public class Stack<E> extends Vector<E> {
    public Stack() {
    }

    public synchronized E push(E item) {
        add(item);
        return item;
    }

    public synchronized E pop() {
        E cobj = peek();
        remove(size() - 1);
        return cobj;
    }

    public synchronized boolean empty() {
        return isEmpty();
    }
    public synchronized E peek() {
        int len = size();
        if (len <= 0) {
            throw new EmptyStackException();
        }
        return (E) elementData[len - 1];
    }
}

```
## 
```
Stack<String> activitys = new Stack<>();
activitys.push("activity1");
activitys.push("activity2");
activitys.push("activity3");
activitys.push("activity4");
System.out.println(Arrays.toString(activitys.toArray()));
System.out.println("------------pop------------");
String pop = activitys.pop();
System.out.println("pop:" + pop);
System.out.println("----------pop after--------");
System.out.println(Arrays.toString(activitys.toArray()));
System.out.println("-----------push------------");
activitys.push("activity5");
activitys.push("activity6");
activitys.push("activity7");
activitys.push("activity8");
System.out.println(Arrays.toString(activitys.toArray()));
```
## 测试结果
```
[activity1, activity2, activity3, activity4]
------------pop------------
pop:activity4
----------pop after--------
[activity1, activity2, activity3]
-----------push------------
[activity1, activity2, activity3, activity5, activity6, activity7, activity8]
```
# 使用栈结构处理逆波兰表示法