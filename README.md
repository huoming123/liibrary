#图书管理系统（b站有项目演示以及详细代码讲解）  

#接计算机毕业设计（代码注释详细+做完会录制视频讲解 需要加微信13650154582）


#b站地址链接：https://www.bilibili.com/video/BV1FG4y1S7zQ/?spm_id_from=333.337.search-card.all.click

#介绍
![Image text](https://github.com/huoming123/liibrary/blob/main/%E9%A1%B9%E7%9B%AE%E6%88%AA%E5%9B%BE/%E9%A1%B9%E7%9B%AE%E6%96%87%E4%BB%B6.png)  
#项目功能结构图  
![Image text](https://github.com/huoming123/liibrary/blob/main/%E9%A1%B9%E7%9B%AE%E6%88%AA%E5%9B%BE/%E5%8A%9F%E8%83%BD%E5%9B%BE.png)  
本系统分读者跟管理员两个角色；各个模块具体功能如下：  
（1）人员管理：人员管理包括社区人员管理以及管理员管理。管理员管理系统注册的社区人员信息以及管理员添加管理员基本信息，这一功能是必要的，通过录入管理员的基本信息，可以在关键时刻快速的查阅资料，找到管理员。  
（2）图书管理：管理员在后台录入图书信息，录入成功之后可以选择上架图书，上架成功之后社区人员就可以在线借阅图书。  
（3）借阅管理：管理员在后台录入借阅制度信息以及查看社区人员借阅记录。  
（4）捐赠管理：管理员登记捐赠人信息以及捐赠图书信息。  
（5）信息管理：管理员录入公告信息以及回复社区人员的留言。  
（6）个人中心：社区人员登录之后可以在个人中心修改信息以及修改密码。  
（7）留言反馈：社区人员发表留言回复。  
（8）捐赠图书：管理员登记捐赠人信息以及捐赠的图书信息之后，社区人员可以查看自己的捐赠记录。  
（9）在线借阅：社区人员在线查看图书信息，然后在图书借阅功能输入图书编号借阅图书，在归还图书功能输入图书归还图书，如果逾期了，那么社区人员需要支付逾期费用之后才可以归还图书。  
（10）公告信息：社区人员登录之后可以在首页查看公告信息。  

#读者流程图  

![Image text](https://github.com/huoming123/liibrary/blob/main/%E9%A1%B9%E7%9B%AE%E6%88%AA%E5%9B%BE/%E6%B5%81%E7%A8%8B%E5%9B%BE.png)  

#技术路线   

本项目是基于springboot+vue的前后端分离项目框架;以Windows10为操作系统，基于java的jdk1.8;采用idea软件为开发后台工具，vscode作为前端的开发工具,element-ui作为前端的UI框架。运用mysql进行数据库存储;服务器为本机电脑。 

#项目界面截图  

![Image text](https://github.com/huoming123/liibrary/blob/main/%E9%A1%B9%E7%9B%AE%E6%88%AA%E5%9B%BE/%E7%99%BB%E5%BD%95%E9%A1%B5%E9%9D%A2.png) 
![Image text](https://github.com/huoming123/liibrary/blob/main/%E9%A1%B9%E7%9B%AE%E6%88%AA%E5%9B%BE/%E6%B3%A8%E5%86%8C%E9%A1%B5%E9%9D%A2.png) 
![Image text](https://github.com/huoming123/liibrary/blob/main/%E9%A1%B9%E7%9B%AE%E6%88%AA%E5%9B%BE/%E9%A6%96%E9%A1%B5.png)    
![Image text](https://github.com/huoming123/liibrary/blob/main/%E9%A1%B9%E7%9B%AE%E6%88%AA%E5%9B%BE/%E4%B8%AA%E4%BA%BA%E4%BF%A1%E6%81%AF.png)  
![Image text](https://github.com/huoming123/liibrary/blob/main/%E9%A1%B9%E7%9B%AE%E6%88%AA%E5%9B%BE/%E5%9C%A8%E7%BA%BF%E5%9B%BE%E4%B9%A6.png)  
![Image text](https://github.com/huoming123/liibrary/blob/main/%E9%A1%B9%E7%9B%AE%E6%88%AA%E5%9B%BE/%E5%9B%BE%E4%B9%A6%E8%AF%A6%E6%83%85.png)  
![Image text](https://github.com/huoming123/liibrary/blob/main/%E9%A1%B9%E7%9B%AE%E6%88%AA%E5%9B%BE/%E5%9B%BE%E4%B9%A6%E5%80%9F%E9%98%85.png)  
![Image text](https://github.com/huoming123/liibrary/blob/main/%E9%A1%B9%E7%9B%AE%E6%88%AA%E5%9B%BE/%E5%BD%92%E8%BF%98%E5%9B%BE%E4%B9%A6.png)   
![Image text](https://github.com/huoming123/liibrary/blob/main/%E9%A1%B9%E7%9B%AE%E6%88%AA%E5%9B%BE/%E5%9B%BE%E4%B9%A6%E5%BD%95%E5%85%A5%E9%A1%B5%E9%9D%A2.png)   ![Image text](https://github.com/huoming123/liibrary/blob/main/%E9%A1%B9%E7%9B%AE%E6%88%AA%E5%9B%BE/%E5%9B%BE%E4%B9%A6%E5%88%97%E8%A1%A8.png)  
![Image text](https://github.com/huoming123/liibrary/blob/main/%E9%A1%B9%E7%9B%AE%E6%88%AA%E5%9B%BE/%E5%80%9F%E9%98%85%E8%AE%B0%E5%BD%95%20.png)  
![Image text](https://github.com/huoming123/liibrary/blob/main/%E9%A1%B9%E7%9B%AE%E6%88%AA%E5%9B%BE/%E5%85%AC%E5%91%8A.png)  




