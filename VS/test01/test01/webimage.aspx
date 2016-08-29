<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="webimage.aspx.cs" Inherits="test01.webimage" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <style type="text/css">
        * {margin:0px;padding:0px;}
        .im1{margin:0px auto;margin-left:20px;}
    </style>
</head>
<body>
    <form id="form1" runat="server">
    <div>
        <asp:ImageButton CssClass="im1" runat="server" Width="400px" ImageUrl="images/im.jpg" ToolTip="test" PostBackUrl="http://www.yahui.com" AlternateText="yahui" />
        <asp:Image runat="Server" ImageUrl="images/im.jpg" Width="300px"/><br />
        <asp:ImageMap runat="Server" ImageUrl="images/im.jpg" Width="500px" 
            HotSpotMode="Navigate">
            <asp:CircleHotSpot  HotSpotMode="Navigate" NavigateUrl="http://www.yahui.com" 
                Radius="20" Target="_blank" X="100" Y="100" />
        </asp:ImageMap>
    </div>
    </form>
</body>
</html>
