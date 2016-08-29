<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="placeholder.aspx.cs" Inherits="test01.hmwk02.placeholder" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
        <asp:LinkButton runat="server" ID="LinkButton1" OnClick="LinkButton_Click"></asp:LinkButton><br />
        <asp:LinkButton runat="server" ID="LinkButton2" OnClick="LinkButton_Click"></asp:LinkButton><br />
        <asp:LinkButton runat="server" ID="LinkButton3" OnClick="LinkButton_Click"></asp:LinkButton><br />
        <asp:PlaceHolder runat="Server" ID="PlaceHolder1" ></asp:PlaceHolder>
    </div>
    </form>
</body>
</html>
