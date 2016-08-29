<%@ Page Title="主页" Language="C#" MasterPageFile="~/Site.master" AutoEventWireup="true"
    CodeBehind="Default.aspx.cs" Inherits="test01._Default" %>

<asp:Content ID="HeaderContent" runat="server" ContentPlaceHolderID="HeadContent">
</asp:Content>
<asp:Content ID="BodyContent" runat="server" ContentPlaceHolderID="MainContent">
    <form id="Form1" runat="server" defaultbutton="mybtn">
        <div>
            <select runat="server" id="List1" size="5" multiple="true"
                OnServerChange="List1_ServerChange">
                <option>Option1</option>
                <option>Option2</option>
            </select><br />
            <input type="text" runat="server" id="Textbox1" size="10" 
                OnServerChange="Ctrl_ServerChange"/> <br />
            <input type="checkbox" runat="server" id="Checkbox1" 
            OnServerChange="Ctrl_ServerChange" />
            Option text<br />
            <input type="submit" runat="server" id="Submit1" value="Submit Query" 
                OnServerClick="Submi1_ServerClick"
                />
            <asp:Button runat="Server" ID="mybtn" Text="hhhhh" />
        </div>
    </form>
</asp:Content>
