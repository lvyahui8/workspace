<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="e8-1.aspx.cs" Inherits="hm4.e8_1" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
        
        <asp:GridView ID="GridView1" runat="server" AllowPaging="True" 
            AllowSorting="True" AutoGenerateColumns="False" DataKeyNames="Cno,Tno" 
            ID="AccessDB">
            <Columns>
                <asp:BoundField DataField="Cno" HeaderText="课程号" ReadOnly="True" 
                    SortExpression="Cno" />
                <asp:BoundField DataField="Cname" HeaderText="课程名" SortExpression="Cname" />
                <asp:BoundField DataField="Tno" HeaderText="教师号" ReadOnly="True" 
                    SortExpression="Tno" />
                <asp:BoundField DataField="Gredit" HeaderText="学分" SortExpression="Gredit" />
                <asp:BoundField DataField="cpno" HeaderText="cpno" SortExpression="cpno" />
            </Columns>
        </asp:GridView>
        <asp:Access ID="AccessDB" runat="server" 
            DataFile="~/App_Data/Database4.mdb" onselecting="AccessDB_Selecting" 
            SelectCommand="SELECT * FROM [course]"></asp:Access>
        
    </div>
    </form>
</body>
</html>
