<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Default.aspx.cs" Inherits="website1._Default" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" >
<head runat="server">
    <title>Untitled Page</title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
        <asp:Button runat="server" ID="ResponseBtn" Text="Response" 
            onclick="ResponseBtn_Click" />
         <asp:Button runat="server" ID="CookieBtn" Text="Cookie" 
            onclick="CookieBtn_Click" />
          <asp:Button runat="server" ID="SessionBtn" Text="Session" 
            onclick="SessionBtn_Click" />
    </div>  
    </form>
</body>
</html>
