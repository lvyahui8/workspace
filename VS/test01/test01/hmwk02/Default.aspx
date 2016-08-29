<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Default.aspx.cs" Inherits="test01.hmwk02._Default" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" >
<head runat="server">
    <title>Untitled Page</title>
    <script type="text/css">
        *{margin:0;padding:0;}
    </script>
</head>
<body>
    <form id="form1" runat="server">
    <div>
        <asp:Image runat="server" ID="image" ImageUrl="" /><br />
        <asp:LinkButton runat="server" ID="prev" Text="上一张" onclick="prev_Click"></asp:LinkButton>
        <asp:LinkButton runat="server" ID="next" Text="下一张" onclick="next_Click"></asp:LinkButton>
        <asp:Label ID="tnt" runat="server"></asp:Label>
    </div>
    </form>
</body>
</html>
