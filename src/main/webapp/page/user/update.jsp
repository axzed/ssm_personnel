<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
  
  <head>
    <meta charset="UTF-8">
    <title>欢迎页面-X-admin2.0</title>
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
        <form class="layui-form" method="POST" id="userForm"  action="${ctx}/user/modify">
        <input type="hidden" name="id" id="id" value="${admin.id }" >
          <div class="layui-form-item">
              <label for="username" class="layui-form-label">
                  <span class="x-red">*</span>登录名
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="username" name="username" required="" lay-verify="required"
                  autocomplete="off" class="layui-input" value="${admin.username}">
              </div>
             
          </div>
         <div class="layui-form-item">
              <label for="username" class="layui-form-label">
                  <span class="x-red">*</span>真实姓名
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="nickname" name="nickname" required="" lay-verify="required"
                  autocomplete="off" class="layui-input" value="${admin.nickname}">
              </div>
             
          </div>
           <div class="layui-form-item">
              <label for="username" class="layui-form-label">
                  <span class="x-red">*</span>密码
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="password" name="password" required="" lay-verify="required"
                  autocomplete="off" class="layui-input" value="${admin.password }">
              </div>
             
          </div>
            <div class="layui-form-item">
                <label  class="layui-form-label">
                    <span class="x-red">*</span>用户状态
                </label>
                <div class="layui-input-inline">
                    <input type="radio" name="status" value="1" title="启用" <c:if test="${admin.status ==1}">checked</c:if>>
                    <input type="radio" name="status" value="0" title="禁用" <c:if test="${admin.status ==0}">checked</c:if>>
                </div>
            </div>
         
          <div class="layui-form-item">
<%--              <label for="L_repass" class="layui-form-label"></label>--%>
              <input type="submit" value=" 提交" class="layui-btn" lay-filter="update" lay-submit=""/>
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
            form.on('submit(update)', function(data){
                console.log(data);
                //把id为deptForm的form表单里的参数自动封装为参数传递
                let params=$('#userForm').serialize();
                console.log(params);
                $.ajax({
                    url: "${ctx}/user/modify",
                    type: "POST",
                    data:params,
                    cache:false,
                    dataType: "json",
                    success: function(data){
                            layer.alert("修改成功", {icon: 6},function (index) {
                                layer.close(index);
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