实验一 基本IO操作

从键盘接收字节流
![](https://github.com/summer1168/warehouse/raw/master/lab5/img/1.png)
写入到当前目录下的src.txt文件中
![](https://github.com/summer1168/warehouse/raw/master/lab5/img/2.png)
将src.txt文件内容复制到当前目录下dest.txt文件中
![](https://github.com/summer1168/warehouse/raw/master/lab5/img/5.png)
![](https://github.com/summer1168/warehouse/raw/master/lab5/img/3.png)
![](https://github.com/summer1168/warehouse/raw/master/lab5/img/4.png)
将dest.txt文件内容显示到屏幕上
![](https://github.com/summer1168/warehouse/raw/master/lab5/img/6.png)

实验二 获取系统的文件树

获取某个目录下的目录信息，目录从控制台输入。
![](https://github.com/summer1168/warehouse/raw/master/lab5/img/7.png)
![](https://github.com/summer1168/warehouse/raw/master/lab5/img/8.png)
目录信息包括该目录下的所有文件和文件夹的列表。对于每个文件夹显示其名称，修改日期。对于每个文件显示其名称，修改日期和大小。
![](https://github.com/summer1168/warehouse/raw/master/lab5/img/9.png)
![](https://github.com/summer1168/warehouse/raw/master/lab5/img/10.png)

实验三 带缓冲区的IO

用带缓冲和不带缓冲的字符流实现文件复制，并比较耗时情况。
![](https://github.com/summer1168/warehouse/raw/master/lab5/img/10.jpg)
![](https://github.com/summer1168/warehouse/raw/master/lab5/img/11.jpg)

实验四 对象序列化

类Student表示学生，属性包括{studentID, name, sex} (学号，姓名，性别)，使用序列化技术定义Student。学生信息从文件list.txt读入，并按照学号升序排列。注意，这里姓名和性别可以组织成String类型，而学号可以是String也可以是Long。

使用ObjectOutputStream将已经排序的学生信息写出到文件“student.bin”中。

使用ObjectInputStream将“student.bin”中的对象信息读入程序，显示在控制台中。
![](https://github.com/summer1168/warehouse/raw/master/lab5/img/12.jpg)
![](https://github.com/summer1168/warehouse/raw/master/lab5/img/13.jpg)
![](https://github.com/summer1168/warehouse/raw/master/lab5/img/14.jpg)
![](https://github.com/summer1168/warehouse/raw/master/lab5/img/15.jpg)
![](https://github.com/summer1168/warehouse/raw/master/lab5/img/16.jpg)



