<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
  
  <head>
    <meta charset="UTF-8">
    <title>欢迎页面-X-admin2.0</title>
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
        <a href="">演示</a>
        <a>
          <cite>导航元素</cite></a>
      </span>
      <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="${ctx }/dept/pageByCondition" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
    </div>
    <div class="x-body">
      <div class="layui-row" style="" align="center">
        <form class="layui-form layui-col-md12 x-so" method="get" action="${ctx }/dept/pageByCondition">
          <input type="text" name="name" style="width:50%;"  placeholder="请输入查找部门名称" autocomplete="off" class="layui-input">
          <button class="layui-btn"  lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
        </form>
      </div>
      <xblock>
 	    <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>批量删除</button>
        <button class="layui-btn" onclick="x_admin_show('添加用户','${ctx}/dept/add')"><i class="layui-icon"></i>添加</button>
        <span class="x-right" style="line-height:40px">共有数据：${pageInfo.total} 条</span>
      </xblock>
     
      
      <table class="layui-table">
        <thead>
          <tr>
            <th>
              <div class="layui-unselect header layui-form-checkbox" lay-skin="primary"><i class="layui-icon">&#xe605;</i></div>
            </th>
            <th>ID</th>
            <th>部门名称</th>
            <th>详细信息</th>
            <th>操作</th>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.deptList}" var="dept" varStatus="status">
     <tr>
            <td>
              <div class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id='${dept.id}'><i class="layui-icon">&#xe605;</i></div>
            </td>
            <td>${status.count}</td>
            <td>${dept.name }</td>
            <td>${dept.remark }</td>

            <td class="td-manage">

              <a title="编辑"  onclick="x_admin_show('编辑','${ctx}/dept/update?id=${dept.id }');" href="javascript:;">
                <i class="layui-icon">&#xe642;</i>
              </a>

              <a title="删除" onclick="member_del(this,'${dept.id }')" href="javascript:;">
                <i class="layui-icon">&#xe640;</i>
              </a>

            </td>

          </tr>

	    </c:forEach>




        </tbody>
      </table>
     <!--  <div class="page">
        <div>
          <a class="prev" href="">&lt;&lt;</a>
          <a class="num" href="">1</a>
          <span class="current">2</span>
          <a class="num" href="">3</a>
          <a class="num" href="">489</a>
          <a class="next" href="">&gt;&gt;</a>
        </div>
      </div> -->

      <%--      分页开始--%>
      <div class="page">
        <%-- 设置页码数之前按钮 --%>
        <a href="${pageContext.request.contextPath}${url}&currentPage=1">首页</a>
        <c:if test="${pageInfo.pageNum > 1 }">
          <a href="${pageContext.request.contextPath}${url}&currentPage=${pageInfo.pageNum-1 }">上一页</a>
        </c:if>

        <%-- 根据公式计算begin、end，存到page域中 --%>
        <c:choose>
          <%-- 如果总页数不足10页，那么把所有的页数都显示出来！ --%>
          <c:when test="${pageInfo.pages <= 10 }">
            <c:set var="begin" value="1" />
            <c:set var="end" value="${pageInfo.pages }" />
          </c:when>
          <c:otherwise>
            <%-- 当总页数大于10时，通过公式计算出begin和end --%>
            <c:set var="begin" value="${pageInfo.pageNum-5 }" />
            <c:set var="end" value="${pageInfo.pageNum+4 }" />
            <%-- 计算中若 头溢出 --%>
            <c:if test="${begin < 1 }">
              <c:set var="begin" value="1" />
              <c:set var="end" value="10" />
            </c:if>
            <%-- 计算中若 尾溢出 --%>
            <c:if test="${end > pageInfo.pages }">
              <c:set var="begin" value="${pageInfo.pages - 9 }" />
              <c:set var="end" value="${pageInfo.pages }" />
            </c:if>
          </c:otherwise>
        </c:choose>

        <%-- 根据page域中begin、end值，循环遍历页码列表 --%>
        <c:forEach var="i" begin="${begin }" end="${end }">
          <c:choose>
            <%-- 当前页码数按钮变色，且链接不跳转 --%>
            <c:when test="${i eq pageInfo.pageNum }">
              <a href="javascript:void(0);" style="color:red">${i}</a>
            </c:when>
            <%-- 遍历生成的页码数上，绑上跳转路径与当前页数 --%>
            <c:otherwise>
              <a href="${pageContext.request.contextPath}${url}&currentPage=${i}">${i}</a>
            </c:otherwise>
          </c:choose>
        </c:forEach>

        <%-- 设置页码数之后按钮 --%>
        <c:if test="${pageInfo.pageNum < pageInfo.pages }">
          <a href="${pageContext.request.contextPath}${url}&currentPage=${pageInfo.pageNum+1}">下一页</a>
        </c:if>
        <a href="${pageContext.request.contextPath}${url}&currentPage=${pageInfo.pages}">尾页</a>
      </div>
      <%--      分页结束--%>

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
            url:"${ctx}/dept/delete",
            data:"id="+id,
            type:"get",
            dataType:"text",
            success:function (data){
              console.log(data);
              if (data != "0"){
                $(obj).parents("tr").remove();
                location.reload();
                layer.msg('已删除!',{icon:1,time:1000});
              }
            },
            error:function (){
              alert("删除操作异常");
            }
          })
        });
      }

      //批量删除方法
      function delAll (argument) {
        let data = tableCheck.getData();
        console.log(data);
        layer.confirm('确认要删除吗？'+data,function(index){
          if (data.length == 0){
            layer.alert('您未选中任何元素', {
              icon: 3,
              skin: 'layer-ext-demo'
            })
            return false
          }
          //捉到所有被选中的，发异步进行删除
          $.ajax({
            url:"${ctx}/dept/deleteAll",
            data:"ids="+data,
            type:"post",
            dataType:"text",
            success:function (data){
              console.log(data);
              if (data != "0"){
                location.reload();
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
    <script>var _hmt = _hmt || []; (function() {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
      })();</script>
  </body>

</html>