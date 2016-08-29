using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Web.UI.HtmlControls;

namespace test01
{
    public partial class _Default : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            Response.Write("Page_load");
            if (!Page.IsPostBack)
            {
                List1.Items.Add("Option 3");
                List1.Items.Add("Option 4");
                List1.Items.Add("Option 5");
            }
            if (!Page.IsPostBack) {
                /*
                Text1.Style["font-size"] = "20px";
                Text1.Style["color"] = "red";
                Text1.Style.Add("background-color", "lightyellow");
                Text1.value = "<Enter e-mail address here>";
                Text1.Attributes["onfocus"] = "alert(Text1.value)";
                 */
            }
            /*
            HtmlTable table1 = new HtmlTable();
            table1.Border = 1;
            table1.CellPadding = 3;
            table1.CellSpacing = 3;
            table1.BorderColor = "red";
            HtmlTableRow row;
            HtmlTableCell cell;
            for (int i = 1; i <= 5;i++ )
            {
                row = new HtmlTableRow();
                row.BgColor = (i % 2 == 0 ? "#00ffcc00" : "#44dd00aa");

                for (int j = 1; j <= 4;j++ )
                {
                    cell = new HtmlTableCell();
                    cell.InnerHtml = "Row: " + i.ToString() + "<br/>Cell: " + j.ToString();
                    row.Cells.Add(cell);
                }
                table1.Rows.Add(row);
            }
            this.Controls.Add(table1);
             * */
        }
        protected void Ctrl_ServerChange(object sender, System.EventArgs e)
        {
            Response.Write("<ul><li>ServerChange detected for " + ((Control)sender).ID + "</li></ul>");
        }

        protected void List1_ServerChange(object sender, System.EventArgs e)
        {
            Response.Write("<ul><li>ServerChange detected for List1.The selected items are:</li>");
            foreach (ListItem li in List1.Items)
            {
                if(li.Selected)
                    Response.Write("<li>" + li.Value + "</li>");
            }
            Response.Write("</ul>");
        }

        protected void Submi1_ServerClick(object sender, System.EventArgs e) { 
            
        }
    }
}
