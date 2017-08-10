<!DOCTYPE html>
<html>
<head>
<meta http-equiv=Content-Type content="text/html;charset=utf-8">
</head>
<body>
  Hi {{name}}!
<form method="POST" action="/6form2cookie2session/postform">
   <table>
    <tr>
        <td><label>名字：</label></td>
        <td><input name="name" /></td>
    </tr>
    <tr>
        <td><label>年龄：</label></td>
        <td><input name="age" /></td>
    </tr>
    <tr>
        <td><label>编号：</label></td>
        <td><input name="id" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="提交表单"/>
        </td>
    </tr>
</table>  
</form>
</body>
</html>