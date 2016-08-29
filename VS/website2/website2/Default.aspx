<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Default.aspx.cs" Inherits="website2._Default" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" >
<head runat="server">
    <title>Untitled Page</title>
   
</head>
<body>
    <form id="form1" runat="server">
    <div>
        用户名：<asp:TextBox runat="server" ID="username" ></asp:TextBox>
        <asp:RequiredFieldValidator runat="server" ID="usValidator" ControlToValidate="username" Text="用户名不能为空"></asp:RequiredFieldValidator><br/>
        密码：<asp:TextBox runat="server" ID="password" TextMode="Password" ></asp:TextBox>
        <asp:RequiredFieldValidator runat="server" ID="passwordValidator" ControlToValidate="password" Text="密码不能为空"></asp:RequiredFieldValidator><br/>
        <asp:Button runat="server" ID="submitBtn" Text="登陆" onclick="submitBtn_Click"/>
    </div> 
    </form>
</body>
</html>
