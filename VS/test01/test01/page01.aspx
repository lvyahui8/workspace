<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="page01.aspx.cs" Inherits="test01.page01" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
        <h3>List of Event:</h3>
        <asp:ListBox ID="listEvents" runat="Server" Height="107px" Width="355px"/>
        <br />
        <h3>Controls Being Monitored For Change Events:</h3>
        <asp:TextBox id="txt" runat="Server" AutoPostBack="true" 
            OnTextChanged="CtrlChanged"/>  
        <br />
        <asp:CheckBox ID="chk" runat="Server" AutoPostBack="true"
            OnCheckedChanged="CtrlChanged" />
        <br />
        <asp:RadioButton ID="opt1" runat="Server" GroupName="Sample"
            AutoPostBack="true" OnCheckedChanged="CtrlChanged" />
        <asp:RadioButton ID="opt2" runat="Server" GroupName="Sample"
            AutoPostBack="true" OnCheckedChanged="CtrlChanged"/>
        
    </div>
    </form>
</body>
</html>
