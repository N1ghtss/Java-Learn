### **Java语法基础**
1.1标识符  
标识符可以简单的理解成一个名字。在Java中，我们需要表示代码的很多元素，包括类名、方法、字段、变量、包名等等。我们选择的那个名称就称为标识符，一个正确的标识符需要遵循以下规则：  
1)标识符可以由字母、数字、下划线、$组成，但不能包含@、%、空格等其它特殊字符  
2)不能以数字开头，比如123abc就是不合法的  
3)标识符严格区分大小写，如name和Name是两个不同的标识符  
4)标识符的命名最好能反映其作用，做到见名知意  
5)标识符不能是Java的关键字  
1.2 关键字  
在Java中，有一些单词被赋予了特殊的意义，一共有50个关键字，这50个单词都是全小写，其中有两个保留字：const和goto，注意，关键字不能用作标识符  
1.3 注释
1)单行注释  
格式：//
2)多行注释  
格式：/* .... */
3)文档注释  
格式： //** .... */  
1.4 变量
在Java中，我们需要记录一些数据，但这些数据的值是不固定的，总在变，我们可以把这些数据理解为变量  
我们可以通过三个元素来描述变量： 变量类型 + 变量名 = 变量的值  
注意：1. 变量名必须是一个有效的标识符  
     2. 变量名不可以使用Java关键字  
     3. 变量名不能重复  
  

2.数据类型  
1 Byte = 8 Bits (1字节=8位)  
1 Kb = 1024 Bytes 1MB = 1024 KB 1GB = 1024 MB  
2.1基本数据类型  
1)整数型：byte(1)、short(2)、int(4)、long(8)
2)浮点型 ：float(4)、double(8)
3)布尔型：boolean(1)
4)字符型：char(2)  

