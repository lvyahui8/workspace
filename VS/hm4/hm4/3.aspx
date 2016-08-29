<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="3.aspx.cs" Inherits="hm4._3" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
    
        <asp:Sql ID="Sql1" runat="server" 
            ConnectionString="<%$ ConnectionStrings:ConnectionString %>" 
            ProviderName="<%$ ConnectionStrings:ConnectionString.ProviderName %>" 
            SelectCommand="SELECT * FROM [course]"></asp:Sql>
        <asp:GridView ID="GridView1" runat="server" AutoGenerateColumns="False" 
            DataKeyNames="Cno,Tno" ID="Sql1" 
            onselectedindexchanged="GridView1_SelectedIndexChanged">
            <Columns>
                <asp:CommandField SelectText="修改" ShowSelectButton="True" />
                <asp:BoundField DataField="Cno" HeaderText="Cno" ReadOnly="True" 
                    SortExpression="Cno" />
                <asp:BoundField DataField="Cname" HeaderText="Cname" SortExpression="Cname" />
                <asp:BoundField DataField="Tno" HeaderText="Tno" ReadOnly="True" 
                    SortExpression="Tno" />
                <asp:BoundField DataField="Gredit" HeaderText="Gredit" 
                    SortExpression="Gredit" />
                <asp:BoundField DataField="cpno" HeaderText="cpno" SortExpression="cpno" />
            </Columns>
        </asp:GridView>
    
    </div>
    </form>
</body>
</html>
