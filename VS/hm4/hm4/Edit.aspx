<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Edit.aspx.cs" Inherits="hm4.Edit" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
        
        <asp:FormView ID="FormView1" runat="server" DataKeyNames="Cno,Tno" 
            ID="Sql1" 
            onpageindexchanging="FormView1_PageIndexChanging">
            <EditItemTemplate>
                Cno:
                <asp:Label ID="CnoLabel1" runat="server" Text='<%# Eval("Cno") %>' />
                <br />
                Cname:
                <asp:TextBox ID="CnameTextBox" runat="server" Text='<%# Bind("Cname") %>' />
                <br />
                Tno:
                <asp:Label ID="TnoLabel1" runat="server" Text='<%# Eval("Tno") %>' />
                <br />
                Gredit:
                <asp:TextBox ID="GreditTextBox" runat="server" Text='<%# Bind("Gredit") %>' />
                <br />
                cpno:
                <asp:TextBox ID="cpnoTextBox" runat="server" Text='<%# Bind("cpno") %>' />
                <br />
                <asp:LinkButton ID="UpdateButton" runat="server" CausesValidation="True" 
                    CommandName="Update" Text="更新" />
                &nbsp;<asp:LinkButton ID="UpdateCancelButton" runat="server" 
                    CausesValidation="False" CommandName="Cancel" Text="取消" />
            </EditItemTemplate>
            <InsertItemTemplate>
                Cno:
                <asp:TextBox ID="CnoTextBox" runat="server" Text='<%# Bind("Cno") %>' />
                <br />
                Cname:
                <asp:TextBox ID="CnameTextBox" runat="server" Text='<%# Bind("Cname") %>' />
                <br />
                Tno:
                <asp:TextBox ID="TnoTextBox" runat="server" Text='<%# Bind("Tno") %>' />
                <br />
                Gredit:
                <asp:TextBox ID="GreditTextBox" runat="server" Text='<%# Bind("Gredit") %>' />
                <br />
                cpno:
                <asp:TextBox ID="cpnoTextBox" runat="server" Text='<%# Bind("cpno") %>' />
                <br />
                <asp:LinkButton ID="InsertButton" runat="server" CausesValidation="True" 
                    CommandName="Insert" Text="插入" />
                &nbsp;<asp:LinkButton ID="InsertCancelButton" runat="server" 
                    CausesValidation="False" CommandName="Cancel" Text="取消" />
            </InsertItemTemplate>
            <ItemTemplate>
                Cno:
                <asp:Label ID="CnoLabel" runat="server" Text='<%# Eval("Cno") %>' />
                <br />
                Cname:
                <asp:Label ID="CnameLabel" runat="server" Text='<%# Bind("Cname") %>' />
                <br />
                Tno:
                <asp:Label ID="TnoLabel" runat="server" Text='<%# Eval("Tno") %>' />
                <br />
                Gredit:
                <asp:Label ID="GreditLabel" runat="server" Text='<%# Bind("Gredit") %>' />
                <br />
                cpno:
                <asp:Label ID="cpnoLabel" runat="server" Text='<%# Bind("cpno") %>' />
                <br />

                <asp:LinkButton ID="EditButton" runat="server" CausesValidation="False" 
                    CommandName="Edit" Text="编辑" />
                &nbsp;<asp:LinkButton ID="DeleteButton" runat="server" CausesValidation="False" 
                    CommandName="Delete" Text="删除" onclick="DeleteButton_Click" />
                &nbsp;<asp:LinkButton ID="NewButton" runat="server" CausesValidation="False" 
                    CommandName="New" Text="新建" />
                &nbsp;<asp:LinkButton ID="Back" runat="server" CausesValidation="False" 
                    Text="返回" onclick="Back_Click" />
            </ItemTemplate>
        </asp:FormView>
        <asp:Sql ID="Sql1" runat="server" 
            ConflictDetection="CompareAllValues" 
            ConnectionString="<%$ ConnectionStrings:ConnectionString %>" 
            DeleteCommand="DELETE FROM [course] WHERE [Cno] = ? AND [Tno] = ? AND [Cname] = ? AND (([Gredit] = ?) OR ([Gredit] IS NULL AND ? IS NULL)) AND (([cpno] = ?) OR ([cpno] IS NULL AND ? IS NULL))" 
            InsertCommand="INSERT INTO [course] ([Cno], [Cname], [Tno], [Gredit], [cpno]) VALUES (?, ?, ?, ?, ?)" 
            OldValuesParameterFormatString="original_{0}" 
            ProviderName="<%$ ConnectionStrings:ConnectionString.ProviderName %>" 
            SelectCommand="SELECT * FROM [course] WHERE ([Cno] = ?)" 
            UpdateCommand="UPDATE [course] SET [Cname] = ?, [Gredit] = ?, [cpno] = ? WHERE [Cno] = ? AND [Tno] = ? AND [Cname] = ? AND (([Gredit] = ?) OR ([Gredit] IS NULL AND ? IS NULL)) AND (([cpno] = ?) OR ([cpno] IS NULL AND ? IS NULL))">
            <DeleteParameters>
                <asp:Parameter Name="original_Cno" Type="Int32" />
                <asp:Parameter Name="original_Tno" Type="Int32" />
                <asp:Parameter Name="original_Cname" Type="String" />
                <asp:Parameter Name="original_Gredit" Type="Int32" />
                <asp:Parameter Name="original_Gredit" Type="Int32" />
                <asp:Parameter Name="original_cpno" Type="Int32" />
                <asp:Parameter Name="original_cpno" Type="Int32" />
            </DeleteParameters>
            <InsertParameters>
                <asp:Parameter Name="Cno" Type="Int32" />
                <asp:Parameter Name="Cname" Type="String" />
                <asp:Parameter Name="Tno" Type="Int32" />
                <asp:Parameter Name="Gredit" Type="Int32" />
                <asp:Parameter Name="cpno" Type="Int32" />
            </InsertParameters>
            <SelectParameters>
                <asp:QueryStringParameter Name="Cno" QueryStringField="Cno" Type="Int32" />
            </SelectParameters>
            <UpdateParameters>
                <asp:Parameter Name="Cname" Type="String" />
                <asp:Parameter Name="Gredit" Type="Int32" />
                <asp:Parameter Name="cpno" Type="Int32" />
                <asp:Parameter Name="original_Cno" Type="Int32" />
                <asp:Parameter Name="original_Tno" Type="Int32" />
                <asp:Parameter Name="original_Cname" Type="String" />
                <asp:Parameter Name="original_Gredit" Type="Int32" />
                <asp:Parameter Name="original_Gredit" Type="Int32" />
                <asp:Parameter Name="original_cpno" Type="Int32" />
                <asp:Parameter Name="original_cpno" Type="Int32" />
            </UpdateParameters>
        </asp:Sql>
        
    </div>
    </form>
</body>
</html>
