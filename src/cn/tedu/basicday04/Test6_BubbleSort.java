package cn.tedu.basicday04;

import java.util.Arrays;

public class Test6_BubbleSort {
    public static void main(String[] args) {
        int[] a={27,96,73,25,21};
        for (int i = 1; i <a.length ; i++) {
            for (int j = 0; j < a.length-1; j++) {
                if (a[j]>a[j+1]){
                    int temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
            System.out.println(Arrays.toString(a));
        }
    }
}
//Java日志7.14
/*今天是开始实习的第三天，今天早上的每日一讲环节的同学很有感染力，感觉性格很开朗，同时也调动了课堂的气氛。
    在今天的课上公子哥给我们讲述了For循环的结构，还有在循环体内使用Break和Continue的区别，并且做了相应的练习，让我们对for循环结构更熟练了。同时也给我们讲了一些Java中关于方法的一些知识，比如方法的重载和重写。
    下午则是从数组开始讲起，让我们了解了数组可以静态初始化也可以动态初始化，然后就讲到了关于数组的遍历还有计算机科学领域的较简单的排序算法——冒泡排序，让我们了解了关于算法的一些知识。最后讲到了构造方法还有变量，
    懂得了变量可以分为局部变量和成员变量，了解这些可以让我们以后编程的时候能够更好的去编写代码。
*
*
*  */
