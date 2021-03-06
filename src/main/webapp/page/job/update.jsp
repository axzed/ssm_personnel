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
        <form class="layui-form" method="POST" id="jobForm"  action="${ctx}/job/modify">
        <input type="hidden" name="id" id="id" value="${job.id }" >
            <div class="layui-form-item">
              <label for="name" class="layui-form-label">
                  <span class="x-red">*</span>职位名称
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="name" name="name" required="" lay-verify="required"
                  autocomplete="off" class="layui-input" value="${job.name}">
              </div>
            </div>

            <div class="layui-form-item">
              <label for="remark" class="layui-form-label">
                  <span class="x-red">*</span>职位详情
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="remark" name="remark" required="" lay-verify="required"
                  autocomplete="off" class="layui-input" value="${job.remark}">
              </div>
            </div>

            <div class="layui-form-item">
                <label for="dept_id" class="layui-form-label">
                    <span class="x-red">*</span>部门
                </label>
                <div class="layui-input-inline">
                    <select id="dept_id" name="deptId" class="valid">
                        <c:forEach items="${requestScope.deptInfos}" var="deptInfo" varStatus="status">
                            <option value="${deptInfo.id}" <c:if test="${job.deptId == deptInfo.id }">selected</c:if>>${deptInfo.name}</option>
                        </c:forEach>
                    </select>
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
                let params=$('#jobForm').serialize();
                console.log(params);
                $.ajax({
                    url: "${ctx}/job/modify",
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