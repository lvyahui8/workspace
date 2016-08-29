<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="requiredfield.aspx.cs" Inherits="test01.validator.requiredfield" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
        <b>必须验证控件演示</b><asp:Button runat="Server" ID="ButtonOK" Text="提交" 
            onclick="ButtonOK_Click"/><br />
        请输入学号：<asp:TextBox runat="Server" ID="TextNum"></asp:TextBox><asp:RequiredFieldValidator runat="Server" ID="ValrNum" ControlToValidate="TextNum" Text="请输入学号"></asp:RequiredFieldValidator><br />
        请选择专业：<asp:DropDownList runat="Server" ID="DropSpec"></asp:DropDownList><asp:RequiredFieldValidator runat="Server" ID="ValSpeciality" ControlToValidate="DropSpec" Text="请选择一个专业" InitialValue="--请选择专业--"></asp:RequiredFieldValidator><br />
        <asp:Label runat="Server" ID="LabelResult" Text=""></asp:Label>
    </div>
    </form>
</body>
</html>
