## 软件体系结构实验笔记
### 实验一 组件化开发实验
1. lombok：用于简化开发，编译时才执行
* @Data 
* @NoArgsConstructor 
* @AllArgsConstructor 
* @Builder : 建造者，可参考建造者模式
2. 依赖注入@Autowired
* 将所有的对象注册成组件(主动 --> 被动)
* 开发过程中不建议使用@Autowired
3. 代码层面如何设计？
* 抽象 --> 复用 --> 重用
* e.g. 注册、添加用户都是向数据库中添加，不需要基于角色进行区分，写许多重复代码，一个addUser()即可
```
@Transactional
    public User addUser(User user) {
        return userRepository.save(user);
    }
```
4. 业务逻辑层：把对象存入数据库
5. 报错：java.lang.IllegalArgumentException: After saving the identifier must not be null
* 原因：没有添加主键
* 解决：添加主键，使用@Id 注解声明将实体类的属性映射为数据库的主键
```
@Id
private Integer id;
```

### 实验二 管道过滤器实验
1. 用户单点登录：服务器基于自定义算法生成一个token，返给用户
2. 业务层获取单个用户：getUser()，获取多个用户：listUsers()
3. 自定义异常 
* 创建异常类，用于处理异常
* 异常抛给了Spring的容器
4. Controller如何完成测试？创建一个http的测试脚本进行测试
5. 水平权限验证：用户携带身份发请求时，不能把身份信息放在地址栏中，信息应该从token中解密后注入
6. REST风格：URL中只使用名词来定位资源，用HTTP协议里的动词（GET、POST、PUT、DELETE）来实现资源的增删改查操作
7. POST请求：不通过地址栏传参，数据放在请求体中
8. 拦截器
```        
registry.addInterceptor(loginInterceptor)
        .addPathPatterns("/api/**")
        .excludePathPatterns("/api/login")
```