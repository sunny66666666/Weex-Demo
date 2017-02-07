Weex学习分享

1:什么是weex<br>
------------
Weex is a extendable cross-platform solution for dynamic programming and publishing projects.
 Weex是针对动态编程和发布项目的一个可扩展、跨平台的解决方案。

这是来自Weex Document的介绍。这句话个人感觉还是非常有诱惑力的。为什么？击中移动端开发两个痛点。

动态编程＋发布。Weex能做到随时编程发布到服务端，应用端即时更新。想想以前，应用开发－测试－发布，多么繁琐和耗时的一个流程，
万一线上出了bug，那真是痛不欲生，尤其时用户量上百万千万的应用，老板连杀你的心都有。但是有了Weex就不一样了。修复bug，用户都是无感知的。
跨平台。这是移动端无数人向往的和为之努力的事。一处编写，到处运行。Weex支持Android，iOS，Web三大平台，一份代码，三个平台通用。
等到有一天，Weex真的发展强大起来，公司成本估计可以节省不少。

原理：<br>
![](https://i.niupic.com/images/2017/02/06/PM55lm.png)<br>


2：怎么安装<br>
------------
[见官网]https://weex-project.io/cn/ 
安装好后，使用命令窗口进行编译运行  各种命令等
入口  
![](https://i.niupic.com/images/2017/02/06/54x7SV.png)<br>

3：主要的一些方法 技术<br>
------------
####代码结构
![](https://i.niupic.com/images/2017/02/07/sYYh7Q.png)
文件类型是xxx.we的形式


####(1)```<slider>```

```<slider>``` 组件用于在一个页面中展示多个图片，在前端，这种效果被称为 轮播图。
[]https://weex-project.io/cn/references/components/slider.html<br>
####(2)```<image>``` 组件用于渲染图片，并且它不能包含任何子组件。可以用 ```<img>``` 作简写。
和html不同的一点是：<br>
1：图片必须要定义宽高  才会显示<br>
2：图片的地址不能配本地的，必须配置网络地址<br>
3：应该是有相应的缓存处理的 ，第一次下载图片会比较慢，但是以后每次启动页面，直接显示，不卡壳<br>
####(3)modal 模块提供了以下展示消息框的 API：toast、alert、confirm 和 prompt  这些样式都基本符合移动端的显示习惯，使用很方便<br>
####(4)子模块的引用。。。<br>
由于各个页面的title_bar的样式都比较接，所以可以将这个子模块单独处理，什么地方需要直接引用，在相应的页面配置需要的参数即可，很方便
```<nav>```
统一构建<br>
![](https://i.niupic.com/images/2017/02/07/BxtI0i.png)
怎么调用<br>
![](https://i.niupic.com/images/2017/02/07/vfDLIu.png)


####(5)自由适配各种大小类型的移动端设备，不需要我们自己实现响应式，<br>
4：坑<br>
------------
1:命名文件名的 时候，不要以text.we命名，不然会出现 text不停的循环的情况 就是你weex文件里用的组件名不要跟文件名同名 就好了~<br>

2:通过设置 if 特性值，你可以控制当前组件是否显示。如果值为真，则当前组件会被渲染出来，如果值为假则会被移除<br>

3: ```<image>```组件用于渲染图片，并且它不能包含任何子组件。

需要注意的是，需要明确指定 width 和 height，否则图片无法显示。

```<image>```组件不支持任何子组件，因此不要尝试在 组件中添加任何组件。如果需要实现 background-image 的效果，
可以使用 组件和 position 定位来现实，如下面代码。

还有，目前项目里的图片路径均来自与 网络路径 本地路径如何加载 文档中还没有发现（等待更新）

4:根节点：每个 Weex 页面最顶层的节点，我们称为根节点。下面是目前我们支持的三种根节点：<br>
(这一点和html5比较，没有那么灵活)
```javascript
<div>：普通根节点，有确定的尺寸，不可滚动。
<scroller>：可滚动根节点，适用于需要全页滚动的场景。
<list>：列表根节点，适用于其中包含重复的子元素的列表场景。
```

目前 Weex 仅支持以上三种根节点。

注意事项： 只支持一个根节点，多个根节点将无法被 Weex 正常的识别和处理。

5:a链接不能跳转外网以外的链接页面（第二遍进行 a链接测试时，a链接又不能正常跳转 坑！！还需要继续跟踪测试）<br>

6：switch使用官方提供的demo 和自己本地运行出来的效果不一样<br>

7：input标签被 手机弹出来的 键盘输入框遮挡（我觉得这个还真是个问题）<br>

8：stream用来实现网络请求 类似ajax(存在的问题是 ，目前在playground中扫码可以正常获取 ，使用github demo 也可以正常获取 ，
但是在我自己集成的 项目中无法获取 ，问题已经定位在 原生代码中。)<br>

9:storage:存储功能（待测试）<br>

10：picker的demo也是（待测试）<br>

11：编译weex.we为weex.js生成到 D:\nodejs\node_modules\weex_tmp\h5_render文件夹后 ，需要生成一个 就保存一个 不然会被下一个覆盖掉
也有可以一次性把所有的编写好的.we都完成 一次性生成.js
文档有相应的指令<br>

12:引用模块的时候 ，在<nav>例子中 变量名只识别小写字母，如果是驼峰的不识别<br>
```javascript
<nav title='我' leftimg='http://i.niupic.com/images/2017/01/03/TRRdfA.png'  
			rightimg='http://i.niupic.com/images/2017/01/03/ox15A2.png'
			 >
		</nav>
```

13：查看自己的 gradle版本<br>

14：在调用weex的onclick方法，实现从A页面 跳转到B页面时，可以实现正常跳转 ，在“我”的模块可以体现，但是，跳转过去后，会带有一个weex的蓝色title
 带有返回和刷新的功能，目前在A 页面 B页面，找不到重写该样式的地方。。（等待文档更新）<br>
 
 15:当在 Android studio 中运行，程序无法安装到 手机时，先检测自己的手机版本sdk 和配置文件中的 minSdkVersion 版本<br>
 
5：(半)成品展示<br>
------------
下载二维码：<br>
![](https://i.niupic.com/images/2017/02/07/up2lhc.png)<br>
weex demo  [源码地址：]<br>
(https://github.com/sunny66666666/Weex-Demo)<br>

![ͼʾ 3](https://i.niupic.com/images/2017/01/11/67alUM.jpg)
![ͼʾ 3](https://i.niupic.com/images/2017/01/11/PxBlnp.jpg)
![ͼʾ 3](https://i.niupic.com/images/2017/01/11/jMIbNi.jpg)
![ͼʾ 4](https://i.niupic.com/images/2017/01/11/rWortS.jpg)


