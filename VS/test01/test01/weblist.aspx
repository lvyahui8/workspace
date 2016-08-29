<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="weblist.aspx.cs" Inherits="test01.weblist" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
        <asp:ListBox runat="Server" ID="Listbox1" SelectionMode="Multiple" Rows="5">
            <asp:ListItem Selected="True">Option 1</asp:ListItem>
            <asp:ListItem >Option 2</asp:ListItem>
        </asp:ListBox>
        <br />
        <asp:DropDownList runat="Server" ID="Dropdwonlist1">
            <asp:ListItem Selected="True" >Option 1</asp:ListItem>
            <asp:ListItem  >Option 2</asp:ListItem>
        </asp:DropDownList>
        <br />
        <asp:CheckBoxList runat="Server" ID="CheckboxList1" RepeatColumns="3">
            <asp:ListItem Selected="True" >Option 1</asp:ListItem>
            <asp:ListItem >Option 2</asp:ListItem>
        </asp:CheckBoxList>
        <br />
        <asp:RadioButtonList runat="Server" ID="RadiobuttonList1" RepeatDirection="Horizontal" RepeatColumns="2">
            <asp:ListItem Selected="True" >Option 1</asp:ListItem>
            <asp:ListItem >Option 2</asp:ListItem>
        </asp:RadioButtonList>
        <asp:Button ID="Button1" runat="Server" Text="Submit" OnClick="Button1_Click" />
    </div>
    </form>
</body>
</html>
