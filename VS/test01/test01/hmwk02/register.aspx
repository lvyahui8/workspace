<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="register.aspx.cs" Inherits="test01.hmwk02.register" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" >
<head runat="server">
    <title>Untitled Page</title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
        用户名:<asp:TextBox runat="server" ID="uname"></asp:TextBox><asp:RequiredFieldValidator runat="Server" id="unamevald" ControlToValidate="uname" Text="请输入用户名"></asp:RequiredFieldValidator><br />
        密码:<asp:TextBox runat="server" ID="password" TextMode="Password"></asp:TextBox><asp:RequiredFieldValidator runat="Server" ID="passwordvald" ControlToValidate="password">请输入用户名</asp:RequiredFieldValidator><br />
        确认密码:<asp:TextBox runat="server" ID="password2" TextMode="Password"></asp:TextBox><asp:CompareValidator runat="Server" ID="passwordvald2" ControlToValidate="password2" ControlToCompare="password" ErrorMessage="两次输入的密码不一致"></asp:CompareValidator><br />
        <asp:Button ID="submit" runat="server" Text="提交" onclick="submit_Click"/><br />
        <asp:Label ID="res" runat="Server" ></asp:Label>
    </div> 
    </form>
</body>
</html>
