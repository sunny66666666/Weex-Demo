Weex

Weex is a extendable cross-platform solution for dynamic programming and publishing projects.
    Weex是针对动态编程和发布项目的一个可扩展、跨平台的解决方案。

这是来自Weex Document的介绍。这句话个人感觉还是非常有诱惑力的。为什么？击中移动端开发两个痛点。

    动态编程＋发布。Weex能做到随时编程发布到服务端，应用端即时更新。想想以前，应用开发－测试－发布，多么繁琐和耗时的一个流程，万一线上出了bug，那真是痛不欲生，尤其时用户量上百万千万的应用，老板连杀你的心都有。但是有了Weex就不一样了。修复bug，用户都是无感知的。
    跨平台。这是移动端无数人向往的和为之努力的事。一处编写，到处运行。Weex支持Android，iOS，Web三大平台，一份代码，三个平台通用。等到有一天，Weex真的发展强大起来，公司成本估计可以节省不少。
    
    以上是一些官方的weex的介绍，个人在研究weex时发现以下优势：
    1；及时更新，很方便
    2：js应该是有什么缓存机制，第一次下载图片加载页面后，以后打开速度很快，不需要重新加载，和原生一样的体验
    3:相比较之前的mui  bootstrap的页面跳转，（也有可能我之前技术有限，方法没写好），这个跳转很流畅，和原生一毛一样的
    4：组件化：例如nav，样式大同小异，数据只需在相应的页面配置，走哪，用哪，很方便。
    至于官方说的跨平台，一份代码，三个平台通用，个人觉得，要实现真正的跨品台，与其说weex很强大，不如说用weex开发实现跨平台的人很强大，
    如果一个开发人员对前端  Android ios 都比较通，那weex确实是一个可以跨平台的神器。。，个人觉得，只了解一方面的技术，要很好的发挥weex的功能有难度
    以下是开发过程中的一些个人经验：

1:命名文件名的 时候，不要以text.we命名，不然会出现 text不停的循环的情况
就是你weex文件里用的组件名不要跟文件名同名 就好了~

2:通过设置 if 特性值，你可以控制当前组件是否显示。如果值为真，则当前组件会被渲染出来，如果值为假则会被移除

3:<image> 组件用于渲染图片，并且它不能包含任何子组件。可以用 <img> 作简写。

需要注意的是，需要明确指定 width 和 height，否则图片无法显示。

<image> 组件不支持任何子组件，因此不要尝试在 <image> 组件中添加任何组件。如果需要实现 background-image 的效果，可以使用 <image> 组件和 position 定位来现实，如下面代码。

还有，目前项目里的图片路径均来自与 网络路径  本地路径如何加载 文档中还没有发现（等待更新）

4:根节点：每个 Weex 页面最顶层的节点，我们称为根节点。下面是目前我们支持的三种根节点：

    <div>：普通根节点，有确定的尺寸，不可滚动。
    <scroller>：可滚动根节点，适用于需要全页滚动的场景。
    <list>：列表根节点，适用于其中包含重复的子元素的列表场景。

目前 Weex 仅支持以上三种根节点。

注意事项：<template> 只支持一个根节点，多个根节点将无法被 Weex 正常的识别和处理。

5:a链接不能跳转外网以外的链接页面（第二遍进行 a链接测试时，a链接又不能正常跳转  坑！！！）

6：switch使用官方提供的demo 和自己本地运行出来的效果不一样 

7：input标签被 手机弹出来的  键盘输入框遮挡（我觉得这个还真是个问题）

8：stream用来实现网络请求  类似ajax(存在的问题是 ，目前在playground中扫码可以正常获取 ，使用github demo 也可以正常获取 ，但是在我自己集成的 项目中无法获取 ，问题已经定位在 原生代码中。)

9:storage:存储功能（待测试）

10：picker的demo也是不能使用的 官方提供的demo里提示
   WARN ./WE/WeexPickerDemo.we : WARNING: `font-color` is not a standard property n
ame 

11：编译weex.we为weex.js生成到 D:\nodejs\node_modules\weex_tmp\h5_render文件夹后 ，需要生成一个 就保存一个  不然会被下一个覆盖掉

12:当在 Android studio 中运行，程序无法安装到 手机时，先检测自己的手机版本sdk 和配置文件中的 minSdkVersion  版本


13：查看自己的 gradle版本  

14：在调用weex的onclick方法，实现从A页面 跳转到B页面时，可以实现正常跳转 ，在“我”的模块可以体现，但是，跳转过去后，会带有一个weex的蓝色title  带有返回和刷新的功能，目前在A 页面 B页面，找不到重写该样式的地方。。（等待文档更新）

  

在使用demo时，需要将相应的 first.js team.js home.js activity.js user.js部署在服务器上，然后配置在test.we中，在进行.we  到.js的编译转换
weex优势：


![ͼʾ 3](https://i.niupic.com/images/2017/01/11/67alUM.jpg)
![ͼʾ 3](https://i.niupic.com/images/2017/01/11/PxBlnp.jpg)
![ͼʾ 3](https://i.niupic.com/images/2017/01/11/jMIbNi.jpg)
![ͼʾ 4](https://i.niupic.com/images/2017/01/11/rWortS.jpg)
