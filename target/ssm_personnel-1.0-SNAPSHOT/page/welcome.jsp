<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title></title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="${ctx}/public/logo.ico" type="image/x-icon" />
    <link rel="stylesheet" href="${ctx}/public/css/font.css">
    <link rel="stylesheet" href="${ctx}/public/css/xadmin.css">
    <script src="${ctx}/public/js/echarts.min.js"></script>
    <script src="${ctx}/public/js/jquery-3.4.1.min.js"></script>
    <script src="${ctx}/public/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${ctx}/public/js/xadmin.js"></script>
</head>
<body>
<div class="x-body layui-anim layui-anim-up">
    <blockquote class="layui-elem-quote">欢迎管理员：
        <span class="x-red">${sessionScope.admin.username }</span>！系统当前时间：<span id="time" style="color: green"></span>
    </blockquote>
    <fieldset class="layui-elem-field">
        <legend>数据统计</legend>
        <div class="layui-field-box">
            <div class="layui-col-md12">
                <div class="layui-card">
                    <div class="layui-card-body">
                        <div class="layui-carousel x-admin-carousel x-admin-backlog" lay-anim="" lay-indicator="inside" lay-arrow="none" style="width: 100%; height: 90px;">
                            <div carousel-item="">
                                <ul class="layui-row layui-col-space10 layui-this">
                                    <li class="layui-col-xs4">

                                        <a href="javascript:;" onclick="x_admin_show('部门人数统计','./page/chart_zhu.html',600,600)" class="x-admin-backlog-body">
                                            <h2>部门人数统计图</h2>
                                            <p>
                                            <h2 style="color: red;font-size: 16px">点击查看</h2>
                                            </p>
                                        </a>
                                    </li>
                                    <li class="layui-col-xs4">
                                        <a href="javascript:;"  id="test2"  class="x-admin-backlog-body">
                                            <h3>会员数</h3>
                                            <p>
                                                <cite>12</cite>
                                            </p>
                                        </a>
                                    </li>
                                    <li class="layui-col-xs4">
                                        <a href="javascript:;" class="x-admin-backlog-body">
                                            <h3>回复数</h3>
                                            <p>
                                                <cite>99</cite></p>
                                        </a>
                                    </li>

                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </fieldset>
    <fieldset class="layui-elem-field">
        <legend>系统通知</legend>
        <div class="layui-field-box">
            <table class="layui-table" lay-skin="line">
                <tbody>
                <tr>
                    <td >
                        <a class="x-a" href="/" target="_blank">隨便來點通知</a>
                    </td>
                </tr>
                <tr>
                    <td >
                        <a class="x-a" href="/" target="_blank">你好，我好，大家好</a>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </fieldset>
    <fieldset class="layui-elem-field">
        <legend>系统信息</legend>
        <div class="layui-field-box">
            <table class="layui-table">
                <tbody>
                <tr>
                    <th>系统版本</th>
                    <td>1.0.18</td></tr>
                <tr>
                    <th>服务器地址</th>
                    <td>www.axzed.com</td></tr>
                <tr>
                    <th>操作系统</th>
                    <td>Windows 11</td></tr>
                <tr>
                    <th>运行环境</th>
                    <td>Apache/2.4.23 (Win32) OpenSSL/1.0.2j mod_fcgid/2.3.9</td></tr>
                <tr>
                    <th>JDK版本</th>
                    <td>1.8</td></tr>
                <tr>
                    <th>java运行方式</th>
                    <td>tomcat</td></tr>
                <tr>
                    <th>MYSQL版本</th>
                    <td>8.0.29</td></tr>
                <tr>
                    <th>Spring</th>
                    <td>5.0.18</td></tr>
                <tr>
                    <th>上传附件限制</th>
                    <td>2M</td></tr>
                <tr>
                    <th>执行时间限制</th>
                    <td>30s</td></tr>
                <tr>
                    <th>剩余空间</th>
                    <td>86015.2M</td></tr>
                </tbody>
            </table>
        </div>
    </fieldset>
    <fieldset class="layui-elem-field">
        <legend>开发团队</legend>
        <div class="layui-field-box">
            <table class="layui-table">
                <tbody>
                <tr>
                    <th>版权所有</th>
                    <td>xxxxx(xxxx)
                    </td>
                </tr>
                <tr>
                    <th>开发者</th>
                    <td>薛文朝</td></tr>
                </tbody>
            </table>
        </div>
    </fieldset>
    <blockquote class="layui-elem-quote layui-quote-nm">这里是底部。</blockquote>
</div>
<script>
    function showTime() {
        var date = new Date();

        var year = date.getFullYear();
        var month = date.getMonth() + 1;
        month = month < 10 ? "0" + month : month;
        var day = date.getDate();
        day = day < 10 ? "0" + day : day;
        var week = "日一二三四五六".charAt(date.getDay()); // 使用charAt函数提取相应汉字
        var hour = date.getHours();
        hour = hour < 10 ? "0" + hour : hour; // 用三目运算符调整数字显示格式
        var minute = date.getMinutes();
        minute = minute < 10 ? "0" + minute : minute;
        var second = date.getSeconds();
        second = second < 10 ? "0" + second : second;

        var current = year + "-" + month + "-" + day + " " + "星期" + week + " " + hour + ":" + minute + ":" + second;

        document.getElementById("time").innerHTML = current;
    }
    setInterval("showTime()", 1000);//每隔1000毫秒（即1秒）显示一次当前时间

</script>

</body>
</html>