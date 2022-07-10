<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
  <head>
    <meta charset="UTF-8">
    <title>用户信息</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="${ctx}/public/logo.ico" type="image/x-icon" />
    <link rel="stylesheet" href="${ctx}/public/css/font.css">
    <link rel="stylesheet" href="${ctx}/public/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="${ctx}/public/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${ctx}/public/js/xadmin.js"></script>
  </head>
  
  <body>
    <div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="">首页</a>
        <a>
          <cite>用户信息</cite></a>
      </span>
      <%-- <button type="button" onclick="location.href='${ctx}/user/add'" class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:innert;margin-left:75%;;"  ><i class="layui-icon"></i>增加</button> --%>
      <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="${ctx }/user/list" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
    </div>
    <div class="x-body">
      <div class="layui-row" style="" align="center">
        <form class="layui-form layui-col-md12 x-so" method="post" action="${ctx }/user/search">
<%--          <input class="layui-input" placeholder="开始日" name="start" id="start">--%>
<%--          <input class="layui-input" placeholder="截止日" name="end" id="end">--%>
          <input type="text" name="content" style="width:50%;"  placeholder="请输入查找管理员的名字" autocomplete="off" class="layui-input">
          <button type="submit" class="layui-btn"><i class="layui-icon">&#xe615;</i></button>
        </form>
      </div>
      <xblock>
        <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>批量删除</button>
        <button class="layui-btn" onclick="x_admin_show('添加用户','${ctx}/user/add')"><i class="layui-icon"></i>添加</button>
        <span class="x-right" style="line-height:40px">共有数据：n 条</span>
      </xblock>
     
      
      <table class="layui-table">
        <thead>
          <tr>
            <th>
              <div class="layui-unselect header layui-form-checkbox" lay-skin="primary"><i class="layui-icon">&#xe605;</i></div>
            </th>
            <th>序号</th>
            <th>管理员登录名</th>
            <th>管理员真实姓名</th>
            <th>注册日期</th>
            <th>操作</th>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.adminList}" var="admin" varStatus="status">
          <tr>
            <td>
              <div class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id=${admin.id}><i class="layui-icon">&#xe605;</i></div>
            </td>
            <td>${status.count }</td>
            <td>${admin.username }</td>
            <td>${admin.nickname }</td>
            <fmt:setLocale value="zh_cn"/>
            <td><fmt:formatDate type="both" pattern="yyyy年MM月dd日 hh小时mm分钟ss秒" value="${admin.createTime}"></fmt:formatDate></td>
            
            <!-- <td class="td-status">
              <span class="layui-btn layui-btn-normal layui-btn-mini">已启用</span></td> -->
            <td class="td-manage">
              <a onclick="member_stop(this,'10001')" href="javascript:;"  title="启用">
                <i class="layui-icon">&#xe601;</i>
              </a>
              <%-- <a title="编辑"  onclick="x_admin_show('编辑','${ctx}/job/add?id=${dept.id }');" href="javascript:;"> --%>
              <a title="编辑"  href="${ctx}/user/update?id=${admin.id }">
                <i class="layui-icon">&#xe642;</i>
              </a>
              <a title="删除" onclick="member_del(this,'${admin.id }')" href="javascript:;">
                <i class="layui-icon">&#xe640;</i>
              </a>
            </td>
          </tr>
        </c:forEach>
        
          
          
          
        </tbody>
      </table>
      <div class="page">
        <div>
          <a class="prev" href="">&lt;&lt;</a>
          <a class="num" href="">1</a>
          <span class="current">2</span>
          <a class="num" href="">3</a>
          <a class="num" href="">489</a>
          <a class="next" href="">&gt;&gt;</a>
        </div>
      </div>

    </div>
    <script>
      layui.use('laydate', function(){
        var laydate = layui.laydate;
        
        //执行一个laydate实例
        laydate.render({
          elem: '#start' //指定元素
        });

        //执行一个laydate实例
        laydate.render({
          elem: '#end' //指定元素
        });
      });

       /*用户-停用*/
      function member_stop(obj,id){
          layer.confirm('确认要停用吗？',function(index){

              if($(obj).attr('title')=='启用'){

                //发异步把用户状态进行更改
                $(obj).attr('title','停用')
                $(obj).find('i').html('&#xe62f;');

                $(obj).parents("tr").find(".td-status").find('span').addClass('layui-btn-disabled').html('已停用');
                layer.msg('已停用!',{icon: 5,time:1000});

              }else{
                $(obj).attr('title','启用')
                $(obj).find('i').html('&#xe601;');

                $(obj).parents("tr").find(".td-status").find('span').removeClass('layui-btn-disabled').html('已启用');
                layer.msg('已启用!',{icon: 5,time:1000});
              }
              
          });
      }

      /*用户-删除*/
      function member_del(obj,id){
        layer.confirm('确认要删除吗？',function(index){
          //发异步删除数据
          //等以后再使用异步，这里先使用
          $.ajax({

            url:"${ctx}/user/delete",
            data:"id="+id,
            type:"get",
            dataType:"text",
            success:function (data){

              console.log(data);

              if (data != "0"){
                $(obj).parents("tr").remove();
                layer.msg('已删除!',{icon:1,time:1000});
              }

            },
            error:function (){
              alert("删除操作异常");
            }

          })

          <%--$.get("${ctx}/user/delete","id="+id);--%>
          <%--$(obj).parents("tr").remove();--%>
          <%--layer.msg('已删除!',{icon:1,time:1000});--%>
        });
      }



      //批量删除方法
      function delAll (argument) {

        let data = tableCheck.getData();

        console.log(data);

        layer.confirm('确认要删除吗？'+data,function(index){
          //捉到所有被选中的，发异步进行删除
          $.ajax({
            url:"${ctx}/user/deleteAll",
            data:"ids="+data,
            type:"post",
            dataType:"text",
            success:function (data){
              console.log(data);
              if (data != "0"){
                layer.msg('删除成功', {icon: 1});
                $(".layui-form-checked").not('.header').parents('tr').remove();
              }
            },
            error:function (){
              alert("删除操作异常");
            }
          })
        });
      }
    </script>
    <!-- <script>var _hmt = _hmt || []; (function() {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
      })();</script> -->
  </body>

</html>