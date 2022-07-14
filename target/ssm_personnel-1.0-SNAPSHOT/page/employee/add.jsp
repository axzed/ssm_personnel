<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
  
  <head>
    <meta charset="UTF-8">
    <title>添加员工</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="${ctx}/public/css/font.css">
    <link rel="stylesheet" href="${ctx}/public/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="${ctx}/public/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${ctx}/public/js/xadmin.js"></script>
  </head>
  
  <body>
    <div class="x-body">
        <form class="layui-form" method="POST" id="empForm"  action="${ctx}/employee/add">
        <input type="hidden" name="id" id="id" value="${emp.id }" >

          <div class="layui-form-item" >
              <label for="name" class="layui-form-label">
                  <span class="x-red">*</span>姓名
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="name" name="name" required="" lay-verify="required"
                  autocomplete="off" class="layui-input" value="${emp.name }">
              </div>
          </div>

          <div class="layui-form-item" >
              <label for="password" class="layui-form-label">
                  <span class="x-red">*</span>密码
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="password" name="password" required="" lay-verify="required"
                  autocomplete="off" class="layui-input" value="${emp.password }">
              </div>
          </div>

          <div class="layui-form-item" >
              <label for="cardId" class="layui-form-label">
                  <span class="x-red">*</span>身份证号码
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="cardId" name="cardId" required="" lay-verify="required"
                  autocomplete="off" class="layui-input" value="${emp.carId }">
              </div>
          </div>

           <div class="layui-form-item">
              <label class="layui-form-label">
                  <span class="x-red">*</span>性别
              </label>
              <div class="layui-input-inline">
                  <input type="radio" name="sex" value="1" title="男">
                  <input type="radio" name="sex" value="2" title="女" checked>
              </div>
          </div>

           <div class="layui-form-item">
              <label for="education" class="layui-form-label">
                  <span class="x-red">*</span>学历
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="education" name="education" required="" lay-verify="required"
                  autocomplete="off" class="layui-input" value="${emp.education }">
              </div>
          </div>

           <div class="layui-form-item">
              <label for="email" class="layui-form-label">
                  <span class="x-red">*</span>邮箱
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="email" name="email" required="" lay-verify="required"
                  autocomplete="off" class="layui-input" value="${emp.email }">
              </div>
          </div>

           <div class="layui-form-item">
              <label for="phone" class="layui-form-label">
                  <span class="x-red">*</span>手机
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="phone" name="phone" required="" lay-verify="required"
                  autocomplete="off" class="layui-input" value="${emp.phone }">
              </div>
          </div>

          <div class="layui-form-item">
              <label for="address" class="layui-form-label">
                  <span class="x-red">*</span>联系地址
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="address" name="address" required="" lay-verify="required"
                  autocomplete="off" class="layui-input" value="${emp.address }">
              </div>
          </div>

  			<div class="layui-form-item">
              <label for="jobId" class="layui-form-label">
                  <span class="x-red">*</span>职位
              </label>
              <div class="layui-input-inline">
                  <select id="jobId" name="jobId" class="valid" >
                    <c:forEach items="${requestScope.jobInfos}" var="job" varStatus="status">
                        <option value="${job.id}">${job.name}</option>
                    </c:forEach>
                  </select>
              </div>
          </div>

            <div class="layui-form-item">
              <label for="deptId" class="layui-form-label">
                  <span class="x-red">*</span>部门
              </label>
              <div class="layui-input-inline">
                  <select id="deptId" name="deptId" class="valid">
                    <c:forEach items="${requestScope.deptInfos}" var="dept" varStatus="status">
                    <option value="${dept.id}">${dept.name}</option>
                    </c:forEach>
                  </select>
              </div>
          </div>         
          
          <div class="layui-form-item">
              <label class="layui-form-label">
              </label>
              <input type="submit" value=" 提交" class="layui-btn" lay-filter="add" lay-submit=""/>
          </div>

      </form>
    </div>
    <script>
        layui.use(['form','layer'], function(){
            $ = layui.jquery;
          var form = layui.form
          ,layer = layui.layer;
        
          //自定义验证规则
          form.verify({
            nikename: function(value){
              if(value.length < 5){
                return '昵称至少得5个字符啊';
              }
            }
            ,pass: [/(.+){6,12}$/, '密码必须6到12位']
            ,repass: function(value){
                if($('#L_pass').val()!=$('#L_repass').val()){
                    return '两次密码不一致';
                }
            }
          });

            //监听提交
            form.on('submit(add)', function(data){
                //把id为deptForm的form表单里的参数自动封装为参数传递
                let params=$('#empForm').serialize();
                console.log(params);
                $.ajax({
                    url: "${ctx}/employee/add",
                    type: "POST",
                    data:params,
                    cache:false,
                    dataType: "json",
                    success: function(data){
                        layer.alert("新增成功", {icon: 6},function (index) {
                            parent.layer.closeAll();
                            window.parent.location.reload();
                        });
                    },
                    error:function(err){
                        layer.msg('程序异常!',{icon: 2,time:1000});
                    }
                });
                return false;
            });
        });
    </script>
    
  </body>

</html>