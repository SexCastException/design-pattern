package com.huazai.gof.responsibility;

/**
 * 责任链模式（Chain of Responsibility Pattern）为请求创建了一个接收者对象的链。这种模式给予请求的类型，对请求的发送者和接收者进行解耦。这种类型的设计模式属于行为型模式。
 * 在这种模式中，通常每个接收者都包含对另一个接收者的引用。如果一个对象不能处理该请求，那么它会把相同的请求传给下一个接收者，依此类推。
 * <p>
 * 可以通过集合、数组生成责任链更加实用
 * 常见开发场景：Java中异常机制、Servlet中过滤器的链式处理、Struts2中拦截器的调用、日志级别的打印
 */
public class Test {
    @org.junit.Test
    public void test() {
        Leader director = new Director("张三");
        Leader manager = new Manager("王五");
        Leader generalManager = new GeneralManager("赵六");

        // 责任链组织关系，实际开发总可以通过配置文件利用反射来读取数据
        director.setNextLeader(manager);
        manager.setNextLeader(generalManager);

        LeaveRequest request = new LeaveRequest("张非凡", 30, "陪产假");
        director.handleReq(request);
    }
}
